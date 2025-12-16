package hexlet.code.games;

import hexlet.code.utils.RandomGenerator;

public class Calc implements Game {

    private static final String GAME_NAME = "Calc";
    private static final String MAIN_QUESTION = "What is the result of the expression?";
    private static final String EXPRESSION_TEMPLATE = "%s %s %s";

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
        MathOperation randomMathOperation = RandomGenerator.getRandomMathOperation();
        int correctAnswer = randomMathOperation.apply(firstRandomInt, secondRandomInt);
        return new ExpressionResult(
                EXPRESSION_TEMPLATE.formatted(firstRandomInt, randomMathOperation.getSymbol(), secondRandomInt),
                String.valueOf(correctAnswer));
    }
}
