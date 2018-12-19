package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class MatrixIterator.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 19.12.2018.
 */

public class MatrixIterator implements Iterator {
    private final int[][] value;
    private int rowIndex;
    private int columnIndex;

    public MatrixIterator(int[][] value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        if (rowIndex >= value.length) {
            return false;
        }
        if (columnIndex >= value[rowIndex].length && rowIndex == value.length - 1) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (columnIndex >= value[rowIndex].length) {
            rowIndex++;
            columnIndex = 0;
        }
        return value[rowIndex][columnIndex++];
    }
}
