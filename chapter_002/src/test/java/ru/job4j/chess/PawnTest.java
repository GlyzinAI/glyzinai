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

public class PawnTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * Test way.
     */

    @Test
    public void whenMovingRight() throws ImposibleMoveException {
        expectedException.expect(ImposibleMoveException.class);
        expectedException.expectMessage("Imposible move!");
        Cell source = new Cell(3, 1);
        Cell dest = new Cell(4, 1);
        Pawn pawn = new Pawn(source);
        pawn.way(source, dest);
    }

    /**
     * Test way.
     */

    @Test
    public void whenMovingBack() throws ImposibleMoveException {
        expectedException.expect(ImposibleMoveException.class);
        expectedException.expectMessage("Imposible move!");
        Cell source = new Cell(3, 3);
        Cell dest = new Cell(3, 2);
        Pawn pawn = new Pawn(source);
        pawn.way(source, dest);
    }

    /**
     * Test way.
     */

    @Test
    public void whenMovingForward() throws ImposibleMoveException {
        Cell source = new Cell(5, 1);
        Cell dest = new Cell(5, 2);
        Pawn pawn = new Pawn(source);
        int result = pawn.way(source, dest).length;
        int expect = 1;
        assertThat(result, is(expect));
    }
}
