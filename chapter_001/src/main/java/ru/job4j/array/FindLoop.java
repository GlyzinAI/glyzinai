package ru.job4j.array;

/**
 * Поиск перебором.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 27.07.2018.
 */

public class FindLoop {
    public int indexOf(int[] data, int el) {

        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
