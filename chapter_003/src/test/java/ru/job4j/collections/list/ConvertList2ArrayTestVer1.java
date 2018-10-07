package ru.job4j.collections.list;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * CConvertList2ArrayTestVer1
 *
 * @author Artur Glyzin
 * @version 1.0.
 * @since 07.10.2018
 */

public class ConvertList2ArrayTestVer1 {
    @Test
    public void when7ElementsThen9() {
        ConvertList2ArrayVer1 list = new ConvertList2ArrayVer1();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };

        assertThat(result, is(expect));
    }

    @Test
    public void whenRows2() {
        ConvertList2ArrayVer1 list = new ConvertList2ArrayVer1();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 2);
        int[][] expect = {
                {1, 2, 3, 4},
                {5, 6, 7, 0},
        };

        assertThat(result, is(expect));
    }

    @Test
    public void when8ElementsThen8Test() {
        ConvertList2ArrayVer1 list = new ConvertList2ArrayVer1();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), 4);
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        assertThat(result, is(expect));
    }
}

