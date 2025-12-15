package hexlet.code.utils;

import java.security.SecureRandom;

public class RandomNumberGenerator {

    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int MAX_RANDOM_NUMBER = 100;

    public static int getRandomInt() {
        return RANDOM.nextInt(MAX_RANDOM_NUMBER + 1);
    }
}
