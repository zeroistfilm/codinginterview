package TreeAndGraph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
}
