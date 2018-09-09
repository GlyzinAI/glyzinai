package ru.job4j.chess;

/**
 * Class Bishop.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 09.09.2018.
 */

public class Bishop extends Figure {
    public Bishop(Cell position) {
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
        if (!isDiagonal(source, dest)) {
            throw new ImposibleMoveException("Imposible move!");
        }

        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;


        Cell[] steps = new Cell[Math.abs(dest.x - source.x)];
        for (int i = 1; i <= steps.length; i++) {
            steps[i - 1] = new Cell(source.x + i * deltaX, source.y + i * deltaY);
        }
        return steps;
    }

    /**
     * Copy.
     *
     * @param dest position.
     * @return new Bishop.
     */

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y);
    }
}
