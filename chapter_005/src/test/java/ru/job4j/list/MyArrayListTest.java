package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Class MyArrayListTest - test for implementation ArrayList.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 11.03.2019.
 */

public class MyArrayListTest {

    private MyArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new MyArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(4);
        list.add(11);
        list.add(2);
        list.add(15);
        list.add(145);
    }

    @Test
    public void whenAddNineElementsThenCheckSizeAndUseGet() {
        assertThat(list.getSize(), is(9));
        assertThat(list.get(0), is(1));
        assertThat(list.get(2), is(5));
        assertThat(list.get(4), is(4));
        assertThat(list.get(7), is(15));
    }

    @Test
    public void whenAddMoreTwoElementsThenCheckSize() {
        list.add(432);
        list.add(21);
        assertThat(list.getSize(), is(11));
        assertThat(list.get(10), is(21));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenUseGetAndThrowException() {
        list.get(9);
        list.get(10);
        list.get(-4);
    }

    @Test
    public void whenCheckNextSequentialInvocation() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(11));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(15));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(145));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModificationListThenThrowException() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        list.add(100);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
    }


    @Test(expected = NoSuchElementException.class)
    public void whenCheckThrowException() {
        list = new MyArrayList<>();
        Iterator<Integer> it = list.iterator();
        it.next();
    }
}