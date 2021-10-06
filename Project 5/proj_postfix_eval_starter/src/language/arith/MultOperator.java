package language.arith;

import language.BinaryOperator;
import language.Operand;

/**
 * The {@code MultOperator} is an operator that performs multiplication on two integers.
 */
public class MultOperator extends BinaryOperator<Integer> {

  /** {@inheritDoc} */
  @Override
  public Operand<Integer> performOperation() {
    if (op0 == null || op1 == null) throw new IllegalStateException("Could not perform operation prior to operands being set.");
    
    Integer product = op0.getValue() * op1.getValue();
    return new Operand<Integer>(product);
  }

  public String toString() {
    return "*";
  }

}
