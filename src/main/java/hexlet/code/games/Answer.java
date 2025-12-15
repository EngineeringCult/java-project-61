package hexlet.code.games;

public enum Answer {
    YES("yes"),
    NO("no");

    private final String value;

    Answer(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
