package chapter2;

import chapter2.RemoveDuplicates;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicatesTest {

    RemoveDuplicates sut = new RemoveDuplicates();

    @Test
    void testCheckValid() {
        var input1 = List.of(1, 2, 3, 4, 4);
        var input2 = List.of(1, 2, 3, 4);

        var answer = sut.checkValid(input1);
        var answer1 = sut.checkValid(input2);

        assertThat(answer).isEqualTo(false);
        assertThat(answer1).isEqualTo(true);
    }


    @Test
    void testRemoveDuplicates() {
        var input0 = List.of(1);
        var input1 = List.of(1, 2, 3, 4);
        var input2 = List.of(1, 1, 2, 3, 4);
        var input3 = List.of(1, 2, 3, 3, 3, 4);
        var input4 = List.of(1, 2, 3, 4, 5, 5, 7, 1);
        var input5 = List.of(1, 1);

        input0 = sut.removeDuplicates(input0);
        input1 = sut.removeDuplicates(input1);
        input2 = sut.removeDuplicates(input2);
        input3 = sut.removeDuplicates(input3);
        input4 = sut.removeDuplicates(input4);
        input5 = sut.removeDuplicates(input5);

        var answer0 = sut.checkValid(input0);
        var answer1 = sut.checkValid(input1);
        var answer2 = sut.checkValid(input2);
        var answer3 = sut.checkValid(input3);
        var answer4 = sut.checkValid(input4);
        var answer5 = sut.checkValid(input5);

        assertThat(answer0).isEqualTo(true);
        assertThat(answer1).isEqualTo(true);
        assertThat(answer2).isEqualTo(true);
        assertThat(answer3).isEqualTo(true);
        assertThat(answer4).isEqualTo(true);
        assertThat(answer5).isEqualTo(true);
    }

    @Test
    void checkValidWithoutBuffer() {
        int[] input0 = {1};
        int[] input1 = {1, 2, 3, 4};
        int[] input2 = {1, 1, 2, 3, 4};
        int[] input3 = {1, 2, 3, 3, 3, 4};
        int[] input4 = {1, 2, 3, 4, 5, 5, 7, 1};
        int[] input5 = {1, 1};

        List<Integer> result0 = sut.removeDuplicatesWithoutBuffer(input0);
        List<Integer> result1  = sut.removeDuplicatesWithoutBuffer(input1);
        List<Integer> result2  = sut.removeDuplicatesWithoutBuffer(input2);
        List<Integer> result3  = sut.removeDuplicatesWithoutBuffer(input3);
        List<Integer> result4  = sut.removeDuplicatesWithoutBuffer(input4);
        List<Integer> result5  = sut.removeDuplicatesWithoutBuffer(input5);

        var answer0 = sut.checkValid(result0);
        var answer1 = sut.checkValid(result1);
        var answer2 = sut.checkValid(result2);
        var answer3 = sut.checkValid(result3);
        var answer4 = sut.checkValid(result4);
        var answer5 = sut.checkValid(result5);

        assertThat(answer0).isEqualTo(true);
        assertThat(answer1).isEqualTo(true);
        assertThat(answer2).isEqualTo(true);
        assertThat(answer3).isEqualTo(true);
        assertThat(answer4).isEqualTo(true);
        assertThat(answer5).isEqualTo(true);
    }
}