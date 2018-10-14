package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Draw pyramid
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 13.10.2018.
 */

public class RefactoringPaint {
    public String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder builder = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i != height; i++) {
            for (int j = 0; j != weight; j++) {
                if (predict.test(i, j)) {
                    builder.append("^");
                } else {
                    builder.append(" ");
                }
            }
            builder.append(ln);
        }
        return builder.toString();
    }

    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (i, j) -> i >= height - j - 1
        );
    }
}

