package LinkedList;

public class BasicLinkedList {

  public static class Node {
    Node next = null;
    int data;
    public Node(int d) {
      this.data = d;
    }

    void appendToTail(int data) {
      Node end = new Node(data);
      Node now = this;
      while (now.next != null) {
        now = now.next;
      }
      now.next = end;
    }

    Node deleteNode(Node head, int data) {
      Node now = head;
      if (now.data == data) {
        return head.next;
      }

      while (now.next != null) {
        if (now.next.data == data) {
          now.next = now.next.next;
          return head;
        }
        now = now.next;
      }
      return head;
    }
  }
}
