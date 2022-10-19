package chapter4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PathSumTest {


    PathSum pathSum = new PathSum();

    @Test
    public void pathSumTest() {
        var node = new BinaryTree(3);
        var node2 = new BinaryTree(5);
        var node3 = new BinaryTree(-3);
        var node4 = new BinaryTree(8);

        node.left = node2;
        node.right = node3;
        node3.right = node4;

        Assertions.assertThat(pathSum.pathSum(node, 0, 8)).isEqualTo(2);
    }
}
