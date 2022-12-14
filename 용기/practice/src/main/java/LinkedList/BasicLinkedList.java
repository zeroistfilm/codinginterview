package LinkedList;

import java.util.List;

public class BasicLinkedList {

  Node head;

  public BasicLinkedList(int initData) {
    this.head = new Node(initData);
  }

  public static BasicLinkedList of(List<Integer> list) {
    if (list.isEmpty()) throw new IllegalArgumentException();
    BasicLinkedList linkedList = new BasicLinkedList(list.get(0));
    for (Integer i : list.subList(1, list.size())) {
      linkedList.append(i);
    }
    return linkedList;
  }

  public void append(int data) {
    head.appendToTail(data);
  }

  public void delete(int data) {
    head = head.deleteNode(this.head, data);
  }

  /*
   * LinkedList 내의 중복된 요소들을 제거한다. 임시 버퍼는 사용하지 않는다.
   */
  public void deleteOverlappedData() {
    Node now = head;
    while (now != null) {
      deleteOverlappedData(now, now.data);
      now = now.next;
    }
  }

  private void deleteOverlappedData(Node head, int target) {
    /*
     * 현재 Node의 data와 중복된 요소들을 제거한다.
     * now(현재 Node)는 삭제되면 안되므로, now 다음 Node부터 순회를 시작한다.
     * LinkedList의 끝까지 순회를 실시한다.
     */
    Node now = head;
    Node next = now.next;
    while (next != null) {
      if (next.data == target) {
        now.next = next.next;
      }
      next = next.next;
      now = now.next;
    }
  }

  public void grouping(int criterion) {
    Node traversePtr = head;
    Node lowPtr = head;

    /*
     * 만약 순회하다가 기준보다 낮은 값을 만나면 lowPtr가 head부터 순회하면서 낮은 값과 교환할 높은 값을 찾는다.
     * 만약 lowPtr 이 대상을 못찾고 traversePtr을 조우한다면 대상이 없으므로 스킵한다. 
     */
    while (traversePtr != null) {
      if (traversePtr.data < criterion) {
        while (lowPtr != traversePtr) {
          if (lowPtr.data >= criterion) {
            exchange(lowPtr, traversePtr);
            break;
          }
          lowPtr = lowPtr.next;
        }
      }
      traversePtr = traversePtr.next;
    }
  }

  private void exchange(Node source, Node target) {
    int sourceData = source.data;

    source.data = target.data;
    target.data = sourceData;
  }

  @Override
  public String toString() {
    StringBuilder buffer = new StringBuilder();
    Node now = head;
    while (now != null) {
      buffer.append(now).append(", ");
      now = now.next;
    }
    return buffer.toString();
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

    @Override
    public String toString() {
      return String.valueOf(data);
    }
  }
}
