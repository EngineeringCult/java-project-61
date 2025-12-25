package hexlet.code.games;

import hexlet.code.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static hexlet.code.games.Engine.ROUNDS;

public class Calc {

    private static final String CALC_MAIN_QUESTION = "What is the result of the expression?";
    private static final String CALC_EXPRESSION_TEMPLATE = "%s %s %s";
    private static final String UNKNOWN_OPERATOR_MESSAGE_TEMPLATE = "Unknown operator: %s";
    private static final char[] OPERATORS = {'+', '-', '*'};

    public static void run() {
        Engine.run(CALC_MAIN_QUESTION, getExpressionResults());
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

        int indexOperator = RandomGenerator.getRandomIntInRange(0, OPERATORS.length - 1);
        char operator = OPERATORS[indexOperator];
        int correctAnswer = switch (operator) {
            case '+' -> firstRandomInt + secondRandomInt;
            case '-' -> firstRandomInt - secondRandomInt;
            case '*' -> firstRandomInt * secondRandomInt;
            default -> throw new IllegalStateException(UNKNOWN_OPERATOR_MESSAGE_TEMPLATE.formatted(operator));
        };
        return new ExpressionResult(
                CALC_EXPRESSION_TEMPLATE.formatted(firstRandomInt, operator, secondRandomInt),
                String.valueOf(correctAnswer));
    }
}
