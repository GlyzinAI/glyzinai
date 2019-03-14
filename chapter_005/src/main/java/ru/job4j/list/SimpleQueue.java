package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleQueue - implementation Queue.
 *
 * @param <E> - param.
 * @author Artur Glyzin.
 * @version 3.0.
 * @since 14.03.2019.
 */

public class SimpleQueue<E> implements Iterable<E> {

    private SimpleStack<E> inputStack = new SimpleStack<>();
    private SimpleStack<E> outputStack = new SimpleStack<>();
    private int size;

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     */

    public E poll() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.poll());
            }
        }

        E element = null;
        if (!outputStack.isEmpty()) {
            element = outputStack.poll();
            size--;
        } else {
            throw new NoSuchElementException();
        }
        return element;
    }

    /**
     * Pushes an element onto the stack represented by this list.
     *
     * @param value - the element to push.
     */

    public void push(E value) {
        inputStack.push(value);
        size++;
    }

    /**
     * Returns size of the list.
     *
     * @return size.
     */

    public int size() {
        return this.size;
    }

    /**
     * Iterator for SimpleQueue.
     *
     * @return iterator.
     */

    @Override
    public Iterator<E> iterator() {
        return inputStack.iterator();
    }
}
