package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test. Table multiple array[size][size].
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 29.07.2018.
 */

public class MatrixTest {
    @Test
    public void whenTableMultipleSize2() {
        Matrix matrix = new Matrix();
        int[][] res = matrix.multiple(2);
        int[][] expect = {{1, 2}, {2, 4}};
        assertThat(res, is(expect));
    }

    @Test
    public void whenTableMultipleSize4() {
        Matrix matrix = new Matrix();
        int[][] res = matrix.multiple(4);
        int[][] expect = {{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}};
        assertThat(res, is(expect));
    }
}
