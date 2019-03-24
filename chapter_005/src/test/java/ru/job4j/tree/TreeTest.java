package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * TreeTest - test for Tree class.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 24.03.2019.
 */

public class TreeTest {
    private Tree<Integer> tree;

    @Before
    public void beforeTest() {
        tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
    }

    @Test
    public void whenCheckAddedElements() {
        assertThat(tree.findBy(6).isPresent(), is(true));
        assertThat(tree.findBy(3).isPresent(), is(true));
        assertThat(tree.findBy(2).isPresent(), is(true));
    }

    @Test
    public void whenCheckNonAddedElements() {
        assertThat(tree.findBy(7).isPresent(), is(false));
        assertThat(tree.findBy(9).isPresent(), is(false));
        assertThat(tree.findBy(20).isPresent(), is(false));
    }

    @Test
    public void whenCheckNextElementUseIterator() {
        Iterator<Integer> it = tree.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenCheckThrowNoSuchElementException() {
        Iterator<Integer> it = tree.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(8));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCheckThrowConcurrentModificationException() {
        Iterator<Integer> it = tree.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        tree.add(1, 8);
        assertThat(it.next(), is(3));
    }

    @Test
    public void whenChildrenAmountIsThreeThenIsBinaryReturnsFalse() {
        assertThat(this.tree.isBinary(), is(false));
    }

    @Test
    public void whenChildrenAmountTwoOrLessThenIsBinaryReturnsTrue() {
        tree = new Tree<>(0);
        tree.add(0, 1);
        tree.add(0, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(2, 5);
        tree.add(2, 6);
        tree.add(4, 7);
        tree.add(5, 8);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenChildrenAmountThreeThenIsBinaryReturnsFalse() {
        tree = new Tree<>(5);
        tree.add(5, 6);
        tree.add(5, 7);
        tree.add(6, 8);
        tree.add(6, 9);
        tree.add(6, 10);
        tree.add(8, 11);
        tree.add(9, 12);
        assertThat(tree.isBinary(), is(false));
    }

    @Test
    public void whenAddNewElementsTreeGetDuplicate() {
        tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 4);
        Iterator<Integer> it = tree.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
    }
}
