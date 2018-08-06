package ru.job4j.tracker;

/**
 * StubInput - ввод пользовательских данных. Используется массив с готовыми ответами пользователя.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 06.08.2018.
 */

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        return answers[position++];
    }
}
