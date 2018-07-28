package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Array true or false
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 28.07.2018.
 */

public class CheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true};
        boolean res = check.mono(input);
        assertThat(res, is(true));
    }

    @Test
    public void whenDataMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, false, true};
        boolean res = check.mono(input);
        assertThat(res, is(false));
    }

    @Test
    public void whenDataMonoByFalseThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, false, false};
        boolean res = check.mono(input);
        assertThat(res, is(true));
    }

    @Test
    public void whenDataMonoByTrueThenFalse2() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, false, true};
        boolean res = check.mono(input);
        assertThat(res, is(false));
    }

    @Test
    public void whenDataMonoByFalseThenFalse2() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, false, false, false, false};
        boolean res = check.mono(input);
        assertThat(res, is(true));
    }
}
