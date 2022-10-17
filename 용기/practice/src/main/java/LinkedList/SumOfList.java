package LinkedList;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 연결리스트로 숫자를 표현할 때 각 노드가 자릿수 하나를 가리키는 방식으로 표현할 수 있ㄷ. 각 숫자는 역순으로 배열되어 있는데,
 * 첫번째 자릿수가 리스트의 맨 앞에 위치하도록 배열된다는 뜻이다. 이와같은 방식으로 표현된 숫자 두 개가 있을 때, 이 두 수를
 * 더하여 그 합을 연결리스트로 반환하는 함수를 작성하라.
 */
public class SumOfList {

  public static void play(LinkedList<Integer>... inputs) {
    Integer sumOfAllList = 0;
    for (LinkedList<Integer> linkedList: inputs) {
      sumOfAllList += sum(linkedList);
    }

    LinkedList<Integer> answer = split(sumOfAllList);
  }

  private static Integer sum(LinkedList<Integer> integers) {
    int sum = 0;
    for (int i = 0; i < integers.size(); i++) {
      sum += (int) Math.pow(10, i) * integers.get(i);
    }
    return sum;
  }

  private static LinkedList<Integer> split(Integer integer) {
    LinkedList<Integer> answer = new LinkedList<>();
    while (integer > 0) {
      answer.add(integer % 10);
      integer /= 10;
    }
    return answer;
  }
}
