package ru.job4j.chess;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 09.09.2018.
 */

public class RookTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * Test way.
     */

    @Test
    public void whenMovingBack() throws ImposibleMoveException {
        Cell source = new Cell(3, 3);
        Cell dest = new Cell(3, 1);
        Rook rook = new Rook(source);
        int result = rook.way(source, dest).length;
        int expect = 2;
        assertThat(result, is(expect));
    }

    /**
     * Test way.
     */

    @Test
    public void whenMovingDiagonal() throws ImposibleMoveException {
        expectedException.expect(ImposibleMoveException.class);
        expectedException.expectMessage("Imposible move!");
        Cell source = new Cell(3, 3);
        Cell dest = new Cell(4, 4);
        Rook rook = new Rook(source);
        rook.way(source, dest);
    }

    /**
     * Test way.
     */

    @Test
    public void whenMoving() throws ImposibleMoveException {
        expectedException.expect(ImposibleMoveException.class);
        expectedException.expectMessage("Imposible move!");
        Cell source = new Cell(3, 3);
        Cell dest = new Cell(1, 4);
        Rook rook = new Rook(source);
        int result = rook.way(source, dest).length;
        int expect = 2;
        assertThat(result, is(expect));
    }
}
