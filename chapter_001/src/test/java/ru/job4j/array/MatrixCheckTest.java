package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test. Matrix true or false.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 29.07.2018.
 */

public class MatrixCheckTest {
    @Test
    public void whenMatrixCheckTrue() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false, true},
                {true, true, false},
                {true, false, true}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenMatrixCheckFalse() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false, false},
                {true, true, false},
                {true, false, true}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenMatrixCheckFalse2() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false, true},
                {false, true, false},
                {false, false, true}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenMatrixCheckSize2() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false},
                {false, true}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenMatrixCheckSize2False() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false},
                {true, true}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(false));
    }
}
