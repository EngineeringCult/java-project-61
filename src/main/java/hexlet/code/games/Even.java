package hexlet.code.games;

import hexlet.code.utils.ConsoleInputReader;
import hexlet.code.utils.RandomNumberGenerator;

public class Even implements Game {

    private static final String GAME_NAME = "Even";
    private static final int QUESTIONS_NUMBER = 3;
    private static final String ENTER_ANSWER_MESSAGE = "Answer '%s' if the number is even, otherwise answer '%s'."
            .formatted(Answer.YES.getValue(), Answer.NO.getValue());
    private static final String QUESTION_TEMPLATE = "Question: %s%n";
    private static final String USER_ANSWER_MESSAGE = "Your answer: ";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String WRONG_ANSWER_MESSAGE_TEMPLATE = "'%s' is wrong answer ;(. Correct answer was '%s'."
            + "%nLet's try again, %s!%n";
    private static final String CONGRATULATIONS_MESSAGE_TEMPLATE = "Congratulations, %s!%n";

    /**
     * Возвращает название игры.
     *
     * <p>Подклассы могут переопределять этот метод для изменения отображаемого названия.
     * При переопределении рекомендуется возвращать непустую строку.</p>
     *
     * @return название игры
     */
    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    /**
     * Запускает игровой процесс.
     *
     * <p>
     * Метод выводит случайное число и запрашивает  у пользователя ответ на вопрос четное ли число,
     * если пользователь даст неверный ответ, необходимо завершить игру и вывести сообщение, если пользователь
     * ввел верный ответ, нужно отобразить сообщение и приступить к следующему числу.
     * Пользователь должен дать правильный ответ на три вопроса подряд.
     * После успешной игры нужно вывести сообщение.
     * </p>
     * <p>
     * Подклассы могут переопределять метод, чтобы изменить сценарий игры.
     * При переопределении рекомендуется сохранять основной контракт метода —
     * корректно запускать игровой процесс и не завершать его преждевременно.</p>
     */
    @Override
    public void play() {
        Greeting.askName();
        String userName = ConsoleInputReader.readString();
        Greeting.greetUser(userName);
        System.out.println(ENTER_ANSWER_MESSAGE);
        for (int i = 0; i < QUESTIONS_NUMBER; i++) {
            int randomInt = RandomNumberGenerator.getRandomInt();
            System.out.printf(QUESTION_TEMPLATE, randomInt);
            System.out.print(USER_ANSWER_MESSAGE);
            String userAnswer = ConsoleInputReader.readString();
            Answer correctAnswer = getCorrectAnswer(randomInt);
            if (isValid(correctAnswer, userAnswer)) {
                System.out.println(CORRECT_ANSWER_MESSAGE);
            } else {
                System.out.printf(WRONG_ANSWER_MESSAGE_TEMPLATE, userAnswer, correctAnswer.getValue(), userName);
                System.exit(0);
            }
        }
        System.out.printf(CONGRATULATIONS_MESSAGE_TEMPLATE, userName);
    }

    private static boolean isValid(Answer correctAnswer, String userAnswer) {
        try {
            return correctAnswer.equals(Answer.valueOf(userAnswer.toUpperCase()));
        } catch (Exception e) {
            return false;
        }
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
