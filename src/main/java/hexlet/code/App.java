package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Game;
import hexlet.code.games.Gcd;
import hexlet.code.games.Greeting;
import hexlet.code.games.Calc;
import hexlet.code.games.Engine;
import hexlet.code.games.EngineImpl;
import hexlet.code.games.Progression;
import hexlet.code.utils.ConsoleInputReader;

import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Game> games = createGameList();
        Menu menu = new Menu(games);
        Engine engine = new EngineImpl();
        menu.show();
        int num = ConsoleInputReader.readInt();
        Game game = menu.selectGame(num);
        engine.run(game);
    }

    private static List<Game> createGameList() {
        return List.of(
                new Greeting(),
                new Even(),
                new Calc(),
                new Gcd(),
                new Progression());
    }
}
