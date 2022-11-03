package chapter5;

import org.javatuples.Pair;

public class BitFlip {

    public int getMaximumLengthOfContinuous1WithOnceBitFlip(int input) {
        int answer = 0;
        int firstMax = 0;
        int secondMax = 0;

        if (input < 2) {
            return 1;
        }

        while (input > 0) {
            Pair<Integer, Integer> firstMaxResult =  shiftBit(input);
            input = firstMaxResult.getValue0();
            firstMax = firstMaxResult.getValue1();

            Pair<Integer, Integer> secondMaxResult =  shiftBit(input);
            input = secondMaxResult.getValue0();
            secondMax = secondMaxResult.getValue1();

            int sum = firstMax + 1 + secondMax;
            answer = Math.max(sum, answer);
        }

        return answer;
    }

    private Pair<Integer, Integer> shiftBit(int input) {
        int max = 0;
        while (true) {
            if (input % 2 == 1) {
                max += 1;
                input = input >> 1;
            } else {
                input = input >> 1;
                break;
            }
        }
        return new Pair<>(input, max);
    }
}
