package chapter2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DivideListTest {

    DivideList sut = new DivideList();

    @Test
    void testCheckValid() {
        Node input0 = NodeUtils.from(List.of(7, 2, 3));
        Node input1 = NodeUtils.from(List.of(1, 2, 3));

        var result0 = sut.checkValid(input0, 3);
        var result1 = sut.checkValid(input1, 2);

        Assertions.assertThat(result0).isEqualTo(false);
        Assertions.assertThat(result1).isEqualTo(true);
    }

    @Test
    void divideList() {
        Node input0 = NodeUtils.from(List.of(3, 5, 8, 5, 10, 2, 1));

        input0 = sut.divideList(input0, 5);

        var result0 = sut.checkValid(input0, 5);

        Assertions.assertThat(result0).isEqualTo(true);
    }
}