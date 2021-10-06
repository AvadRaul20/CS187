package evaluator.arith;

import language.Operand;
import language.Operator;
import parser.IllegalPostfixExpressionException;
import parser.PostfixParser.Type;
import parser.Token;
import parser.arith.ArithPostfixParser;
import stack.LinkedStack;
import stack.StackInterface;
import evaluator.PostfixEvaluator;

/** An {@link ArithPostfixEvaluator} is a postfix evaluator over simple arithmetic expressions. */
public class ArithPostfixEvaluator implements PostfixEvaluator<Integer> {

  private final StackInterface<Operand<Integer>> stack;

  /** Constructs an {@link ArithPostfixEvaluator} */
  public ArithPostfixEvaluator() {
    stack = new LinkedStack<Operand<Integer>>();
  }

  /** {@inheritDoc} */
  @Override
  public Integer evaluate(String expr) throws IllegalPostfixExpressionException {
    ArithPostfixParser parser = new ArithPostfixParser(expr);
    for (Token<Integer> token : parser) {
      Type type = token.getType();
      switch (type) {
      case OPERAND:
          stack.push(token.getOperand());
          break;
      case OPERATOR:
          Operator<Integer> operator = token.getOperator();
          if(operator.getNumberOfArguments() == 1){
            operator.setOperand(0, stack.pop());
          }
          else{
            operator.setOperand(1, stack.pop());
            operator.setOperand(0, stack.pop());
          }
          Operand<Integer> finalAnswer = operator.performOperation();
          stack.push(finalAnswer);
          break;
      default:
          throw new IllegalStateException("Parser returned an invalid Type: " + type);
      }
    }
    Integer finalAnswer = stack.pop().getValue();
    if(!stack.isEmpty()){
      throw new IllegalPostfixExpressionException();
    }
    return finalAnswer;
  }
}
