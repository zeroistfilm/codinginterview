package Bit;

public class Transform {

  public static void main(String[] args) {
    int a = 29;
    int b = 15;

    int mask = a ^ b;
    System.out.println(Integer.bitCount(mask));
  }
}
