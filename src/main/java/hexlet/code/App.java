package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Game;
import hexlet.code.games.Greeting;

import java.util.HashMap;
import java.util.Map;

public class App {

    private static final String FIRST_GREETING = "Welcome to the Brain Games!";

    public static void main(String[] args) {
        System.out.println(FIRST_GREETING);
        Map<Integer, Game> games = createGameMap();
        Menu menu = new Menu(games);
        menu.show();
        int num = Cli.readNum();
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
