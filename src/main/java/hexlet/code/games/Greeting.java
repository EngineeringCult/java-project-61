package hexlet.code.games;

public class Greeting implements Game {

    private static final String GAME_NAME = "Greet";
    private static final String ASK_NAME_QUESTION = "May I have your name? ";
    private static final String GREETING_TEMPLATE = "Hello, %s!%n";

    public static void askName() {
        System.out.print(ASK_NAME_QUESTION);
    }

    public static void greetUser(String userName) {
        System.out.printf(GREETING_TEMPLATE, userName);
    }

    /**
     * Возвращает название игры.
     *
     * @return название игры
     */
    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    /**
     * Возвращает основной (корневой) вопрос.
     *
     * @return основной вопрос
     */
    @Override
    public String getMainQuestion() {
        return "";
    }

    /**
     * Возвращает объект с выражением (вопросом) и правильным результатом.
     *
     * @return объект с выражением и результатом
     */
    @Override
    public ExpressionResult getExpressionResult() {
        return null;
    }
}
