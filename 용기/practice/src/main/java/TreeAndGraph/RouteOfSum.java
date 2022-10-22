package TreeAndGraph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 4-12 합의 경로 : 각 노드의 값이 정수(음수 및 양수)인 이진 트리가 있다. 이때 정수의 합이 특정 값이 되도록 하는 경로의 개수를 세려고 한다. 경로가 꼭 루트에서
 * 시작해서 말단 노드에서 끝날 필요는 없지만 반드시 아래로 내려가야 한다. 즉, 부모 노드에서 자식 노드로만 움직일 수 있다. 알고리즘을 어떻게 설계할 것인가?
 */
public class RouteOfSum {

  public static void main(String[] args) {
    Random random = new Random();
    int wanted = 5;
    BinaryTree tree = new BinaryTree(random.nextInt(5));
    for (int i = 0; i < 6; i++) {
      tree.append(random.nextInt(5));
    }

    tree.printTree();
    System.out.printf("The Wanted is %s\n", wanted);
    System.out.print("The Answer is ");
    System.out.println(tree.equalsTo(wanted));
  }

  /*
   * 각 노드는 sumOfEdges()를 통해 트리의 정보를 상위 노드로 올려보낸다.
   * toBeAdded 는 상단 노드의 값을 더해줄 하위 노드들의 값의 합이다.
   * preserved 는 상단 노드의 값을 더해주지 말아야하는 하위 노드들의 값의 합이다.
   */
  public static class ResultOfNode {

    private final List<Integer> toBeAdded;
    private final List<Integer> preserved;

    public ResultOfNode(Integer nodeData) {
      this(List.of(nodeData));
    }

    public ResultOfNode(List<Integer> toBeAdded) {
      this(toBeAdded, Collections.emptyList());
    }

    public ResultOfNode(List<Integer> toBeAdded, List<Integer> preserved) {
      this.toBeAdded = toBeAdded;
      this.preserved = preserved;
    }

    public int count(int wanted) {
      int result = 0;
      for (Integer computed : preserved) {
        if (wanted == computed) {
          result++;
        }
      }
      return result;
    }
  }

  public static class BinaryNode {

    private final Integer data;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(Integer data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }

    public boolean isLeaf() {
      return left == null && right == null;
    }

    public void append(Integer data) {
      if (left == null) {
        left = new BinaryNode(data);
      } else if (right == null) {
        right = new BinaryNode(data);
      } else if (new Random().nextBoolean()) {
        left.append(data);
      } else {
        right.append(data);
      }
    }

    public ResultOfNode sumOfEdges() {
      if (isLeaf()) {
        return new ResultOfNode(this.data);
      }

      List<ResultOfNode> sumFromLower = new LinkedList<>();
      if (this.left != null) {
        sumFromLower.add(left.sumOfEdges());
      }

      if (this.right != null) {
        sumFromLower.add(right.sumOfEdges());
      }

      // 중요한 것은 밑에서 올라온 합계들을 보존하면서 이 노드의 값을 더한 값이 새로 생성되어야한다는 점이다.
      List<Integer> toBeAdded = new LinkedList<>();
      List<Integer> preserved = new LinkedList<>();
      toBeAdded.add(this.data);
      preserved.add(this.data);
      for (ResultOfNode result : sumFromLower) {
        preserved.addAll(result.preserved);
        for (Integer add : result.toBeAdded) {
          int sum = this.data + add;
          preserved.add(sum);
          toBeAdded.add(sum);
        }
      }
      return new ResultOfNode(toBeAdded, preserved);
    }

    public void print(int space, int height) {
      space += height;

      if (right != null) {
        this.right.print(space, height);
      }
      System.out.println();

      for (int i = height; i < space; i++) {
        System.out.print(' ');
      }

      System.out.print(this.data);

      System.out.println();
      if (left != null) {
        left.print(space, height);
      }
    }
  }

  public static class BinaryTree {

    private final BinaryNode root;

    public BinaryTree(Integer rootData) {
      this.root = new BinaryNode(rootData);
    }

    public void append(Integer data) {
      this.root.append(data);
    }

    public Integer equalsTo(Integer wanted) {
      return root.sumOfEdges().count(wanted);
    }

    public void printTree() {
      root.print(0, 10);
    }
  }
}
