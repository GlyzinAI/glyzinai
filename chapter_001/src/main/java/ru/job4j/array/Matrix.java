package ru.job4j.array;

/**
 * Table multiple array[size][size].
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 29.07.2018.
 */

public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }
        return table;
    }
}
