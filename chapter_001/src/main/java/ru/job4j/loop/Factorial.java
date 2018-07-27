package ru.job4j.loop;

/**
 * Программа для расчета факторила цисла
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 02.05.2018.
 */

public class Factorial {
    int result = 1;

    public int calc(int n) {
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}