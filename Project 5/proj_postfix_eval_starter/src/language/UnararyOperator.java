package language;

/**
 * A {@link UnararyOperator} is an {@link Operator} that performs an operation on one arguments.
 *
 * @param <T> they type of the {@link Operand} being evaluated
 */
public abstract class UnararyOperator<T> implements Operator<T> {

  protected Operand<T> uniOperand;

  /** {@inheritDoc} */
  @Override
  public final int getNumberOfArguments() {
    return 1;
  }

  @Override
  public void setOperand(int i, Operand<T> operand) {
    if(operand == null) {
      throw new NullPointerException("Could not set null operand.");
    }

    if(i > 0) {
      throw new IllegalArgumentException("Unarary operator only accepts operands 0 but recieved " + i + ".");
    }
    
    if(uniOperand !=  null){
     throw new IllegalStateException("Position " + i + " has been previously set.");
    }
    uniOperand = operand;

  }
}