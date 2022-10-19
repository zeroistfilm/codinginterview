package chapter4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PathSumTest {


    PathSum pathSum = new PathSum();

    @Test
    public void pathSumTest() {
        var node = new BinaryTree(3);
        var node2 = new BinaryTree(5);

        node.left = node2;

        Assertions.assertThat(pathSum.pathSum(node, 0, 8)).isEqualTo(1);
    }
}
