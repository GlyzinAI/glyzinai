package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Class SimpleQueueTest - test for class SimpleQueue.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 04.03.2019.
 */

public class SimpleQueueTest {

    private SimpleQueue<Integer> queue;

    @Before
    public void beforeTest() {
        queue = new SimpleQueue<>();
        queue.push(11);
        queue.push(7);
        queue.push(4);
        queue.push(25);
        queue.push(18);
    }

    @Test
    public void whenAddFiveElementsCheckSize() {
        assertThat(queue.size(), is(5));
    }

    @Test
    public void whenAddFiveElementsCheckUsePoll() {
        assertThat(queue.poll(), is(11));
        assertThat(queue.poll(), is(7));
        assertThat(queue.poll(), is(4));
        assertThat(queue.poll(), is(25));
        assertThat(queue.poll(), is(18));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenCheckThrowNoSuchElementException() {
        assertThat(queue.poll(), is(11));
        assertThat(queue.poll(), is(7));
        assertThat(queue.poll(), is(4));
        assertThat(queue.poll(), is(25));
        assertThat(queue.poll(), is(18));
        assertThat(queue.poll(), is(15));
    }

    @Test
    public void whenNextElementCheckIterator() {
        Iterator<Integer> it = queue.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(11));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(25));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(18));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextElementCheckThrowNoSuchElementException() {
        Iterator<Integer> it = queue.iterator();
        assertThat(it.next(), is(11));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(25));
        assertThat(it.next(), is(18));
        assertThat(it.next(), is(19));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModificationCheckThrowException() {
        Iterator<Integer> it = queue.iterator();
        assertThat(it.next(), is(11));
        assertThat(it.next(), is(7));
        queue.poll();
        assertThat(it.next(), is(4));
    }
}