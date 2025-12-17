package hexlet.code.games;

public enum Game {
    GREET("Greet"),
    EVEN("Even"),
    CALC("Calc"),
    GCD("GCD"),
    PROGRESSION("Progression"),
    PRIME("Prime");

    private final String name;

    Game(String nameValue) {
        this.name = nameValue;
    }

    public String getName() {
        return name;
    }
}
