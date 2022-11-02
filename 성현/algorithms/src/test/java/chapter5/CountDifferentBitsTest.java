package chapter5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountDifferentBitsTest {

    CountDifferentBits sut = new CountDifferentBits();

    @Test
    void countDifferentBits() {
        var result = sut.countDifferentBits(29, 15);
        assertThat(result).isEqualTo(2);
    }
}