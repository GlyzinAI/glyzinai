package ru.job4j.chess;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 09.09.2018.
 */

public class BishopTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * Test way.
     */

    @Test
    public void whenMovingDiagonally() throws ImposibleMoveException {
        Cell source = new Cell(2, 0);
        Cell dest = new Cell(4, 2);
        Bishop bishop = new Bishop(source);
        int result = bishop.way(source, dest).length;
        int expect = 2;
        assertThat(result, is(expect));
    }

    /**
     * Test way.
     */

    @Test
    public void whenMovingNotDiagonal() throws ImposibleMoveException {
        expectedException.expect(ImposibleMoveException.class);
        expectedException.expectMessage("Imposible move!");
        Cell source = new Cell(2, 0);
        Cell dest = new Cell(2, 2);
        Bishop bishop = new Bishop(source);
        bishop.way(source, dest);
    }
}
