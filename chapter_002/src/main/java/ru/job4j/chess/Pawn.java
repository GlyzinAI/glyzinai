package ru.job4j.chess;

/**
 * Class King.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 09.09.2018.
 */

public class Pawn extends Figure {

    public Pawn(Cell position) {
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
        Cell[] steps = new Cell[0];
        if (behavior(source, dest)) {
            throw new ImposibleMoveException("Imposible move!");
        }
        if (dest.y == source.y + 1 && dest.x == source.x) {
            steps = new Cell[]{dest};
        }
        return steps;
    }

    /**
     * Copy.
     *
     * @param dest position.
     * @return new Pawn.
     */

    @Override
    public Figure copy(Cell dest) {
        return new Pawn(dest);
    }

    public boolean behavior(Cell source, Cell dest) {
        return !(dest.y == source.y + 1 && dest.x == source.x);
    }
}
