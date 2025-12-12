package hexlet.code;

import hexlet.code.games.Game;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        Menu menu = new Menu();
        menu.show();
        Game game = menu.selectItem();
        game.play();
    }
}
