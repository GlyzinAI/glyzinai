package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test. Array dublicate remove.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 29.07.2018.
 */

public class ArrayDublicateTest {
    @Test
    public void whenArrayHasDublicate() {
        ArrayDublicate dublicate = new ArrayDublicate();
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expect = {"Привет", "Мир", "Супер"};
        String[] result = dublicate.remove(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasDublicate2() {
        ArrayDublicate dublicate = new ArrayDublicate();
        String[] input = {"Природа", "Море", "Море", "Природа"};
        String[] expect = {"Природа", "Море"};
        String[] result = dublicate.remove(input);
        assertThat(result, is(expect));
    }
}
