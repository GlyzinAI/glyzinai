package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Class SimpleSetTest - test for class SimpleSet.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 05.03.2019.
 */

public class SimpleSetTest {

    private SimpleSet<Integer> set;

    @Before
    public void beforeTest() {
        set = new SimpleSet<>();
        set.add(5);
        set.add(2);
        set.add(1);
        set.add(4);
    }

    @Test
    public void whenAddDuplicate() {
        assertThat(set.size(), is(4));
        set.add(4);
        assertThat(set.size(), is(4));
    }

    @Test
    public void whenNextElementCheckIterator() {
        Iterator<Integer> it = set.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenCheckSizeSet() {
        set.add(11);
        set.add(234);
        set.add(123);
        set.add(13);
        set.add(16);
        set.add(45);
        assertThat(set.size(), is(10));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModificationSetThenThrowException() {
        Iterator<Integer> it = set.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        set.add(100);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
    }
}