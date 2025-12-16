package hexlet.code.games;

public interface Engine {

    /**
     * Запускает игровой сценарий, выполняет полный цикл игры.
     *
     * @param game объект игры, содержащий вопросы и правильные ответы
     */
    void run(Game game);
}
