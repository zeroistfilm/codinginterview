import java.util.EmptyStackException;

public class CustomStack<T> {
    Node<T> top;

    T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    void push(T item) {
        Node<T> t = new Node<>(item);
        t.next = top;
        top = t;
    }

    T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }

    CustomStack<T> sort() {
        CustomStack<T> stack = new CustomStack<>();
        while (!this.isEmpty()) {
            T temp = this.pop();
            while (!stack.isEmpty() && (int) stack.peek() > (int) temp) { // verify integer
                this.push(stack.pop());
            }
            stack.push(temp);
        }

        while (!stack.isEmpty()) {
            this.push(stack.pop());
        }
        return this;
    }

    class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }
}
