package ru.job4j.chess;

/**
 * ImposibleMoveException.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 09.09.2018.
 */

public class ImposibleMoveException extends Exception {
    public ImposibleMoveException(String message) {
        super(message);
    }
}
