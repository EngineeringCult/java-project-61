package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String askName() {
        System.out.print("May I have your name? ");
        return SCANNER.next();
    }

    public static void greetUser(String userName) {
        System.out.printf("Hello, %s!%n", userName);
    }
}
