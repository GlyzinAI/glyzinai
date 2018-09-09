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

public class KnightTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * Test way.
     */

    @Test
    public void whenKnightMove1() throws ImposibleMoveException {
        Cell source = new Cell(3, 4);
        Cell dest = new Cell(2, 6);
        Knight knight = new Knight(source);
        int result = knight.way(source, dest).length;
        int expect = 1;
        assertThat(result, is(expect));
    }

    /**
     * Test way.
     */

    @Test
    public void whenKnightMove2() throws ImposibleMoveException {
        Cell source = new Cell(3, 4);
        Cell dest = new Cell(1, 5);
        Knight knight = new Knight(source);
        int result = knight.way(source, dest).length;
        int expect = 1;
        assertThat(result, is(expect));
    }

    /**
     * Test way.
     */

    @Test
    public void whenKnightMove3() throws ImposibleMoveException {
        Cell source = new Cell(3, 4);
        Cell dest = new Cell(4, 2);
        Knight knight = new Knight(source);
        int result = knight.way(source, dest).length;
        int expect = 1;
        assertThat(result, is(expect));
    }

    /**
     * Test way.
     */

    @Test
    public void whenKnightMove4() throws ImposibleMoveException {
        expectedException.expect(ImposibleMoveException.class);
        expectedException.expectMessage("Imposible move!");
        Cell source = new Cell(3, 4);
        Cell dest = new Cell(0, 5);
        Knight knight = new Knight(source);
        knight.way(source, dest);
    }

    /**
     * Test way.
     */

    @Test
    public void whenKnightMove5() throws ImposibleMoveException {
        expectedException.expect(ImposibleMoveException.class);
        expectedException.expectMessage("Imposible move!");
        Cell source = new Cell(5, 3);
        Cell dest = new Cell(3, 7);
        Knight knight = new Knight(source);
        knight.way(source, dest);
    }
}
