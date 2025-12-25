package hexlet.code.games;

import hexlet.code.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static hexlet.code.games.Engine.ROUNDS;

public class Prime {

    private static final String YES = "yes";
    private static final String NO = "no";
    private static final String PRIME_MAIN_QUESTION = "Answer '%s' if given number is prime. Otherwise answer '%s'."
            .formatted(YES, NO);

    public static void run() {
        Engine.run(PRIME_MAIN_QUESTION, getExpressionResults());
    }

    private static List<ExpressionResult> getExpressionResults() {
        List<ExpressionResult> expressionResults = new ArrayList<>();
        for (int i = 0; i < ROUNDS; i++) {
            expressionResults.add(getExpressionResult());
        }
        return expressionResults;
    }

    private static ExpressionResult getExpressionResult() {
        int randomInt = RandomGenerator.getRandomInt();
        String correctAnswer = isPrime(randomInt) ? YES : NO;
        return new ExpressionResult(
                String.valueOf(randomInt),
                correctAnswer);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);

        final int firstOddDivisor = 3;
        for (int i = firstOddDivisor; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
