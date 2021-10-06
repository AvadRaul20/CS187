package app;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {
  
  private int size;
  private Node<T> head = null;

  public RecursiveList() {
    this.head = null;
    this.size = 0;
  }

  public RecursiveList(Node<T> first) {
    this.head = first;
    this.size = 1;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void insertFirst(T elem) {
      Node<T> temp = new Node<T>(elem, head);
      temp.setNext(head);
      head = temp;
      size++;
  }

  @Override
  public void insertLast(T elem) {
      Node<T> temp = new Node<T>(elem, null);

      if(head == null) head = temp;
      else insertLastHelper(head, temp);

      size++;
  }

  private void insertLastHelper(Node<T> currNode, Node<T> insertedNode){
    if(currNode.getNext() == null){
        currNode.setNext(insertedNode);
        return;
    }
    insertLastHelper(currNode.getNext(), insertedNode);
  }

  @Override
  public void insertAt(int index, T elem) {
      if(index < 0 || index > size) throw new IndexOutOfBoundsException();
      if(elem == null) throw new NullPointerException();

      Node<T> temp = new Node<T>(elem, head);

      if(index == 0){
        temp.setNext(head);
        head = temp;
      }
      else{
        insertAtHelper(head, temp, index);
      }
      size++;

  }
  
  private void insertAtHelper(Node<T> currNode, Node<T> insertNode, int index){
    if(index == 1){
        insertNode.setNext(currNode.getNext());
        currNode.setNext(insertNode);
      }
      else{
        insertAtHelper(currNode.getNext(), insertNode, index - 1);
      }
      
  }



  @Override
  public T removeFirst() {
    T removedItem = null;
    if(isEmpty()) throw new IllegalStateException();
    
    if(head == null) return null;
    removedItem = head.getData();
    head = head.getNext();
    size--;
  return removedItem;
  }

  @Override
  public T removeLast() {
    T removedItem = null;
    if(isEmpty()) throw new IllegalStateException();

    if(head == null) return removedItem;

    if(head.getNext() == null)return removeFirst();
    else return removeLastHelper(head);
  }

  public T removeLastHelper(Node<T> currentNode){
    if(currentNode.getNext().getNext() == null){
      T removedItem =currentNode.getNext().getData();
      currentNode.setNext(null);
			size--;
      return removedItem;
    }
    return removeLastHelper(currentNode.getNext());
  }

  @Override
  public T removeAt(int i) {
    T removedItem = null;
      if(i < 0 || i >= size) throw new IndexOutOfBoundsException();

      if(i == 0){
        removedItem = head.getData();
        head = head.getNext();
      }
      else{
        removedItem = removeAtHelper(head, i);
      }
      size--;
    return removedItem;
  }

  private T removeAtHelper(Node<T> currentNode, int index){
    if(index == 1){
      T removedItem = currentNode.getNext().getData();
      currentNode.setNext(currentNode.getNext().getNext());
      return removedItem;
    }
    return removeAtHelper(currentNode.getNext(), index - 1);
  }

  @Override
  public T getFirst() {
      T item = null;
      if(isEmpty()) throw new IllegalStateException();
      item = get(0);
    return item;
  }

  @Override
  public T getLast() {
      T item = null;
      if(isEmpty()) throw new IllegalStateException();

      item = get(size - 1);
    return item;
  }

  @Override
  public T get(int i) {
      T item = null;
      if( i < 0 || i >= size) throw new IndexOutOfBoundsException();

      item = getHelper(head, i);
      return item;
  }

  private T getHelper(Node<T> currentNode, int index){
      if(index == 0){
        return currentNode.getData();
      }
      return getHelper(currentNode.getNext(), index -1);

  }

  @Override
  public void remove(T elem) {
      int indexOfRemoval = indexOf(elem);
      if(elem == null){
        throw new NullPointerException();
      }
      if(indexOfRemoval == -1) {
        throw new ItemNotFoundException();
      }
      removeAt(indexOfRemoval);
  }

  @Override
  public int indexOf(T elem) {
    int index = 0;
    if(elem == null){
      throw new NullPointerException();
    }
    if(head.getData() == null){
      index = -1;
    }
    int a = index;
    index = indexOfHelper(head, elem, a);
    return index;
  }

  private int indexOfHelper(Node<T> currentNode, T searchElem, int index){
    int a = index;
    if(searchElem == null){ 
      throw new NullPointerException();
    }
    if(currentNode.getData().equals(searchElem)){
      return index;
    }
    if(currentNode.getNext() == null){
      return -1;
    }
    else{
      return indexOfHelper(currentNode.getNext(), searchElem, a+1);
    }
  }

  @Override
  public boolean isEmpty() {
    boolean empty = false;
    if(head == null) empty = true;
    return empty;
  }

  public Iterator<T> iterator() {
    Iterator<T> iter = null;

    iter = new LinkedNodeIterator<T>(head);
   return iter;
  }
}