package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Game;
import hexlet.code.games.Greeting;
import hexlet.code.utils.ConsoleInputReader;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Cli.firstGreet();
        Map<Integer, Game> games = createGameMap();
        Menu menu = new Menu(games);
        menu.show();
        int num = ConsoleInputReader.readInt();
        Game game = menu.selectGame(num);
        game.play();
    }

    private static Map<Integer, Game> createGameMap() {
        Map<Integer, Game> games = new HashMap<>();
        games.put(1, new Greeting());
        games.put(2, new Even());
        return games;
    }
}
