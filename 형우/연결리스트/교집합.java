import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class 교집합 {
    public static void main(String[] args) {
        // 1. LinkedList 자료구조 사용
        LinkedList<Integer> linkedList1 = new LinkedList<>(List.of(7, 1, 6));
        LinkedList<Integer> linkedList2 = new LinkedList<>(List.of(1, 9, 2, 6));
        System.out.println(getSameNode(linkedList1, linkedList2));

        // todo : LinkedList & 교집합 로직 구현
    }

    public static Set<Integer> getSameNode(LinkedList<Integer> linkedList1, LinkedList<Integer> linkedList2) {
        Set<Integer> values = new HashSet<>();
        Set<Integer> results = new HashSet<>();
        for (Integer value : linkedList1) {
            values.add(value);
        }

        for (Integer value : linkedList2) {
            if (values.contains(value)) {
                results.add(value);
            }
        }
        return results;
    }
}