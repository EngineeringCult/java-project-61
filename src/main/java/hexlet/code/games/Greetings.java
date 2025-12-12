package hexlet.code.games;

import hexlet.code.Cli;

public class Greetings implements Game {

    public static final String NAME = "Greet";

    /**
     * Возвращает название игры.
     *
     * <p>Подклассы могут переопределять этот метод для изменения отображаемого названия.
     * При переопределении рекомендуется возвращать непустую строку.</p>
     *
     * @return название игры
     */
    @Override
    public String getName() {
        return NAME;
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
        String userName = askName();
        greetUser(userName);
    }

    private String askName() {
        System.out.print("May I have your name? ");
        return Cli.readData();
    }

    private void greetUser(String userName) {
        System.out.printf("Hello, %s!%n", userName);
    }
}
