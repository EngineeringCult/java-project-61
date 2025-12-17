package hexlet.code.games;

import hexlet.code.utils.RandomGenerator;

public class Prime {

    private static final String PRIME_MAIN_QUESTION = "Answer '%s' if given number is prime. Otherwise answer '%s'."
            .formatted(Answer.YES.getValue(), Answer.NO.getValue());
    private static final int FIRST_ODD_DIVISOR = 3;

    /**
     * Возвращает основной (корневой) вопрос.
     *
     * @return основной вопрос
     */
    public static String getMainQuestion() {
        return PRIME_MAIN_QUESTION;
    }

    /**
     * Возвращает объект с выражением (вопросом) и правильным результатом.
     *
     * @return объект с выражением и результатом
     */
    public static ExpressionResult getExpressionResult() {
        int randomInt = RandomGenerator.getRandomInt();
        Answer correctAnswer = getCorrectAnswer(randomInt);
        return new ExpressionResult(
                String.valueOf(randomInt),
                correctAnswer.getValue());
    }

    private static Answer getCorrectAnswer(int randomInt) {
        if (isPrime(randomInt)) {
            return Answer.YES;
        } else {
            return Answer.NO;
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = FIRST_ODD_DIVISOR; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
