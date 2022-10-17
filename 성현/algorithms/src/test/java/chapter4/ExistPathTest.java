package chapter4;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExistPathTest {

    ExistPath existPath = new ExistPath();

    @Test
    void existPath() {
        List<List<Integer>> adjacentList = sampleAdjacentList();

        var result0 = existPath.ExistPath(adjacentList, 0, 0);
        var result1 = existPath.ExistPath(adjacentList, 1, 2);
        var result2 = existPath.ExistPath(adjacentList, 0, 3);

        Assertions.assertThat(result0).isEqualTo(true);
        Assertions.assertThat(result1).isEqualTo(true);
        Assertions.assertThat(result2).isEqualTo(false);
    }


    List<List<Integer>> sampleAdjacentList() {
        return List.of(
                List.of(0, 1),
                List.of(1, 2),
                List.of(1, 2, 3),
                List.of(0)
        );
    }
}