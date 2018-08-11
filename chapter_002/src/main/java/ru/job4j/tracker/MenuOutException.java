package ru.job4j.tracker;

/**
 * MenuOutException - свой класс для обработки исключительной ситуации.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 11.08.2018.
 */

public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}
