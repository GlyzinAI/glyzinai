package ru.job4j.max;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 13.10.2018.
 */

public class MaxIsThreeNumTest {
    @Test
    public void whenFirsLessSecond() {
        MaxIsThreeNum maximum = new MaxIsThreeNum();
        assertThat(maximum.max(11, 3, 8), is(11));
    }
}