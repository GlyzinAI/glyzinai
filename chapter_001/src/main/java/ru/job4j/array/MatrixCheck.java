package ru.job4j.array;

/**
 * Matrix true or false.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 29.07.2018.
 */

public class MatrixCheck {
    public static boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i][i] != data[0][0] || data[i][data.length - i - 1] != data[0][data.length - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
