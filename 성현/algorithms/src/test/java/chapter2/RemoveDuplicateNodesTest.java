package chapter2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicateNodesTest {

    RemoveDuplicateNodes sut = new RemoveDuplicateNodes();

    @Test
    void testCheckValid() {
        Node input0 = NodeUtils.from(List.of(1, 2, 3));
        Node input1 = NodeUtils.from(List.of(1, 2, 3, 3));

        var result0 = sut.checkValid(input0);
        var result1 = sut.checkValid(input1);
        Assertions.assertThat(result0).isEqualTo(true);
        Assertions.assertThat(result1).isEqualTo(false);
    }

    @Test
    void testRemoveDuplicates() {
        Node input0 = NodeUtils.from(List.of(1, 2, 3));
        Node input1 = NodeUtils.from(List.of(3, 3));
        Node input2 = NodeUtils.from(List.of(1, 2, 3, 3, 1));
        Node input3 = NodeUtils.from(List.of(1));
        Node input4 = NodeUtils.from(List.of(1, 2));

        sut.removeDuplicates(input0);
        sut.removeDuplicates(input1);
        sut.removeDuplicates(input2);
        sut.removeDuplicates(input3);
        sut.removeDuplicates(input4);

        var result0 = sut.checkValid(input0);
        var result1 = sut.checkValid(input1);
        var result2 = sut.checkValid(input2);
        var result3 = sut.checkValid(input3);
        var result4 = sut.checkValid(input4);

        Assertions.assertThat(result0).isEqualTo(true);
        Assertions.assertThat(result1).isEqualTo(true);
        Assertions.assertThat(result2).isEqualTo(true);
        Assertions.assertThat(result3).isEqualTo(true);
        Assertions.assertThat(result4).isEqualTo(true);
    }

    @Test
    void testRemoveDuplicatesWithoutBuffer() {
        Node input0 = NodeUtils.from(List.of(1, 2, 3));
        Node input1 = NodeUtils.from(List.of(3, 3));
        Node input2 = NodeUtils.from(List.of(1, 2, 3, 3, 1));
        Node input3 = NodeUtils.from(List.of(1));
        Node input4 = NodeUtils.from(List.of(1, 2));

        sut.removeDuplicatesWithoutBuffer(input0);
        sut.removeDuplicatesWithoutBuffer(input1);
        sut.removeDuplicatesWithoutBuffer(input2);
        sut.removeDuplicatesWithoutBuffer(input3);
        sut.removeDuplicatesWithoutBuffer(input4);

        var result0 = sut.checkValid(input0);
        var result1 = sut.checkValid(input1);
        var result2 = sut.checkValid(input2);
        var result3 = sut.checkValid(input3);
        var result4 = sut.checkValid(input4);

        Assertions.assertThat(result0).isEqualTo(true);
        Assertions.assertThat(result1).isEqualTo(true);
        Assertions.assertThat(result2).isEqualTo(true);
        Assertions.assertThat(result3).isEqualTo(true);
        Assertions.assertThat(result4).isEqualTo(true);
    }
}