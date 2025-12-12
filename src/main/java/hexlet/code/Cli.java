package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readData() {
        return SCANNER.next();
    }

    public static int readNum() {
        while (true) {
            try {
                String data = readData();
                return Integer.parseInt(data);
            } catch (NumberFormatException e) {
                System.out.println("Wrong number. Try again.");
            }
        }
    }
}
