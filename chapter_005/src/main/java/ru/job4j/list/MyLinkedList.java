package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class MyLinkedList - implementation LinkedList.
 *
 * @param <E> - param.
 * @author Artur Glyzin.
 * @version 3.0.
 * @since 03.03.2019.
 */

public class MyLinkedList<E> implements Iterable<E> {

    private static class Node<E> {
        private Node<E> prev;
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    private int size;
    private Node<E> first;
    private Node<E> last;
    private int modCount;

    /**
     * Appends the specified element to the end of this list.
     *
     * @param value element to be appended to this list.
     */

    public void add(E value) {
        Node<E> lastElement = last;
        Node<E> newNode = new Node<>(lastElement, value, null);
        last = newNode;
        if (lastElement == null) {
            first = newNode;
        } else {
            lastElement.next = newNode;
        }
        size++;
        modCount++;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return.
     * @return the element at the specified position in this list.
     */

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    /**
     * Removes the last element in this list.
     *
     * @return the last element.
     */

    public E removeLast() {
        Node<E> node = last;
        if (node == null) {
            throw new NoSuchElementException();
        }
        E element = node.data;
        Node<E> prev = node.prev;
        node.data = null;
        node.prev = null;
        last = prev;
        if (last == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;
        modCount++;
        return element;
    }

    public int getSize() {
        return size;
    }

    /**
     * Implementation iterator for MyLinkedList.
     *
     * @return iterator.
     */

    @Override
    public Iterator<E> iterator() {
        return new Itr<>();
    }

    private class Itr<E> implements Iterator<E> {
        private int cursor;
        private int expectedModCount = modCount;
        private Node<E> node = (Node<E>) first;


        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            checkModification();
            if (cursor >= size) {
                throw new NoSuchElementException();
            }

            E result = node.data;
            node = node.next;
            cursor++;
            return result;
        }

        final void checkModification() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
