package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test. Merge array1 && array2(sorted).
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 30.07.2018.
 */

public class DopZadanieTest {
    @Test
    public void whenTwoArraysInOne() {
        DopZadanie arr = new DopZadanie();
        int[] a = {1, 3, 7, 12, 15};
        int[] b = {2, 4, 9, 13, 17};
        int[] res = arr.merge(a, b);
        int[] expect = {1, 2, 3, 4, 7, 9, 12, 13, 15, 17};
        assertThat(res, is(expect));
    }

    @Test
    public void whenTwoArraysInOne2() {
        DopZadanie arr = new DopZadanie();
        int[] a = {1, 4, 9, 33, 45};
        int[] b = {2, 10, 42, 123, 230, 555};
        int[] res = arr.merge(a, b);
        int[] expect = {1, 2, 4, 9, 10, 33, 42, 45, 123, 230, 555};
        assertThat(res, is(expect));
    }
}
