package hexlet.code.games;

import hexlet.code.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Calc {

    private static final int CALC_QUESTIONS_NUMBER = 3;
    private static final String CALC_MAIN_QUESTION = "What is the result of the expression?";
    private static final String CALC_EXPRESSION_TEMPLATE = "%s %s %s";
    private static final String UNKNOWN_OPERATOR_MESSAGE_TEMPLATE = "Unknown operator: %s";
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char ASTERISK = '*';
    private static final char[] OPERATORS = {PLUS, MINUS, ASTERISK};

    /**
     * Возвращает основной (корневой) вопрос.
     *
     * @return основной вопрос
     */
    public static String getMainQuestion() {
        return CALC_MAIN_QUESTION;
    }

    /**
     * Возвращает список объектов с выражением (вопросом) и правильным результатом.
     *
     * @return список объектов с выражением и результатом
     */
    public static List<ExpressionResult> getExpressionResults() {
        List<ExpressionResult> expressionResults = new ArrayList<>();
        for (int i = 0; i < CALC_QUESTIONS_NUMBER; i++) {
            expressionResults.add(getExpressionResult());
        }
        return expressionResults;
    }

    private static ExpressionResult getExpressionResult() {
        int firstRandomInt = RandomGenerator.getRandomInt();
        int secondRandomInt = RandomGenerator.getRandomInt();

        int indexOperator = RandomGenerator.getRandomIntInRange(0, OPERATORS.length - 1);
        char operator = OPERATORS[indexOperator];
        int correctAnswer = switch (operator) {
            case PLUS -> firstRandomInt + secondRandomInt;
            case MINUS -> firstRandomInt - secondRandomInt;
            case ASTERISK -> firstRandomInt * secondRandomInt;
            default -> throw new IllegalStateException(UNKNOWN_OPERATOR_MESSAGE_TEMPLATE.formatted(operator));
        };
        return new ExpressionResult(
                CALC_EXPRESSION_TEMPLATE.formatted(firstRandomInt, operator, secondRandomInt),
                String.valueOf(correctAnswer));
    }
}
