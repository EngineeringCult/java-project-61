package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Game;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import hexlet.code.utils.ConsoleInputReader;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static hexlet.code.games.Game.CALC;
import static hexlet.code.games.Game.EVEN;
import static hexlet.code.games.Game.GCD;
import static hexlet.code.games.Game.GREET;
import static hexlet.code.games.Game.PRIME;
import static hexlet.code.games.Game.PROGRESSION;

public class App {

    private static final String ENTER_NUMBER_MESSAGE = "Please enter the game number and press Enter.";
    private static final String ITEM_TEMPLATE = "%s - %s%n";
    private static final String EXIT_ITEM = ITEM_TEMPLATE.formatted(0, "Exit");
    private static final String CHOICE_MESSAGE = "Your choice: ";
    private static final String ITEM_NOT_FOUND_MESSAGE = "Item not found. Try again.";
    private static final String UNKNOWN_GAME_SELECTED_MESSAGE = "Unknown game selected";

    private static final List<Game> GAME_NAMES = createGameNameList();

    public static void main(String[] args) {
        showMenu();
        int num = ConsoleInputReader.readInt();
        Game selectedGame = selectGame(num);
        execute(selectedGame);
    }

    private static void execute(Game selectedGame) {
        switch (selectedGame) {
            case GREET:
                Cli.greet();
                break;
            case EVEN:
                Even.run();
                break;
            case CALC:
                Calc.run();
                break;
            case GCD:
                Gcd.run();
                break;
            case PROGRESSION:
                Progression.run();
                break;
            case PRIME:
                Prime.run();
                break;
            default:
                System.out.println(UNKNOWN_GAME_SELECTED_MESSAGE);
        }
    }

    private static void showMenu() {
        System.out.println(ENTER_NUMBER_MESSAGE);
        AtomicInteger num = new AtomicInteger(1);
        GAME_NAMES.forEach(item -> System.out.printf(ITEM_TEMPLATE, num.getAndIncrement(), item.getName()));
        System.out.print(EXIT_ITEM);
        System.out.print(CHOICE_MESSAGE);
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

    private static Game selectGame(int num) {
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
}
