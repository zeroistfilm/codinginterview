import java.util.LinkedList;
import java.util.List;

public class 리스트의합 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>(List.of(7, 1, 6));
        LinkedList<Integer> linkedList2 = new LinkedList<>(List.of(5, 9, 2));

        int resultNumber = makeNumber(linkedList1, true) + makeNumber(linkedList2, true);
        System.out.println(resultNumber);
        System.out.println(makeLinkedList(resultNumber));
    }

    private static int makeNumber(LinkedList<Integer> linkedList, boolean reverseOrder) {
        int linkedListSize = linkedList.size();
        int number = 0;
        for (int i = 0; i < linkedListSize; i++) {
            int idx = reverseOrder ? i : linkedListSize - i - 1;
            number += linkedList.get(idx) * Math.pow(10, i);
        }
        return number;
    }

    private static LinkedList<Integer> makeLinkedList(int number) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (number != 0) {
            linkedList.addFirst(number % 10);
            number = number / 10;
        }
        return linkedList;
    }
}