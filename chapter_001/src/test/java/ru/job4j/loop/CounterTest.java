package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Artur Glyzin.
 * @since 02.05.2018.
 * @version 1.0.
 */


public class CounterTest {
    @Test
    public void whenSumEvenNum() {
        Counter count = new Counter();
        int result = count.add(1,10);
        assertThat(result, is(30));
    }
}