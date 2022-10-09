package LinkedList;

public class BasicLinkedList {

  Node head;

  public BasicLinkedList(int initData) {
    this.head = new Node(initData);
  }

  public void append(int data) {
    head.appendToTail(data);
  }

  public void delete(int data) {
    head = head.deleteNode(this.head, data);
  }

  private static class Node {
    Node next = null;
    int data;
    private Node(int d) {
      this.data = d;
    }

    private void appendToTail(int data) {
      Node end = new Node(data);
      Node now = this;
      while (now.next != null) {
        now = now.next;
      }
      now.next = end;
    }

    private Node deleteNode(Node head, int data) {
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
