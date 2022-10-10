package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 단방향 연결리스트 두 개가 주어졌을 때 이 두 리스트의 교집합 노드를 찾은 뒤 반환하는 코드를 작성하라.
 * 여기서 교집합이란 노드의 값이 아니라 노드의 주소가 완전히 같은 경우를 말한다.
 * 즉, 첫번째 리스트에 있는 k번째 노드와 두 번째 리스트에 있는 j번째 노드가 주소까지 완전히 같다면 이 노드는 교집합의 원수가 된다.
 */
public class Intersection {

  public static void play(LinkedList<Node> inputA, LinkedList<Node> inputB) {
    Map<Node, Boolean> buffer = new HashMap<>();

    for (Node node : inputA) {
      buffer.put(node, true);
    }

    List<Node> answer = new ArrayList<>();
    for (Node node : inputB) {
      if (buffer.containsKey(node)) {
        answer.add(node);
      }
    }
  }

  public static class Node {

  }
}
