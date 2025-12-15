package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.utils.ConsoleInputReader;

import java.util.Map;

public class Menu {

    private static final String ENTER_NUMBER_MESSAGE = "Please enter the game number and press Enter.";
    private static final String ITEM_TEMPLATE = "%s - %s%n";
    private static final String EXIT_ITEM = ITEM_TEMPLATE.formatted(0, "Exit");
    private static final String ITEM_NOT_FOUND_MESSAGE = "Item not found. Try again.";

    private final Map<Integer, Game> games;

    public Menu(Map<Integer, Game> games) {
        this.games = games;
    }

    /**
     * Показывает список доступных игр в консоли.
     *
     * <p>Подклассы могут переопределять этот метод, чтобы изменить формат или способ отображения меню.
     * При переопределении рекомендуется сохранять читаемость вывода и отображать все доступные варианты выбора.</p>
     */
    public void show() {
        System.out.println(ENTER_NUMBER_MESSAGE);
        games.forEach((num, item) -> System.out.printf(ITEM_TEMPLATE, num, item.getGameName()));
        System.out.print(EXIT_ITEM);
    }

    /**
     * Возвращает игру, соответствующую номеру, выбранному пользователем.
     *
     * <p>Если переданное значение равно {@code 0}, метод завершает работу приложения.
     * Если номер не соответствует ни одной игре, выводится сообщение об ошибке.</p>
     *
     * <p>Подклассы могут переопределять этот метод для изменения логики выбора.
     * При переопределении необходимо соблюдать контракт:
     * метод не должен возвращать {@code null}.</p>
     *
     * @param num номер выбранной игры; значение {@code 0} означает выход из приложения
     * @return выбранная игра {@link Game}
     */
    public Game selectGame(int num) {
        while (true) {
            if (num == 0) {
                System.exit(0);
            }

            if (games.containsKey(num)) {
                return games.get(num);
            } else {
                System.out.println(ITEM_NOT_FOUND_MESSAGE);
                num = ConsoleInputReader.readInt();
            }
        }
    }
}
