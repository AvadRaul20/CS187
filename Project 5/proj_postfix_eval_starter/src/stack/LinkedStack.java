package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure to allow for
 * unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {

  private LLNode<T> top; 
  private int size;

  /** {@inheritDoc} */
  @Override
  public T pop() throws StackUnderflowException {
    // TODO: Implement the stack operation for `pop`!
    if(!isEmpty()){
      T pop = top.getData();
      top = top.getNext();
      size--;
      return pop;
    }
    else{
      throw new StackUnderflowException("stack is empty");
    }
  }

  /** {@inheritDoc} */
  @Override
  public T top() throws StackUnderflowException {
    // TODO: Implement the stack operation for `top`!
    if(!isEmpty()){
      T topElem = top.getData();
      return topElem;
    }
    else{
      throw new StackUnderflowException();
    }
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmpty() {
    // TODO: Implement the stack operation for `isEmpty`!
    boolean isEmpty = false;
    if(size == 0){
      isEmpty = true;
    }
    return isEmpty;
  }

  /** {@inheritDoc} */
  @Override
  public int size() {
    // TODO: Implement the stack operation for `size`!
    return size;
  }

  /** {@inheritDoc} */
  @Override
  public void push(T elem) {
    // TODO: Implement the stack operation for `push`!
    LLNode<T> push = new LLNode<T>(elem);
    push.setNext(top);
    top = push;
    size++;
  }
}
