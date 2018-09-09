package ru.job4j.chess;

/**
 * Class Figure.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 09.09.2018.
 */

public abstract class Figure {
    final private Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    public abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

    public abstract Figure copy(Cell dest);

    /**
     * Position.
     *
     * @return position.
     */

    public Cell getPosition() {
        return this.position;
    }
}
