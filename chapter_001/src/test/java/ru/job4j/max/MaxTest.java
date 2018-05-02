package ru.job4j.max;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * class MaxTest - для тестирования класса Max
 * @author Artur Glyzin.
 * @since 01.05.2018.
 * @version 1.0.
 */

public class MaxTest {
    @Test
    public void whenFirsLessSecond() {
        Max maximum = new Max();
        assertThat(maximum.max(11,45), is(45));
    }
}