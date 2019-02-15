package ru.job4j.generics;

import java.util.Iterator;

/**
 * Class SimpleArray wrapper over array.
 *
 * @param <T> - param
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 15.02.2019.
 */

public class SimpleArray<T> implements Iterable<T> {

    private static final Object[] EMPTY_ARRAY = {};

    Object[] array;
    int index = 0;

    public SimpleArray(int size) {
        if (size > 0) {
            this.array = new Object[size];
        } else if (size == 0) {
            this.array = EMPTY_ARRAY;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + array.length);
        }
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
        rangeCheckIndex(index);
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
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
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
        index = 0;
        return new ElementIterator<T>();
    }

    private class ElementIterator<T> implements Iterator<T> {


        @Override
        public boolean hasNext() {
            if (index < array.length) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            return (T) array[index++];
        }
    }
}
