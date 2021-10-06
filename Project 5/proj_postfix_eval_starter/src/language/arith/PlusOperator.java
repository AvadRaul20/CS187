package language.arith;

import language.BinaryOperator;
import language.Operand;

/** The {@code PlusOperator} is an operator that performs addition on two integers. */
public class PlusOperator extends BinaryOperator<Integer> {
  /** {@inheritDoc} */
  @Override
  public Operand<Integer> performOperation() {
    if (op0 == null || op1 == null) throw new IllegalStateException("Could not perform operation prior to operands being set.");
    
    Integer sum = op0.getValue() + op1.getValue();
    return new Operand<Integer>(sum);
  }

  public String toString() {
    return "+";
  }
}
