package ru.job4j.fp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class FunctionRangeTest2.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 07.12.2018.
 */

public class FunctionRangeTest2 {
    @Test
    public void whenLineFunction() {
        FunctionRange2 fr = new FunctionRange2();
        List<Double> result = fr.diapason(1, 10, (value) -> 2 * value);
        List<Double> expect = Arrays.asList(2D, 4D, 6D, 8D, 10D, 12D, 14D, 16D, 18D, 20D);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSquareFunction() {
        FunctionRange2 fr = new FunctionRange2();
        List<Double> result = fr.diapason(1, 10, value -> value * value);
        List<Double> expect = Arrays.asList(1D, 4D, 9D, 16D, 25D, 36D, 49D, 64D, 81D, 100D);
        assertThat(result, is(expect));
    }

    @Test
    public void whenLogFunction() {
        int start = 1;
        int end = 10;
        List<Double> expect = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            expect.add(Math.log(i));
        }
        FunctionRange2 fr = new FunctionRange2();
        List<Double> result = fr.diapason(1, 10, Math::log);
        assertThat(result, is(expect));
    }
}
