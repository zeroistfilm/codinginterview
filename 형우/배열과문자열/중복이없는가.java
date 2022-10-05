import java.util.HashSet;
import java.util.Set;

public class 중복이없는가 {
    // 중복이 없는가?
    public static void main(String[] args) {
        String s = "abcda";
        System.out.println(isUnique(s));
    }

    public static boolean isUnique(String s) {
        Set<Character> chars = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (chars.contains(c)) {
                return false;
            }
            chars.add(c);
        }
        return true;
    }
}