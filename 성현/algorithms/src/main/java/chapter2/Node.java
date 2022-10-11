package chapter2;

public class Node{

    Node next = null;

    int data;

    public Node(int data) {
        this.data = data;
    }

    public boolean hasNext() {
        return this.next != null;
    }
}
