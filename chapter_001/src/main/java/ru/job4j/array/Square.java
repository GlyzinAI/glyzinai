package ru.job4j.array;

/**
 * Заполнить массив степенями чисел.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 27.07.2018.
 */

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = (int) Math.pow(i, 2);
        }
        return rst;
    }
}
