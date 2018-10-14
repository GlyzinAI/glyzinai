package ru.job4j.collections.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * CConvertListTest
 *
 * @author Artur Glyzin
 * @version 3.0.
 * @since 14.10.2018
 */

public class ConvertListTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList list = new ConvertList();
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
        ConvertList list = new ConvertList();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 2);
        int[][] expect = {
                {1, 2, 3, 4},
                {5, 6, 7, 0},
        };

        assertThat(result, is(expect));
    }

    @Test
    public void when8ElementsThen8Test() {
        ConvertList list = new ConvertList();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), 4);
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenConvertListArray() {
        ConvertList list = new ConvertList();
        List<int[]> arrList = new ArrayList<>();
        arrList.add(new int[]{1, 2, 3});
        arrList.add(new int[]{5, 8, 13, 22});
        List<Integer> result = list.convert(arrList);
        List<Integer> expect = Arrays.asList(1, 2, 3, 5, 8, 13, 22);
        assertThat(result, is(expect));
    }
}

