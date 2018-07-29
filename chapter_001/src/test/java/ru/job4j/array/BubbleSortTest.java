package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test. Array sorted (BubbleSort).
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 29.07.2018.
 */

public class BubbleSortTest {
    @Test
    public void whenBubbleSort() {
        BubbleSort s = new BubbleSort();
        int[] massiv = {5, 1, 2, 3, 7};
        int[] result = s.sort(massiv);
        int[] expect = {1, 2, 3, 5, 7};
        assertThat(result, is(expect));
    }

    @Test
    public void whenBubbleSort2() {
        BubbleSort s = new BubbleSort();
        int[] massiv = {91, 3, 222, 75, 9};
        int[] result = s.sort(massiv);
        int[] expect = {3, 9, 75, 91, 222};
        assertThat(result, is(expect));
    }
}
