package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleArray wrapper over array.
 *
 * @param <T> - param
 * @author Artur Glyzin.
 * @version 4.0.
 * @since 18.02.2019.
 */

public class SimpleArray<T> implements Iterable<T> {

    private Object[] array;
    private int index = 0;

    public SimpleArray(int size) {
        array = new Object[size];
    }

    /**
     * Appends the specified element to the end of this array.
     *
     * @param value - element to be appended to this array.
     */

    public void add(T value) {
        if (this.index == this.array.length) {
            throw new UnsupportedOperationException();
        }
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

    public T remove(int index) {
        T removed = this.get(index);
        System.arraycopy(this.array, index + 1, this.array, index, --this.index - index);
        this.array[this.index] = null;
        return removed;
    }

    /**
     * @return the number of elements in this array.
     */

    public int size() {
        return index;
    }

    /**
     * Returns the element at the specified position in this array.
     *
     * @param index - index of the element to return
     * @return the element at the specified position in this array.
     */

    @SuppressWarnings("unchecked")
    public T get(int index) {
        rangeCheckIndex(index);
        return (T) array[index];
    }

    /**
     * Method check index
     *
     * @param index - index of the element in array
     */

    public void rangeCheckIndex(int index) {
        if (index < 0 || index >= this.index) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * @return iterator for array
     */

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int currentElement;

            private int lastElement = -1;


            @Override
            public boolean hasNext() {
                return currentElement != index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.lastElement = this.currentElement;
                return SimpleArray.this.get(this.currentElement++);
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
        };
    }
}
