package language.arith;

import language.Operand;
import language.UnararyOperator;

/** The {@code NegateOperator} is an operator that performs negation on a single integer */

public class NegateOperator extends UnararyOperator<Integer> {

  /** {@inheritDoc} */
  @Override
  public Operand<Integer>performOperation(){
    if(uniOperand == null) throw new IllegalStateException("Could not perform operation prior to operands being set.");

    Integer result = uniOperand.getValue() * (-1);
    
    return new Operand<Integer>(result);
  }
  public String toString(){
    return "!";
  }
}
