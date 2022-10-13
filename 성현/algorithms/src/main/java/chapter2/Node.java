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

    public Node getTail() {
        Node tail = this;
        while(tail.hasNext()) {
            tail = tail.next;
        }
        return tail;
    }

    public void appendToTail(int d) {
        Node end = new Node(d);
        Node tail = this.getTail();
        tail.next = end;
    }
}
