package chapter5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BitFlipTest {

    BitFlip sut = new BitFlip();

    @Test
    void getMaximumLengthOfContinuous1WithOnceBitFlip() {
        int answer1 = sut.getMaximumLengthOfContinuous1WithOnceBitFlip(1775);
        int answer2 = sut.getMaximumLengthOfContinuous1WithOnceBitFlip(0);
        int answer3 = sut.getMaximumLengthOfContinuous1WithOnceBitFlip(2);

        assertThat(answer1).isEqualTo(8);
        assertThat(answer2).isEqualTo(1);
        assertThat(answer3).isEqualTo(2);
    }

    @Test
    void testXor() {
        assertThat(4^0).isEqualTo(4);
    }
}