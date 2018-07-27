package ru.job4j.loop;

/**
 * Программа для расчета суммы четных числе в диапазоне от 1 до 10
 * @author Artur Glyzin.
 * @since 02.05.2018.
 * @version 1.0.
 */

public class Counter {
    int sum = 0;
    public int add(int start, int finish) {
        for (int i = start; i <= finish; i++) {
            if ((i%2 == 0)) {
                sum = sum + i;
            }
        }
        return sum;
    }
}