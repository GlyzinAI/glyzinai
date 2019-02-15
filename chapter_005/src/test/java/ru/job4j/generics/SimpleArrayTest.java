package ru.job4j.generics;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class SimpleArrayTest for testing SimpleArray class.
 *
 * @author Artur Glyzin.
 * @version 3.0.
 * @since 15.02.2019.
 */

public class SimpleArrayTest {

    private SimpleArray<Integer> array;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        array = new SimpleArray<>(6);
        array.add(5);
        array.add(10);
        array.add(15);
        array.add(20);
        array.add(25);
    }

    @Test
    public void whenCheckAddNewElement() {
        array.add(30);
        assertThat(array.get(5), is(30));
    }

    @Test
    public void whenCheckThrowException() {
        thrown.expect(ArrayIndexOutOfBoundsException.class);
        array.add(1);
        array.add(2);
        thrown = ExpectedException.none();
    }

    @Test
    public void whenCheckMethodSet() {
        array.set(1, 111);
        assertThat(array.get(1), is(111));
    }

    @Test
    public void whenCheckInputIndex() {
        thrown.expect(IndexOutOfBoundsException.class);
        array.set(11, 222);
        thrown = ExpectedException.none();
    }

    @Test
    public void whenCheckRemoveElementIsArray() {
        array.remove(0);
        assertThat(array.get(0), is(10));
        assertThat(array.size(), is(5));
    }

    @Test
    public void whenCheckReturnElement() {
        int res = array.get(2);
        assertThat(res, is(15));
    }

    @Test
    public void rangeCheckIndex() {
        thrown.expect(IndexOutOfBoundsException.class);
        array.get(8);
        thrown = ExpectedException.none();
    }

    @Test
    public void whenNextNextSequentialInvocation() {
        array.add(100); // добавляем последний элемент
        Iterator it = array.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(15));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(20));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(25));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(100));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenNextMethodDoesntDependsOnPriorHasNextInvocation() {
        Iterator it = array.iterator();
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(15));
        assertThat(it.next(), is(20));
        assertThat(it.next(), is(25));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenCheckNoSuchElementException() {
        array = new SimpleArray<>(0);
        Iterator it = array.iterator();
        it.next();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkIndexOutBoundsException() {
        SimpleArray array2 = new SimpleArray<>(10);
        array2.set(5, 1);

    }
}