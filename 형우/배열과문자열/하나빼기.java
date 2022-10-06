import java.util.HashMap;
import java.util.Map;

public class 하나빼기 {
    public static void main(String[] args) {
        System.out.println(isPossibleWithinOneTrial("pale, ple"));
        System.out.println(isPossibleWithinOneTrial("pales, pale"));
        System.out.println(isPossibleWithinOneTrial("pale, bale"));
        System.out.println(isPossibleWithinOneTrial("pale, bake"));
        System.out.println(isPossibleWithinOneTrial("pppe, pae"));
    }

    public static boolean isPossibleWithinOneTrial(String s) {
        String[] splitArr = s.split(", ");
        int diffLength = splitArr[0].length() - splitArr[1].length();
        if (diffLength >= 2) {
            return false;
        }
        if (diffLength == 1) {
            return insertOrDelete(splitArr);
        }
        if (diffLength == 0) {
            return exchange(splitArr);
        }
        throw new IllegalArgumentException();
    }

    private static boolean exchange(String[] splitArr) {
        char[] chars1 = splitArr[0].toCharArray();
        char[] chars2 = splitArr[1].toCharArray();
        int count = 0;
        for (int idx = 0; idx < chars1.length; idx++) {
            if (chars1[idx] != chars2[idx]) {
                count++;
            }
            if (count >= 2) {
                return false;
            }
        }
        return true;
    }

    private static boolean insertOrDelete(String[] splitArr) {
        Map<Character, Integer> chars = new HashMap<>();
        for (Character c : splitArr[0].toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }

        for (Character c : splitArr[1].toCharArray()) {
            if (chars.containsKey(c)) {
                chars.put(c, chars.get(c) - 1);
            }
        }
        return chars.values().stream().mapToInt(x -> x).sum() == 1;
    }
}