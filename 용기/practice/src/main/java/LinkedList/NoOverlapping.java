package LinkedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 정렬되어 있지 않은 연결리스트가 주어졌을 때 이 리스트에서 중복되는 워소를 제거하는 코드를 작성하라.
 */
public class NoOverlapping {

  /*
   * 임시 버퍼 사용하기
   */
  public static void play(LinkedList<String> input) {
    Map<String, Boolean> buffer = new HashMap<>();

    for (int i = 0; ; ) {
      if (i >= input.size()) {
        break;
      }
      String key = input.get(i);
      if (!buffer.getOrDefault(key, false)) {
        buffer.put(input.get(i), true);
        i++;
      } else {
        input.remove(i);
      }
    }
  }
}
