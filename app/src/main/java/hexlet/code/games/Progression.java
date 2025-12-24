package hexlet.code.games;

import hexlet.code.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Progression {

    private static final int PRIME_QUESTIONS_NUMBER = 3;
    private static final String PROGRESSION_MAIN_QUESTION = "What number is missing in the progression?";
    private static final String SPACE = " ";
    private static final String MISSING_ITEM = "..";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MIN_STEP = 2;
    private static final int MAX_STEP = 10;
    private static final int MIN_FIRST_ITEM = 0;
    private static final int MAX_FIRST_ITEM = 20;

    /**
     * Возвращает основной (корневой) вопрос.
     *
     * @return основной вопрос
     */
    public static String getMainQuestion() {
        return PROGRESSION_MAIN_QUESTION;
    }

    /**
     * Возвращает список объектов с выражением (вопросом) и правильным результатом.
     *
     * @return список объектов с выражением и результатом
     */
    public static List<ExpressionResult> getExpressionResults() {
        List<ExpressionResult> expressionResults = new ArrayList<>();
        for (int i = 0; i < PRIME_QUESTIONS_NUMBER; i++) {
            expressionResults.add(getExpressionResult());
        }
        return expressionResults;
    }

    private static ExpressionResult getExpressionResult() {
        int step = RandomGenerator.getRandomIntInRange(MIN_STEP, MAX_STEP);
        int length = RandomGenerator.getRandomIntInRange(MIN_LENGTH, MAX_LENGTH);
        int item = RandomGenerator.getRandomIntInRange(MIN_FIRST_ITEM, MAX_FIRST_ITEM);
        int missingItem = RandomGenerator.getRandomIntInRange(0, length - 1);

        List<Integer> progression = new ArrayList<>(length);
        progression.add(item);
        for (int i = 1; i < length; i++) {
            item = item + step;
            progression.add(i, item);
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < progression.size(); i++) {
            if (i == missingItem) {
                buffer.append(MISSING_ITEM);
            } else {
                buffer.append(progression.get(i));
            }
            buffer.append(SPACE);
        }

        return new ExpressionResult(
                buffer.toString(),
                String.valueOf(progression.get(missingItem)));
    }
}
