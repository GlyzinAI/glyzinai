package ru.job4j.chess;

/**
 * Class King.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 13.10.2018.
 */

public class Queen extends Figure {
    public Queen(Cell position) {
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

        Cell[] steps = new Cell[Math.max(Math.abs(source.x - dest.x), Math.abs(source.y - dest.y))];

        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;

        for (int i = 0; i < steps.length; i++) {
            steps[i] = new Cell(source.x + i * deltaX, source.y + i * deltaY);
        }
        return steps;
    }

    /**
     * Copy.
     *
     * @param dest position.
     * @return new Queen.
     */

    @Override
    public Figure copy(Cell dest) {
        return new Queen(dest);
    }

    public boolean behavior(Cell source, Cell dest) {
        return (Math.abs(source.x - dest.x) == 0 && Math.abs(source.y - dest.y) > 0
                || Math.abs(source.y - dest.y) == 0 && Math.abs(source.x - dest.x) > 0)
                || (Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y));
    }
}
