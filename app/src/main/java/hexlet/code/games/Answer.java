package hexlet.code.games;

public enum Answer {
    YES("yes"),
    NO("no");

    private final String value;

    Answer(String valueValue) {
        this.value = valueValue;
    }

    public String getValue() {
        return value;
    }
}
