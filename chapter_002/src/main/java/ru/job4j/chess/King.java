package ru.job4j.chess;

/**
 * Class King.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 09.09.2018.
 */

public class King extends Figure {
    public King(Cell position) {
        super(position);
    }

    /**
     * Way.
     *
     * @param source position.
     * @param dest   position.
     * @return array steps.
     * @throws ImposibleMoveException
     */

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        if (!behavior(source, dest)) {
            throw new ImposibleMoveException("Imposible move!");
        }

        return new Cell[]{dest};
    }

    public boolean behavior(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) <= 1 && Math.abs(source.y - dest.y) <= 1;
    }

    /**
     * Copy.
     *
     * @param dest position.
     * @return new King.
     */

    @Override
    public Figure copy(Cell dest) {
        return new King(dest);
    }
}
