package LinkedList;

import java.util.List;

public class Grouping {

  public static void main(String[] args) {
    BasicLinkedList list = BasicLinkedList.of(List.of(10,1,9,2,8,7,2,5,4,6,1,2,7,6));

    System.out.printf("Before delete: %s%n", list);
    list.grouping(5);
    System.out.printf("After delete: %s%n", list);
  }
}
