package ru.job4j.loop;

/**
 * Программа для расчета суммы четных числе в диапазоне от 1 до 10
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 13.10.2018.
 */

public class Counter {
    int sum = 0;

    public int add(int start, int finish) {
        for (int i = start; i <= finish; i++) {
            if ((i % 2 == 0)) {
                sum = sum + i;
            }
        }
        return sum;
    }
}