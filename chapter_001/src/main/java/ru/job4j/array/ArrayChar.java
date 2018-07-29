package ru.job4j.array;

/**
 * Use method startWith.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 28.07.2018.
 */

public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (data[i] != value[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
