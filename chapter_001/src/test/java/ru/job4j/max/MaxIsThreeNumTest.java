package ru.job4j.max;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Artur Glyzin.
 * @since 01.05.2018.
 * @version 1.0.
 */

public class MaxIsThreeNumTest {
    @Test
    public void whenFirsLessSecond() {
        MaxIsThreeNum maximum = new MaxIsThreeNum();
        assertThat(maximum.max(11,3,8), is(11));
    }
}