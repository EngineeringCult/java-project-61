package hexlet.code.games;

import hexlet.code.utils.RandomGenerator;

import java.math.BigInteger;

public class Gcd implements Game {

    private static final String GAME_NAME = "GCD";
    private static final String MAIN_QUESTION = "Find the greatest common divisor of given numbers.";
    private static final String EXPRESSION_TEMPLATE = "%s %s";

    /**
     * Возвращает название игры.
     *
     * @return название игры
     */
    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    /**
     * Возвращает основной (корневой) вопрос.
     *
     * @return основной вопрос
     */
    @Override
    public String getMainQuestion() {
        return MAIN_QUESTION;
    }

    /**
     * Возвращает объект с выражением (вопросом) и правильным результатом.
     *
     * @return объект с выражением и результатом
     */
    @Override
    public ExpressionResult getExpressionResult() {
        int firstRandomInt = RandomGenerator.getRandomInt();
        int secondRandomInt = RandomGenerator.getRandomInt();
        int correctAnswer = BigInteger.valueOf(firstRandomInt)
                .gcd(BigInteger.valueOf(secondRandomInt))
                .intValue();
        return new ExpressionResult(
                EXPRESSION_TEMPLATE.formatted(firstRandomInt, secondRandomInt),
                String.valueOf(correctAnswer));
    }
}
