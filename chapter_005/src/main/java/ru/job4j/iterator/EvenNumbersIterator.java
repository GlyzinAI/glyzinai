package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenNumbersIterator.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 10.02.2019.
 */

public class EvenNumbersIterator implements Iterator {
    private final int[] numbers;
    private int index = 0;

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */

    @Override
    public boolean hasNext() {
        for (int i = index; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        while (numbers[index] % 2 != 0) {
            index++;
        }
        return numbers[index++];
    }
}
