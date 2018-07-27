package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Поиск перебором.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 27.07.2018.
 */

public class FindLoopTest {
    @Test
    public void whenFindIndexOfArray1() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{2, 3, 5, 57, 9, 13};
        int value = 57;
        int result = findLoop.indexOf(input, value);
        int expect = 3;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFindIndexOfArray2() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{1, 7, 9, 222};
        int value = 1;
        int result = findLoop.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

}
