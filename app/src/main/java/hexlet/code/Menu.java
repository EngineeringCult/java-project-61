package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.utils.ConsoleInputReader;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static hexlet.code.games.Game.CALC;
import static hexlet.code.games.Game.EVEN;
import static hexlet.code.games.Game.GCD;
import static hexlet.code.games.Game.GREET;
import static hexlet.code.games.Game.PRIME;
import static hexlet.code.games.Game.PROGRESSION;

public class Menu {

    private static final String ENTER_NUMBER_MESSAGE = "Please enter the game number and press Enter.";
    private static final String ITEM_TEMPLATE = "%s - %s%n";
    private static final String EXIT_ITEM = ITEM_TEMPLATE.formatted(0, "Exit");
    private static final String CHOICE_MESSAGE = "Your choice: ";
    private static final String ITEM_NOT_FOUND_MESSAGE = "Item not found. Try again.";

    private static final List<Game> GAME_NAMES = createGameNameList();

    /**
     * Показывает список доступных игр в консоли.
     */
    public static void show() {
        System.out.println(ENTER_NUMBER_MESSAGE);
        AtomicInteger num = new AtomicInteger(1);
        GAME_NAMES.forEach(item -> System.out.printf(ITEM_TEMPLATE, num.getAndIncrement(), item.getName()));
        System.out.print(EXIT_ITEM);
        System.out.print(CHOICE_MESSAGE);
    }

    /**
     * Возвращает игру, соответствующую номеру.
     *
     * @param num номер выбранной игры; значение {@code 0} означает выход из приложения. Если номер не соответствует
     * ни одной игре, выводится сообщение об ошибке.
     * @return выбранная игра {@link Game}
     */
    public static Game selectGame(int num) {
        while (true) {
            if (num == 0) {
                System.exit(0);
            }

            try {
                return GAME_NAMES.get(num - 1);
            } catch (Exception e) {
                System.out.println(ITEM_NOT_FOUND_MESSAGE);
                num = ConsoleInputReader.readInt();
            }
        }
    }

    private static List<Game> createGameNameList() {
        return List.of(
                GREET,
                EVEN,
                CALC,
                GCD,
                PROGRESSION,
                PRIME);
    }
}
