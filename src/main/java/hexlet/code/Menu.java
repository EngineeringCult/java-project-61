package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.games.Greetings;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    private static final String FORMAT = "%s - %s";
    private final Map<Integer, Game> games;

    public Menu() {
        games = new HashMap<>();
        games.put(1, new Greetings());
    }

    /**
     * Показывает список доступных игр в консоли.
     *
     * <p>Подклассы могут переопределять этот метод, чтобы изменить формат или способ отображения меню.
     * При переопределении рекомендуется сохранять читаемость вывода и отображать все доступные варианты выбора.</p>
     */
    public void show() {
        System.out.println("Please enter the game number and press Enter.");
        games.forEach((num, item) -> System.out.printf((FORMAT) + "%n", num, item.getName()));
        System.out.printf((FORMAT) + "%n", 0, "Exit");
    }

    /**
     * Считывает выбор пользователя и возвращает выбранную игру.
     *
     * <p>Метод запрашивает ввод до тех пор, пока пользователь не введёт корректный номер игры.
     * Ввод значения {@code 0} приводит к завершению работы приложения.</p>
     *
     * <p>Подклассы могут переопределять этот метод, чтобы изменить логику выбора.
     * При переопределении необходимо соблюдать контракт: метод не должен возвращать {@code null}
     * и должен продолжать запрашивать ввод, пока не будет сделан корректный выбор.</p>
     *
     * @return выбранная игра {@link Game}
     */
    public Game selectItem() {
        while (true) {
            int num = Cli.readNum();

            if (num == 0) {
                System.exit(0);
            }

            if (games.containsKey(num)) {
                return games.get(num);
            } else {
                System.out.println("Item not found. Try again.");
            }
        }
    }
}
