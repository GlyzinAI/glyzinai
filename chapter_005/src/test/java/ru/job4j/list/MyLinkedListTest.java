package ru.job4j.list;

import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Class MyLinkedListTest - test for implementation LinkedList.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 27.02.2019.
 */

public class MyLinkedListTest {

    private MyLinkedList<Integer> list;

    @Before
    public void beforeTest() {
        list = new MyLinkedList<>();
        list.add(24);
        list.add(67);
        list.add(78);
        list.add(88);
    }

    @Test
    public void whenAddThreeElementsThenCheckSizeAndUseGet() {
        assertThat(list.get(0), is(24));
        assertThat(list.get(1), is(67));
        assertThat(list.get(3), is(88));
        assertThat(list.getSize(), is(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenUseGetAndThrowException() {
        list.get(4);
        list.get(10);
        list.get(-1);
    }

    @Test
    public void whenCheckNextSequentialInvocation() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(24));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(67));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(78));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(88));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModificationListThenThrowException() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(24));
        list.add(111);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(67));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenCallNextMethodThenThrowException() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.next(), is(24));
        assertThat(it.next(), is(67));
        assertThat(it.next(), is(78));
        assertThat(it.next(), is(88));
        assertThat(it.next(), is(111));
    }

}