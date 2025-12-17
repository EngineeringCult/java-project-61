package hexlet.code.games;

import hexlet.code.utils.RandomGenerator;

import java.math.BigInteger;

public class Gcd {

    private static final String GCD_GAME_NAME = "GCD";
    private static final String GCD_MAIN_QUESTION = "Find the greatest common divisor of given numbers.";
    private static final String GCD_EXPRESSION_TEMPLATE = "%s %s";

    /**
     * Возвращает основной (корневой) вопрос.
     *
     * @return основной вопрос
     */
    public static String getMainQuestion() {
        return GCD_MAIN_QUESTION;
    }

    /**
     * Возвращает объект с выражением (вопросом) и правильным результатом.
     *
     * @return объект с выражением и результатом
     */
    public static ExpressionResult getExpressionResult() {
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
