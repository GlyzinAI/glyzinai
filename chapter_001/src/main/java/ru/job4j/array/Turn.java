package ru.job4j.array;

/**
 * Перевернуть массив.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 27.07.2018.
 */

public class Turn {
    public int[] back(int[] array) {

        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        return array;
    }
}