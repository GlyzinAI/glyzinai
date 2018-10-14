package ru.job4j.chess;

/**
 * Class King.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 13.10.2018.
 */

public class Knight extends Figure {
    public Knight(Cell position) {
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

    /**
     * Copy.
     *
     * @param dest position.
     * @return new Knight.
     */

    @Override
    public Figure copy(Cell dest) {
        return new Knight(dest);
    }

    public boolean behavior(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) == 1 && Math.abs(source.y - dest.y) == 2
                || Math.abs(source.x - dest.x) == 2 && Math.abs(source.y - dest.y) == 1;
    }
}
