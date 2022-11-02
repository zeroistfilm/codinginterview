package chapter5;

public class CountDifferentBits {

    public long countDifferentBits(int a, int b) {
        String result = Integer.toBinaryString(a ^ b);
        return result.chars().filter(ch -> ch == '1').count();
    }
}
