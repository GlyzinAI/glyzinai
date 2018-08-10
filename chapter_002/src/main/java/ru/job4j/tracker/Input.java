package ru.job4j.tracker;

import java.util.List;

/**
 * Interface Input.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 10.08.2018.
 */

public interface Input {

    String ask(String question);

    int ask(String question, List<Integer> range);

}
