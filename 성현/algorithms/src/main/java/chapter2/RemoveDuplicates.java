package chapter2;

import java.util.*;

public class RemoveDuplicates {

    public boolean checkValid(List<Integer> intArr) {
        return intArr.size() == new HashSet(intArr).size();
    }

    public List<Integer> removeDuplicates(List<Integer> input) {
        Map<Integer, Boolean> intMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        for (Integer i : input) {
            if (intMap.getOrDefault(i, false)) {
                continue;
            }
            intMap.put(i, true);
            answer.add(i);
        }

        return answer;
    }

    public List<Integer> removeDuplicatesWithoutBuffer(int[] input) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(input);

        int inputSize = input.length;
        int i = 0;
        while (i < inputSize-2) {
            var item = input[i];
            var nextItem = input[i+1];
            if (item != nextItem) {
                answer.add(item);
            }
            i += 1;
        }

        if (isLastItemUnique(input)) {
            answer.add(input[inputSize-1]);
        }

        return answer;
    }

    private boolean isLastItemUnique(int[] input) {
        int inputSize = input.length;
        return inputSize > 1 && (input[inputSize-1] != input[inputSize-2]);
    }
}
