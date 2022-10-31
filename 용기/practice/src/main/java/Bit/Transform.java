package Bit;

public class Transform {

  public static void main(String[] args) {
    int a = 29;
    int b = 15;
    boolean minus = false;

    if (a * b < 0) {
      a = Math.abs(a);
      b = Math.abs(b);
    }

    int mask = a ^ b;
    int bitCount = Integer.bitCount(mask);
    System.out.println(minus ? bitCount + 1 : bitCount);
  }
}
