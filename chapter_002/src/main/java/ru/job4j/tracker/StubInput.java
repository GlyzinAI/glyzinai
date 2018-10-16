package ru.job4j.tracker;

import java.util.List;

/**
 * StubInput - ввод пользовательских данных. Используется массив с готовыми ответами пользователя.
 *
 * @author Artur Glyzin.
 * @version 3.0.
 * @since 16.10.2018.
 */

public class StubInput implements Input {
    private List<String> answers;
    private int position = 0;

    public StubInput(List<String> answers) {
        this.answers = answers;
    }


    public String ask(String question) {
        return answers.get(position++);
    }

    @Override
    public int ask(String question, List<Integer> range) {
        return Integer.valueOf(answers.get(position++));
    }

}
