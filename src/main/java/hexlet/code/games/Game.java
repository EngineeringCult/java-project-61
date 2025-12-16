package hexlet.code.games;

public interface Game {

    /**
     * Возвращает название игры.
     *
     * @return название игры
     */
    String getGameName();

    /**
     * Возвращает основной (корневой) вопрос.
     *
     * @return основной вопрос
     */
    String getMainQuestion();

    /**
     * Возвращает объект с выражением (вопросом) и правильным результатом.
     *
     * @return объект с выражением и результатом
     */
    ExpressionResult getExpressionResult();
}
