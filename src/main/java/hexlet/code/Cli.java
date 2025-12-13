package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String WRONG_NUMBER_MESSAGE = "Wrong number. Try again.";

    public static String readData() {
        return SCANNER.next();
    }

    public static int readNum() {
        while (true) {
            try {
                String data = readData();
                return Integer.parseInt(data);
            } catch (NumberFormatException e) {
                System.out.println(WRONG_NUMBER_MESSAGE);
            }
        }
    }

    public static String readUserName() {
        return Cli.readData();
    }

    public static void finish() {
        System.exit(0);
    }
}
