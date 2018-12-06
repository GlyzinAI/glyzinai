package ru.job4j.fp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class CalculatorTest {
    @Test
    public void whenAdd1Until3() {
        Calculator calculator = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calculator.multiple2(0, 3, 1, MathUtil::add,
                buffer::add);
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }
}
