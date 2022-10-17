package chapter3;

import java.util.EmptyStackException;

public class MyStack<T> {

    private StackNode<T> top;
    private StackNode<T> bottom;

    private static class StackNode<T> {
        private T data;
        private StackNode next;

        public StackNode (T data) {
            this.data = data;
        }
    }

    public T pop() {
        if (this.top == null) {
            throw new EmptyStackException();
        }
        T item = this.top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode t = new StackNode(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
