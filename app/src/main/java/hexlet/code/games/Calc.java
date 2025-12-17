package hexlet.code.games;

import hexlet.code.utils.RandomGenerator;

public class Calc {

    private static final String CALC_MAIN_QUESTION = "What is the result of the expression?";
    private static final String CALC_EXPRESSION_TEMPLATE = "%s %s %s";

    /**
     * Возвращает основной (корневой) вопрос.
     *
     * @return основной вопрос
     */
    public static String getMainQuestion() {
        return CALC_MAIN_QUESTION;
    }

    /**
     * Возвращает объект с выражением (вопросом) и правильным результатом.
     *
     * @return объект с выражением и результатом
     */
    public static ExpressionResult getExpressionResult() {
        int firstRandomInt = RandomGenerator.getRandomInt();
        int secondRandomInt = RandomGenerator.getRandomInt();
        MathOperation randomMathOperation = RandomGenerator.getRandomMathOperation();
        int correctAnswer = randomMathOperation.apply(firstRandomInt, secondRandomInt);
        return new ExpressionResult(
                CALC_EXPRESSION_TEMPLATE.formatted(firstRandomInt, randomMathOperation.getSymbol(), secondRandomInt),
                String.valueOf(correctAnswer));
    }
}
