package hexlet.code.games;

import hexlet.code.utils.ConsoleInputReader;

import java.util.List;

public class Engine {

    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    private static final String ASK_NAME_QUESTION = "May I have your name? ";
    private static final String GREETING_TEMPLATE = "Hello, %s!%n";
    private static final String EXPRESSION_QUESTION_TEMPLATE = "Question: %s%n";
    private static final String USER_ANSWER_MESSAGE = "Your answer: ";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String WRONG_ANSWER_MESSAGE_TEMPLATE = "'%s' is wrong answer ;(. Correct answer was '%s'."
            + "%nLet's try again, %s!%n";
    private static final String CONGRATULATIONS_MESSAGE_TEMPLATE = "Congratulations, %s!%n";

    /**
     * Запускает игровой сценарий.
     * <p>
     * Метод выполняет полный цикл игры:
     * <ul>
     *   <li>запрашивает имя пользователя и приветствует его;</li>
     *   <li>выводит основной вопрос игры;</li>
     *   <li>последовательно задаёт вопросы пользователю и проверяет ответы;</li>
     *   <li>поздравляет пользователя в случае успешного прохождения.</li>
     * </ul>
     *
     * @param mainQuestion основной вопрос игры;
     * @param expressionResults список выражений и их результатов для вопросов игры.
     */
    public static void run(String mainQuestion, List<ExpressionResult> expressionResults) {
        System.out.println();
        System.out.println(WELCOME_MESSAGE);
        System.out.print(ASK_NAME_QUESTION);
        String userName = ConsoleInputReader.readString();
        System.out.printf(GREETING_TEMPLATE, userName);

        executeGameLogic(mainQuestion, expressionResults, userName);
    }

    private static void executeGameLogic(
            String mainQuestion, List<ExpressionResult> expressionResults, String userName) {
        System.out.println(mainQuestion);
        for (ExpressionResult expressionResult : expressionResults) {
            System.out.printf(EXPRESSION_QUESTION_TEMPLATE, expressionResult.expression());
            System.out.print(USER_ANSWER_MESSAGE);
            String userAnswer = ConsoleInputReader.readString();
            if (expressionResult.result().equals(userAnswer)) {
                System.out.println(CORRECT_ANSWER_MESSAGE);
            } else {
                System.out.printf(WRONG_ANSWER_MESSAGE_TEMPLATE, userAnswer, expressionResult.result(), userName);
                System.exit(0);
            }
        }
        System.out.printf(CONGRATULATIONS_MESSAGE_TEMPLATE, userName);
    }
}
