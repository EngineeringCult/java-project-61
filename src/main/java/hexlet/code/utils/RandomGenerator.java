package hexlet.code.utils;

import hexlet.code.games.MathOperation;

import java.security.SecureRandom;

import static hexlet.code.games.MathOperation.VALUES;

public class RandomGenerator {

    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int MAX_RANDOM_NUMBER = 100;

    public static int getRandomInt() {
        return RANDOM.nextInt(MAX_RANDOM_NUMBER + 1);
    }

    public static MathOperation getRandomMathOperation() {
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }
}
