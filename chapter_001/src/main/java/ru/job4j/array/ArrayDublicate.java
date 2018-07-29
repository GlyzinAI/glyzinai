package ru.job4j.array;

import java.util.Arrays;

/**
 * Array dublicate remove.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 29.07.2018.
 */

public class ArrayDublicate {
    public static String[] remove(String[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[size - 1];
                    size--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, size);
    }
}
