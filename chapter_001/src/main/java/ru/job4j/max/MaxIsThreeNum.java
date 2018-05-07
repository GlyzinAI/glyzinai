package ru.job4j.max;

/**
 * class MaxIsThreeNum - класс возвращает максимум из трех чисел.
 * @author Artur Glyzin.
 * @since 01.05.2018.
 * @version 1.0.
 */

public class MaxIsThreeNum {
    public int max(int first, int second, int third) {
    int temp = this.max(first,second);
    temp = this.max(temp,third);
    return temp;

    }
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
