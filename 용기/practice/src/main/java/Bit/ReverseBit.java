package Bit;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 비트 뒤집기 : 어떤 정수가 주어졌을 때 여러분으 이 정수의 비트 하나를 0에서 1로 바꿀 수 있다. 이때 1이 연속으로 나올수 있는 가장 긴 길이를 구하여라.
 */
public class ReverseBit {

  public static void main(String[] args) {
    int input = 1775;
    int cur = input;
    int length = 0;
    List<Integer> bitLengthList = new LinkedList<>();

    while (cur > 0) {
      int remainder = cur % 2;
      if (remainder == 1) {
        length += 1;
      } else {
        bitLengthList.add(length);
        length = 0;
      }
      cur = cur / 2;
    }

    if (length > 0) {
      bitLengthList.add(length);
    }

    bitLengthList = bitLengthList.stream()
        .sorted()
        .collect(Collectors.toList());
    Collections.reverse(bitLengthList);

    int answer;
    if (bitLengthList.size() < 2) {
      answer = bitLengthList.get(0);
    } else {
      answer = bitLengthList.get(0) + bitLengthList.get(1) + 1;
    }

    System.out.println(answer);
  }
}
