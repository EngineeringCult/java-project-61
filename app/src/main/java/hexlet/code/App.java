package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.games.Engine;
import hexlet.code.utils.ConsoleInputReader;

public class App {

    public static void main(String[] args) {
        Menu.show();
        int num = ConsoleInputReader.readInt();
        Game game = Menu.selectGame(num);
        Engine.run(game);
    }

}
