package chapter2;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicateNodes {

    public boolean checkValid(Node node) {
        List<Integer> intList = NodeUtils.toList(node);
        return intList.size() == new HashSet<>(intList).size();
    }

    public void removeDuplicates(Node input) {

        Map<Integer, Boolean> itemMap = new HashMap<>();
        itemMap.put(input.data, true);

        Node testNode = input;
        while (testNode != null && testNode.hasNext()) {
            Node nextNode = testNode.next;
            if (itemMap.getOrDefault(nextNode.data, false)) {
                NodeUtils.removeNext(testNode);
                continue;
            }
            itemMap.put(nextNode.data, true);
            testNode = testNode.next;
        }
    }

    public void removeDuplicatesWithoutBuffer(Node input) {
        while (input != null) {
            Node testNode = input.next;
            int distanceFromInput = 1;
            while (testNode != null) {
                if (input.data == testNode.data) {
                    NodeUtils.removeByDistance(input, distanceFromInput);
                }
                distanceFromInput += 1;
                testNode = testNode.next;
            }
            input = input.next;
        }
    }
}
