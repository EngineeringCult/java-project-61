package hexlet.code.games;

import hexlet.code.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Progression {

    private static final String PROGRESSION_MAIN_QUESTION = "What number is missing in the progression?";
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
     * Возвращает объект с выражением (вопросом) и правильным результатом.
     *
     * @return объект с выражением и результатом
     */
    public static ExpressionResult getExpressionResult() {
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
                buffer.append("..");
            } else {
                buffer.append(progression.get(i));
            }
            buffer.append(" ");
        }

        return new ExpressionResult(
                buffer.toString(),
                String.valueOf(progression.get(missingItem)));
    }
}
