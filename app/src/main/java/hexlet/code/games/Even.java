package hexlet.code.games;

import hexlet.code.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static hexlet.code.games.Engine.ROUNDS;

public class Even {

    private static final String YES = "yes";
    private static final String NO = "no";
    private static final String EVEN_MAIN_QUESTION = "Answer '%s' if the number is even, otherwise answer '%s'."
            .formatted(YES, NO);

    public static void run() {
        Engine.run(EVEN_MAIN_QUESTION, getExpressionResults());
    }

    private static String getMainQuestion() {
        return EVEN_MAIN_QUESTION;
    }

    private static List<ExpressionResult> getExpressionResults() {
        List<ExpressionResult> expressionResults = new ArrayList<>();
        for (int i = 0; i < ROUNDS; i++) {
            expressionResults.add(getExpressionResult());
        }
        return expressionResults;
    }

    public static ExpressionResult getExpressionResult() {
        int randomInt = RandomGenerator.getRandomInt();
        String correctAnswer = isEven(randomInt) ? YES : NO;
        return new ExpressionResult(
                String.valueOf(randomInt),
                correctAnswer);
    }

    private static boolean isEven(int randomInt) {
        return randomInt % 2 == 0;
    }
}
