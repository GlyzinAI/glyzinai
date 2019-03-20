package ru.job4j.list;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;

/**
 * SimpleHashMapTest - test for implementation HashMap.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 20.03.2019.
 */

public class SimpleHashMapTest {

    private SimpleHashMap<Integer, String> map;

    @Before
    public void beforeTest() {
        map = new SimpleHashMap<>();
        map.insert(1, "Mike");
        map.insert(1, "Mike");
        map.insert(2, "Alex");
        map.insert(2, "Alex");
    }

    @Test
    public void whenInsertFourElementCheckPutMethod() {
        assertThat(map.size(), is(2));
        map.insert(3, "Jack");
        map.insert(4, "John");
        map.insert(5, "Petr");
        map.insert(6, "Den");
        map.insert(7, "Max");
        map.insert(8, "Filip");
        map.insert(9, "Flex");
        map.insert(9, "Ben");
        map.insert(9, "Anton");
        map.insert(10, "Mary");
        map.insert(11, "Elena");
        assertThat(map.size(), is(11));
        map.insert(12, "Yan");
        assertThat(map.size(), is(12));
    }

    @Test
    public void whenCheckGetMethod() {
        assertThat(map.get(1), is("Mike"));
        assertThat(map.get(2), is("Alex"));
    }

    @Test
    public void whenCheckRemoveMethod() {
        map.delete(1);
        assertThat(map.size(), is(1));
        map.delete(2);
        assertThat(map.size(), is(0));
    }

    @Test
    public void whenCheckNextSequentialInvocation() {
        map.insert(5, "Fred");
        map.insert(3, "Don");
        Iterator it = map.iterator();
        assertThat(map.size(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Mike"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Alex"));
        assertThat(it.next(), is("Don"));
        assertThat(it.next(), is("Fred"));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenCheckHasNextMethodIterator() {
        Iterator<String> it = map.iterator();
        assertTrue(it.hasNext());
        assertTrue(it.hasNext());
        it.next();
        it.next();
        assertFalse(it.hasNext());
        assertFalse(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenCheckThrowNoSuchElementException() {
        Iterator<String> it = map.iterator();
        it.next();
        assertThat(it.next(), is("Alex"));
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCheckThrowConcurrentModificationException() {
        Iterator<String> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Mike"));
        map.insert(10, "Victor");
        assertThat(it.next(), is("Alex"));
    }

    @Test
    public void whenCheckIteratorIfResizeTable() {
        map.insert(3, "Jack");
        map.insert(4, "John");
        map.insert(5, "Petr");
        map.insert(6, "Den");
        map.insert(7, "Max");
        map.insert(8, "Filip");
        map.insert(9, "Flex");
        map.insert(10, "Ben");
        map.insert(11, "Anton");
        map.insert(12, "Eva");
        map.insert(17, "Elena");
        Iterator<String> it = map.iterator();
        assertTrue(it.hasNext());
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        assertThat(it.next(), is("Elena"));
        assertThat(it.hasNext(), is(false));
    }
}