package StackAndQueue;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;


public class BasicStack<T> {

  private StackNode<T> top;

  public BasicStack(T data) {
    this.top = new StackNode<>(data);
  }

  public T pop() {
    if (top == null) throw new EmptyStackException();
    T item = top.data;
    top = top.next;
    return item;
  }

  public void push(T item) {
    StackNode<T> t = new StackNode<>(item);
    t.next = top;
    top = t;
  }

  public T peek() {
    if (top == null) throw new EmptyStackException();
    return top.data;
  }

  @Override
  public String toString() {
    StackNode<T> now = top;
    List<String> stringList = new LinkedList<>();
    while (now != null) {
      stringList.add(now.toString());
      now = now.next;
    }
    return String.join(", ", stringList);
  }

  public boolean isEmpty() {
    return top == null;
  }

  private static class StackNode<T> {
    private T data;
    private StackNode<T> next;

    private StackNode(T data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return data.toString();
    }
  }
}
