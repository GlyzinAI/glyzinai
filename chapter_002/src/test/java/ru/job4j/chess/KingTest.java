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

public class KingTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * Test way.
     */

    @Test
    public void whenMoveKing1() throws ImposibleMoveException {
        Cell source = new Cell(3, 3);
        Cell dest = new Cell(2, 4);
        King king = new King(source);
        int result = king.way(source, dest).length;
        int expect = 1;
        assertThat(result, is(expect));
    }

    /**
     * Test way.
     */

    @Test
    public void whenMoveKing2() throws ImposibleMoveException {
        Cell source = new Cell(3, 3);
        Cell dest = new Cell(4, 2);
        King king = new King(source);
        int result = king.way(source, dest).length;
        int expect = 1;
        assertThat(result, is(expect));
    }

    /**
     * Test way.
     */

    @Test
    public void whenMoveKing3() throws ImposibleMoveException {
        expectedException.expect(ImposibleMoveException.class);
        expectedException.expectMessage("Imposible move!");
        Cell source = new Cell(3, 3);
        Cell dest = new Cell(5, 4);
        King king = new King(source);
        king.way(source, dest);
    }

    /**
     * Test way.
     */

    @Test
    public void whenMoveKing4() throws ImposibleMoveException {
        expectedException.expect(ImposibleMoveException.class);
        expectedException.expectMessage("Imposible move!");
        Cell source = new Cell(3, 3);
        Cell dest = new Cell(3, 5);
        King king = new King(source);
        king.way(source, dest);
    }

}
