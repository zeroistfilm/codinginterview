package LinkedList;

/**
 * 정렬되어 있지 않은 연결리스트가 주어졌을 때 이 리스트에서 중복되는 워소를 제거하는 코드를 작성하라.
 * 단, 임시버퍼는 사용하지마라.
 */
public class NoOverlapping {

  public static void main(String[] args) {
    BasicLinkedList list = new BasicLinkedList(0);
    for (int i = 1; i <= 10; i++) {
      list.append(i);
    }
    for (int i = 1; i <= 10; i++) {
      list.append(i);
    }
    System.out.printf("Before delete: %s%n", list);
    list.deleteOverlappedData();
    System.out.printf("After delete: %s%n", list);
  }
}
