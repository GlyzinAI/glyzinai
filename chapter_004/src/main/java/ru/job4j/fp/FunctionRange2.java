package ru.job4j.fp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Class FunctionRange2.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 07.12.2018.
 */

public class FunctionRange2 {
    List<Double> diapason(int start, int end, Function<Double, Double> function) {
        List<Double> range = new ArrayList<>();
        for (int x = start; x <= end; x++) {
            range.add(function.apply((double) x));
        }
        return range;
    }
}
