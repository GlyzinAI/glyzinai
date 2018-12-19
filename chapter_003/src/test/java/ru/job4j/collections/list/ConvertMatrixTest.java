package ru.job4j.collections.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * ConvertMatrixTest
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 19.12.2018.
 */

public class ConvertMatrixTest {
    @Test
    public void whenArrayToList() {
        ConvertMatrix list = new ConvertMatrix();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = List.of(1, 2, 3, 4);
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayToList2() {
        ConvertMatrix list = new ConvertMatrix();
        int[][] input = {
                {3, 5, 7, 4},
                {11, 13, 8, 16},
                {44, 76, 0, 56}
        };
        List<Integer> expect = List.of(3, 5, 7, 4, 11, 13, 8, 16, 44, 76, 0, 56);
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayToList3() {
        ConvertMatrix list = new ConvertMatrix();
        int[][] input = {
                {11, 12, 13},
                {14, 15, 16, 17},
                {18, 19, 20, 21, 22}
        };
        List<Integer> expect = List.of(11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22);
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}
