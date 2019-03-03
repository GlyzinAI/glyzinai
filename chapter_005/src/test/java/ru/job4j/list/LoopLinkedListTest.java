package ru.job4j.list;

import org.junit.Before;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import org.junit.Test;
import ru.job4j.list.LoopLinkedList.Node;

/**
 * Class LoopLinkedListTest - test for LoopLinkedList.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 04.03.2019.
 */

public class LoopLinkedListTest {

    private LoopLinkedList<Integer> list;
    private Node first;
    private Node two;
    private Node third;
    private Node four;

    @Before
    public void beforeTest() {
        list = new LoopLinkedList<>();
        first = new Node(1);
        two = new Node(2);
        third = new Node(3);
        four = new Node(4);
    }

    @Test
    public void whenNoLoopElement() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(list.hasCycle(first), is(false));
    }

    @Test
    public void whenThirdElementRefTwoElement() {
        first.next = two;
        two.next = third;
        third.next = two;
        four.next = null;
        assertThat(list.hasCycle(first), is(true));
    }

    @Test
    public void whenLoopLatElement() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(list.hasCycle(first), is(true));
    }
}