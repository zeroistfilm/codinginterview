package chapter2;

import java.util.ArrayList;
import java.util.List;

public class NodeUtils {

    public static Node from(List<Integer> intList) {
        if (intList.isEmpty()) {
            return null;
        }
        Node head = new Node(intList.get(0));
        int idx = 1;
        while(idx < intList.size()) {
            head.appendToTail(intList.get(idx));
            idx += 1;
        }
        return head;
    }

    public static List<Integer> toList(Node node) {
        List<Integer> allValues = new ArrayList<>();
        while(node.hasNext()) {
            allValues.add(node.data);
            node = node.next;
        }
        allValues.add(node.data);
        return allValues;
    }

    public static void removeNext(Node node) {
        node.next = node.next.next;
    }

    public static void removeByDistance(Node node, int distance) {
        int idx = 0;
        while (idx < distance - 1) {
            node = node.next;
            idx += 1;
        }
        removeNext(node);
    }
}
