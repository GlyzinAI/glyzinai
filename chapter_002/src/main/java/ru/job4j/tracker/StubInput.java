package ru.job4j.tracker;

import java.util.List;

/**
 * StubInput - ввод пользовательских данных. Используется массив с готовыми ответами пользователя.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 08.08.2018.
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

    @Override
    public int ask(String question, List<Integer> range) {
        return 0;
    }
}
