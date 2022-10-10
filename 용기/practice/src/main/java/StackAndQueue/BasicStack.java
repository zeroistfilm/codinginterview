package StackAndQueue;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class BasicStack<T> {

  private StackNode<T> top;

  public BasicStack(T init) {
    this.top = new StackNode<>(init);
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

  public boolean isEmpty() {
    return top == null;
  }

  @Override
  public String toString() {
    List<String> list = new LinkedList<>();
    StackNode<T> now = this.top;
    while (now != null) {
      list.add(now.toString());
      now = now.next;
    }
    return String.join(", ", list);
  }

  private static class StackNode<T> {
    private T data;
    private StackNode<T> next;

    public StackNode(T data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return data.toString();
    }
  }

}
