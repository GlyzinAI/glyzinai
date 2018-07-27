package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тест. Заполнить массив степенями чисел.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 27.07.2018.
 */

public class SquareTest {
    @Test
    public void whenBound5() {
        Square square = new Square();
        int bound = 5;
        int[] result = square.calculate(bound);
        int[] expect = {1, 4, 9, 16, 25};
        assertThat(result, is(expect));
    }

    @Test
    public void whenBound7() {
        Square square = new Square();
        int bound = 7;
        int[] result = square.calculate(bound);
        int[] expect = {1, 4, 9, 16, 25, 36, 49};
        assertThat(result, is(expect));
    }

    @Test
    public void whenBound3() {
        Square square = new Square();
        int bound = 3;
        int[] result = square.calculate(bound);
        int[] expect = {1, 4, 9};
        assertThat(result, is(expect));
    }


}
