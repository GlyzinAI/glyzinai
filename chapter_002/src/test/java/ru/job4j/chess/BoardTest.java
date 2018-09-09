package ru.job4j.chess;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 09.09.2018.
 */

public class BoardTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * Test move.
     *
     * @throws ImposibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */

    @Test
    public void whenMovingTrue() throws ImposibleMoveException, FigureNotFoundException, OccupiedWayException {
        Cell source = new Cell(2, 0);
        Cell dest = new Cell(5, 3);
        Bishop bishop = new Bishop(source);
        Board board = new Board();
        board.add(bishop);
        boolean result = board.move(source, dest);
        assertThat(result, is(true));
    }

    /**
     * Test move.
     *
     * @throws ImposibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */

    @Test
    public void whenFigureNotFoundException() throws ImposibleMoveException, FigureNotFoundException, OccupiedWayException {
        expectedException.expect(FigureNotFoundException.class);
        expectedException.expectMessage("Figure not found!");
        Cell source = new Cell(2, 0);
        Cell dest = new Cell(4, 4);
        Board board = new Board();
        board.move(source, dest);
    }

    /**
     * Test move.
     *
     * @throws ImposibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */

    @Test
    public void whenImposibleMoveException() throws ImposibleMoveException, FigureNotFoundException, OccupiedWayException {
        expectedException.expect(ImposibleMoveException.class);
        expectedException.expectMessage("Imposible move!");
        Cell source = new Cell(2, 0);
        Cell dest = new Cell(4, 4);
        Bishop bishop = new Bishop(source);
        Board board = new Board();
        board.add(bishop);
        board.move(source, dest);
    }

    /**
     * Test move.
     *
     * @throws ImposibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */

    @Test
    public void whenOccupiedWayException() throws ImposibleMoveException, FigureNotFoundException, OccupiedWayException {
        expectedException.expect(OccupiedWayException.class);
        expectedException.expectMessage("Occupied way!");
        Cell source = new Cell(2, 0);
        Cell dest = new Cell(5, 3);
        Bishop blackBishop = new Bishop(source);
        Bishop whiteBishop = new Bishop(new Cell(4, 2));
        Board board = new Board();
        board.add(blackBishop);
        board.add(whiteBishop);
        board.move(source, dest);
    }
}
