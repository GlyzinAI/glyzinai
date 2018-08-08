package ru.job4j.tracker;

import java.util.List;

/**
 * Interface Input.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 08.08.2018.
 */

public interface Input {

    String ask(String question);

    int ask(String question, List<Integer> range);

}
