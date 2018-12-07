package ru.job4j.fp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class FunctionRangeTest.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 07.12.2018.
 */

public class FunctionRangeTest {
    @Test
    public void whenLineFunction() {
        FunctionRange fr = new FunctionRange();
        List<Double> res = fr.lineFunc(1, 10, 2, 5, (var1, var2) -> var1 * var2);
        List<Double> expect = Arrays.asList(7D, 12D, 17D, 22D, 27D, 32D, 37D, 42D, 47D, 52D);
        assertThat(res, is(expect));
    }

    @Test
    public void whenSquareFunction() {
        FunctionRange fr = new FunctionRange();
        List<Double> res = fr.squareFunc(1, 10, 2, 8, 5, x -> x);
        List<Double> expect = Arrays.asList(15D, 29D, 47D, 69D, 95D, 125D, 159D, 197D, 239D, 285D);
        assertThat(res, is(expect));
    }

    @Test
    public void whenLogFunction() {
        int start = 1;
        int end = 10;
        FunctionRange fr = new FunctionRange();
        List<Double> expect = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            expect.add(Math.log(i));
        }
        List<Double> res = fr.logFunc(1, 10, Math::log);
        assertThat(res, is(expect));
    }
}
