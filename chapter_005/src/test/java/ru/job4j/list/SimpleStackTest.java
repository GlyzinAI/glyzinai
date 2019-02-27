package ru.job4j.list;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleStackTest - test for implementation Stack.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 28.02.2019.
 */

public class SimpleStackTest {

    private SimpleStack<Integer> stack;

    @Before
    public void beforeTest() {
        stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void whenAddThreeElementsThenCheckSize() {
        assertThat(stack.size(), is(3));
    }

    @Test
    public void whenAddThreeElementsThenCheckUsePop() {
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.size(), is(1));
        assertThat(stack.poll(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUsePopThenThrowException() {
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
        assertThat(stack.poll(), is(0));
    }

    @Test
    public void whenNextElementCheckIterator() {
        Iterator<Integer> it = stack.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextNextElementThenThrowException() {
        Iterator<Integer> it = stack.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModificationThenThrowException() {
        Iterator<Integer> it = stack.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        stack.push(4);
        assertThat(it.next(), is(3));
    }
}