package ru.job4j.loop;

/**
 * Draw pyramid
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 27.07.2018.
 */

public class Paint {
    public static String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = height * 2;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight - 1; j++) {
                if (i >= height - j - 1 && i + height - 1 >= j) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
