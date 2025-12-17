package hexlet.code.utils;

import java.util.Scanner;

public class ConsoleInputReader {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String WRONG_NUMBER_MESSAGE = "Wrong number. Try again.";

    public static String readString() {
        return SCANNER.next();
    }

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(readString());
            } catch (NumberFormatException e) {
                System.out.println(WRONG_NUMBER_MESSAGE);
            }
        }
    }
}
