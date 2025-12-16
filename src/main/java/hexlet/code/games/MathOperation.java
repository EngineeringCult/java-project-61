package hexlet.code.games;

import java.util.function.IntBinaryOperator;

public enum MathOperation {
    ADDITION("+", Integer::sum),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b);

    public static final MathOperation[] VALUES = values();
    private final String symbol;
    private final IntBinaryOperator operation;

    MathOperation(String symbol, IntBinaryOperator operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public int apply(int a, int b) {
        return operation.applyAsInt(a, b);
    }
}
