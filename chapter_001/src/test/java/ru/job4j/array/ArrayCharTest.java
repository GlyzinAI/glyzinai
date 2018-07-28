package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test for use method startWith.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 28.07.2018.
 */

public class ArrayCharTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    @Test
    public void whenStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Mother");
        boolean result = word.startWith("Mat");
        assertThat(result, is(false));
    }
}
