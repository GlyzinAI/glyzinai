package ru.job4j.array;

/**
 * Array true or false
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 28.07.2018.
 */


public class Check {
    public static boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 1; i < data.length; i++) {
            if (data[i] != data[0]) {
                result = false;
                break;
            } else
                result = true;

        }
        return result;
    }
}
