package hexlet.code.games;

import hexlet.code.utils.ConsoleInputReader;

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
     * <p>Метод запрашивает имя пользователя и выводит приветствие.
     * Подклассы могут переопределять метод, чтобы изменить сценарий игры.
     * При переопределении рекомендуется сохранять основной контракт метода —
     * корректно запускать игровой процесс и не завершать его преждевременно.</p>
     */
    @Override
    public void play() {
        askName();
        String userName = ConsoleInputReader.readString();
        greetUser(userName);
    }
}
