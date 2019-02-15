package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleArray wrapper over array.
 *
 * @param <T> - param
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 15.02.2019.
 */

public class SimpleArray<T> implements Iterable<T> {

    Object[] array;
    int index = 0;

    public SimpleArray(int size) {
        array = new Object[size];
    }

    /**
     * Appends the specified element to the end of this array.
     *
     * @param value - element to be appended to this array.
     */

    public void add(T value) {
        this.array[index++] = value;
    }

    /**
     * Replaces the element at the specified position in this array with the specified element.
     *
     * @param index - index of the element to replace.
     * @param value - element to be stored at the specified position.
     */

    public void set(int index, T value) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        this.array[index] = value;
    }

    /**
     * Removes the element at the specified position in this array.
     *
     * @param index - the index of the element to be removed.
     */

    public void remove(int index) {
        rangeCheckIndex(index);
        Object[] newArray = new Object[array.length - 1];
        System.arraycopy(array, index + 1, newArray, index, array.length - 1 - index);
        array = newArray;
    }

    /**
     * @return the number of elements in this array.
     */

    public int size() {
        return array.length;
    }

    /**
     * Returns the element at the specified position in this array.
     *
     * @param index - index of the element to return.
     * @param <T>   - param.
     * @return the element at the specified position in this array.
     */

    public <T> T get(int index) {
        rangeCheckIndex(index);
        return (T) array[index];
    }

    /**
     * Method check index
     *
     * @param index - index of the element in array
     */

    public void rangeCheckIndex(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * @return iterator for array
     */

    @Override
    public Iterator<T> iterator() {
        return new ElementIterator<T>();
    }

    private class ElementIterator<T> implements Iterator<T> {

        private int currentElement;

        private int lastElement = -1;


        @Override
        public boolean hasNext() {
            return this.currentElement != array.length;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.lastElement = currentElement;
            return SimpleArray.this.get(currentElement++);
        }

        @Override
        public void remove() {
            if (this.lastElement == -1) {
                throw new UnsupportedOperationException();
            }
            SimpleArray.this.remove(this.lastElement);
            this.lastElement = -1;
            this.currentElement--;
        }
    }
}
