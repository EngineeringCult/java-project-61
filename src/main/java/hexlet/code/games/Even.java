package hexlet.code.games;

import hexlet.code.utils.RandomGenerator;

public class Even implements Game {

    private static final String EVEN_GAME_NAME = "Even";
    private static final String EVEN_MAIN_QUESTION = "Answer '%s' if the number is even, otherwise answer '%s'."
            .formatted(Answer.YES.getValue(), Answer.NO.getValue());

    /**
     * Возвращает название игры.
     *
     * @return название игры
     */
    @Override
    public String getGameName() {
        return EVEN_GAME_NAME;
    }

    /**
     * Возвращает основной (корневой) вопрос.
     *
     * @return основной вопрос
     */
    @Override
    public String getMainQuestion() {
        return EVEN_MAIN_QUESTION;
    }

    /**
     * Возвращает объект с выражением (вопросом) и правильным результатом.
     *
     * @return объект с выражением и результатом
     */
    @Override
    public ExpressionResult getExpressionResult() {
        int randomInt = RandomGenerator.getRandomInt();
        Answer correctAnswer = getCorrectAnswer(randomInt);
        return new ExpressionResult(
                String.valueOf(randomInt),
                correctAnswer.getValue());
    }

    private static Answer getCorrectAnswer(int randomInt) {
        if (isEven(randomInt)) {
            return Answer.YES;
        } else {
            return Answer.NO;
        }
    }

    private static boolean isEven(int randomInt) {
        return randomInt % 2 == 0;
    }
}
