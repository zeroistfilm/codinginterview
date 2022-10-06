import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class 중복없애기 {
    // 중복 없개기
    // todo : 임시 버퍼 없이 푸는 방법
    public static void main(String[] args) {
        // LinkedList 자료구조 이용
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(List.of(2, 4, 1, 3, 5, 1));
        removeDup(linkedList);
        System.out.println(linkedList);
    }

    public static void removeDup(LinkedList<Integer> linkedList) {
        Set<Integer> numbers = new HashSet<>();
        linkedList.removeIf(number -> {
            if (numbers.contains(number)) {
                return true;
            }
            numbers.add(number);
            return false;
        });
    }
}