package hexlet.code.games;

import hexlet.code.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static hexlet.code.games.Engine.ROUNDS;

public class Progression {

    private static final String PROGRESSION_MAIN_QUESTION = "What number is missing in the progression?";
    private static final String SPACE = " ";
    private static final String HIDDEN_ITEM = "..";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MIN_STEP = 2;
    private static final int MAX_STEP = 10;
    private static final int MIN_FIRST_ITEM = 0;
    private static final int MAX_FIRST_ITEM = 20;

    public static void run() {
        Engine.run(PROGRESSION_MAIN_QUESTION, getExpressionResults());
    }

    private static List<ExpressionResult> getExpressionResults() {
        List<ExpressionResult> expressionResults = new ArrayList<>();
        for (int i = 0; i < ROUNDS; i++) {
            expressionResults.add(getExpressionResult());
        }
        return expressionResults;
    }

    private static ExpressionResult getExpressionResult() {
        int step = RandomGenerator.getRandomIntInRange(MIN_STEP, MAX_STEP);
        int length = RandomGenerator.getRandomIntInRange(MIN_LENGTH, MAX_LENGTH);
        int item = RandomGenerator.getRandomIntInRange(MIN_FIRST_ITEM, MAX_FIRST_ITEM);
        int missingItemIndex = RandomGenerator.getRandomIntInRange(0, length - 1);

        String[] progression = generateProgression(length, item, step);
        String missingItem = progression[missingItemIndex];
        progression[missingItemIndex] = HIDDEN_ITEM;
        String expression = String.join(SPACE, progression);

        return new ExpressionResult(
                expression,
                missingItem);
    }

    private static String[] generateProgression(int length, int item, int step) {
        String[] progression = new String[length];
        progression[0] = String.valueOf(item);
        for (int i = 1; i < length; i++) {
            item = item + step;
            progression[i] = String.valueOf(item);
        }
        return progression;
    }
}
