package hexlet.code.games;

public class Greeting {

    private static final String ASK_NAME_QUESTION = "May I have your name? ";
    private static final String GREETING_TEMPLATE = "Hello, %s!%n";

    public static void askName() {
        System.out.print(ASK_NAME_QUESTION);
    }

    public static void greetUser(String userName) {
        System.out.printf(GREETING_TEMPLATE, userName);
    }
}
