package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class MyArrayList - implementation ArrayList.
 *
 * @param <E> - param.
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 27.02.2019.
 */

public class MyArrayList<E> implements Iterable<E> {
    private int size;
    private E[] array;
    private int modCount;

    public MyArrayList() {
        array = (E[]) new Object[10];
        size = 0;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param value - element to be appended to this list.
     */

    public void add(E value) {
        if (size >= array.length) {
            E[] bigger = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }
        array[size] = value;
        size++;
        modCount++;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index of the element to return.
     * @return the element at the specified position in this list.
     */

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    /**
     * Return size of the list.
     *
     * @return size.
     */

    public int getSize() {
        return size;
    }

    /**
     * Iterator for MyArrayList.
     *
     * @return iterator.
     */

    @Override
    public Iterator<E> iterator() {
        return new Itr<>();
    }

    private class Itr<E> implements Iterator<E> {

        private int cursor;
        private int lastElement = -1;
        private int expectedModCount = modCount;


        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            checkForModification();
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            lastElement = cursor;
            return (E) get(cursor++);
        }

        final void checkForModification() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
