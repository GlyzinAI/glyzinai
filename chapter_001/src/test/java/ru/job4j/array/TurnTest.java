package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Перевернуть массив.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 27.07.2018.
 */

public class TurnTest {
    @Test
    public void whenTurnArray1() {
        Turn turn = new Turn();
        int[] massiv = {1, 2, 3, 4, 5};
        int[] result = turn.back(massiv);
        int[] expect = {5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTurnArray2() {
        Turn turn = new Turn();
        int[] massiv = {4, 1, 6, 2};
        int[] result = turn.back(massiv);
        int[] expect = {2, 6, 1, 4};
        assertThat(result, is(expect));
    }

}
