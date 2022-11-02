package chapter5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BitFlipTest {

    BitFlip sut = new BitFlip();

    @Test
    void getMaximumLengthOfContinuous1WithOnceBitFlip() {
        int answer = sut.getMaximumLengthOfContinuous1WithOnceBitFlip(1775);

        assertThat(answer).isEqualTo(8);
    }

    @Test
    void testXor() {
        assertThat(4^0).isEqualTo(4);
    }
}