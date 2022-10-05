package LinkedList;

import java.util.LinkedList;

/**
 * 단방향 연결리스트가 주어졌을 때 중간(정확히 가운데 노드일필요는 없고 처음과 끝 노드만 아니면 된다)에 있는 노드 하나를
 * 삭제하는 알고리즘을 구현하라. 단, 삭제할 노드에만 접근할 수 있다.
 */
public class DeleteMiddleNode {

  /*
   * target은 input 안에 반드시 존재하며, 삭제 대상이다.
   */
  public static void play(LinkedList<String> input, String target) {
    input.removeFirstOccurrence(target);
  }

}
