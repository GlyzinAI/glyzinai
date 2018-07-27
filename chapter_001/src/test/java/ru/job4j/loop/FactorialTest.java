package ru.job4j.loop;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 02.05.2018.
 */

public class FactorialTest {
    @Test
    public void whenNum1() {
        Factorial fact = new Factorial();
        int result = fact.calc(8);
        assertThat(result, is(40320));
    }

    @Test
    public void whenNum2() {
        Factorial fact = new Factorial();
        int result = fact.calc(4);
        assertThat(result, is(24));
    }
}