package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.utils.ConsoleInputReader;

import java.util.function.Supplier;

public class Engine {

    private static final int QUESTIONS_NUMBER = 3;
    private static final String EXPRESSION_QUESTION_TEMPLATE = "Question: %s%n";
    private static final String USER_ANSWER_MESSAGE = "Your answer: ";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String WRONG_ANSWER_MESSAGE_TEMPLATE = "'%s' is wrong answer ;(. Correct answer was '%s'."
            + "%nLet's try again, %s!%n";
    private static final String CONGRATULATIONS_MESSAGE_TEMPLATE = "Congratulations, %s!%n";
    private static final String UNKNOWN_GAME_SELECTED_MESSAGE = "Unknown game selected";

    /**
     * Запускает игровой сценарий.
     * <p>
     * Метод выполняет полный цикл игры:
     * <ul>
     *   <li>запрашивает имя пользователя и приветствует его;</li>
     *   <li>проверяет наличие вопросов в игре;</li>
     *   <li>выводит основной вопрос игры;</li>
     *   <li>последовательно задаёт вопросы пользователю и проверяет ответы;</li>
     *   <li>завершает игру при неверном ответе;</li>
     *   <li>поздравляет пользователя в случае успешного прохождения.</li>
     * </ul>
     *
     * @param game объект игры, содержащий вопросы и правильные ответы
     */
    public static void run(Game game) {
        System.out.println();
        Cli.firstGreet();
        Greeting.askName();
        String userName = ConsoleInputReader.readString();
        Greeting.greetUser(userName);

        String mainQuestion;
        Supplier<ExpressionResult> expressionResultSupplier;
        switch (game) {
            case GREET -> {
                return;
            }
            case EVEN -> {
                mainQuestion = Even.getMainQuestion();
                expressionResultSupplier = Even::getExpressionResult;
            }
            case CALC -> {
                mainQuestion = Calc.getMainQuestion();
                expressionResultSupplier = Calc::getExpressionResult;
            }
            case GCD -> {
                mainQuestion = Gcd.getMainQuestion();
                expressionResultSupplier = Gcd::getExpressionResult;
            }
            case PROGRESSION -> {
                mainQuestion = Progression.getMainQuestion();
                expressionResultSupplier = Progression::getExpressionResult;
            }
            case PRIME -> {
                mainQuestion = Prime.getMainQuestion();
                expressionResultSupplier = Prime::getExpressionResult;
            }
            default -> {
                System.out.println(UNKNOWN_GAME_SELECTED_MESSAGE);
                return;
            }
        }

        executeGameLogic(mainQuestion, expressionResultSupplier, userName);
    }

    private static void executeGameLogic(
            String mainQuestion, Supplier<ExpressionResult> expressionResultSupplier, String userName) {
        ExpressionResult expressionResult;
        System.out.println(mainQuestion);
        for (int i = 0; i < QUESTIONS_NUMBER; i++) {
            expressionResult = expressionResultSupplier.get();
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
