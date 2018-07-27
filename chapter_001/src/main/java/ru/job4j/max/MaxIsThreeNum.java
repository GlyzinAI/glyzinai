package ru.job4j.max;

/**
 * class MaxIsThreeNum - класс возвращает максимум из трех чисел.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 01.05.2018.
 */

public class MaxIsThreeNum {
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);

    }

    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
