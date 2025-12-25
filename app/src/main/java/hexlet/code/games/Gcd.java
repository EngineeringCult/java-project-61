package hexlet.code.games;

import hexlet.code.utils.RandomGenerator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static hexlet.code.games.Engine.ROUNDS;

public class Gcd {

    private static final String GCD_MAIN_QUESTION = "Find the greatest common divisor of given numbers.";
    private static final String GCD_EXPRESSION_TEMPLATE = "%s %s";

    public static void run() {
        Engine.run(GCD_MAIN_QUESTION, getExpressionResults());
    }

    private static List<ExpressionResult> getExpressionResults() {
        List<ExpressionResult> expressionResults = new ArrayList<>();
        for (int i = 0; i < ROUNDS; i++) {
            expressionResults.add(getExpressionResult());
        }
        return expressionResults;
    }

    private static ExpressionResult getExpressionResult() {
        int firstRandomInt = RandomGenerator.getRandomInt();
        int secondRandomInt = RandomGenerator.getRandomInt();
        int correctAnswer = BigInteger.valueOf(firstRandomInt)
                .gcd(BigInteger.valueOf(secondRandomInt))
                .intValue();
        return new ExpressionResult(
                GCD_EXPRESSION_TEMPLATE.formatted(firstRandomInt, secondRandomInt),
                String.valueOf(correctAnswer));
    }
}
