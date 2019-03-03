package ru.job4j.list;

import java.util.Iterator;

/**
 * Class SimpleQueue - implementation Queue.
 *
 * @param <E> - param.
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 04.03.2019.
 */

public class SimpleQueue<E> implements Iterable<E> {

    private SimpleStack<E> stack = new SimpleStack<>();

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     */

    public E poll() {
        return stack.list.removeFirst();
    }

    /**
     * Pushes an element onto the stack represented by this list.
     *
     * @param value - the element to push.
     */

    public void push(E value) {
        stack.push(value);
    }

    /**
     * Returns size of the list.
     *
     * @return size.
     */

    public int size() {
        return stack.size();
    }

    /**
     * Iterator for SimpleQueue.
     *
     * @return iterator.
     */

    @Override
    public Iterator<E> iterator() {
        return stack.iterator();
    }
}
