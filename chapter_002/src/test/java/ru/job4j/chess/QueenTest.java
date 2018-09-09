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

public class QueenTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * Test way.
     */

    @Test
    public void whenMovingQueen1() throws ImposibleMoveException {
        Cell source = new Cell(5, 1);
        Cell dest = new Cell(5, 6);
        Queen queen = new Queen(source);
        int result = queen.way(source, dest).length;
        int expect = 5;
        assertThat(result, is(expect));
    }

    /**
     * Test way.
     */

    @Test
    public void whenMovingQueen2() throws ImposibleMoveException {
        Cell source = new Cell(5, 1);
        Cell dest = new Cell(1, 5);
        Queen queen = new Queen(source);
        int result = queen.way(source, dest).length;
        int expect = 4;
        assertThat(result, is(expect));
    }

    /**
     * Test way.
     */

    @Test
    public void whenMovingQueen3() throws ImposibleMoveException {
        Cell source = new Cell(5, 1);
        Cell dest = new Cell(7, 3);
        Queen queen = new Queen(source);
        int result = queen.way(source, dest).length;
        int expect = 2;
        assertThat(result, is(expect));
    }

    /**
     * Test way.
     */

    @Test
    public void whenMovingQueen4() throws ImposibleMoveException {
        Cell source = new Cell(5, 1);
        Cell dest = new Cell(5, 0);
        Queen queen = new Queen(source);
        int result = queen.way(source, dest).length;
        int expect = 1;
        assertThat(result, is(expect));
    }

    /**
     * Test way.
     */

    @Test
    public void whenMovingQueen5() throws ImposibleMoveException {
        expectedException.expect(ImposibleMoveException.class);
        expectedException.expectMessage("Imposible move!");
        Cell source = new Cell(5, 1);
        Cell dest = new Cell(4, 5);
        Queen queen = new Queen(source);
        queen.way(source, dest);
    }

    /**
     * Test way.
     */

    @Test
    public void whenMovingQueen6() throws ImposibleMoveException {
        expectedException.expect(ImposibleMoveException.class);
        expectedException.expectMessage("Imposible move!");
        Cell source = new Cell(5, 1);
        Cell dest = new Cell(3, 2);
        Queen queen = new Queen(source);
        queen.way(source, dest);
    }

}
