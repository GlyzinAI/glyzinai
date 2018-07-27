package ru.job4j.array;

/**
 * Array true or false
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 27.07.2018.
 */


public class Check {
    public static boolean mono(boolean[] data) {
        boolean result = false;
        int count = 0;
        int count1 = 0;
        for (boolean b : data) {
            if (b)
                count++;
            else
                count1++;
        }
        if (count == data.length || count1 == data.length)
            result = true;

        return result;
    }
}
