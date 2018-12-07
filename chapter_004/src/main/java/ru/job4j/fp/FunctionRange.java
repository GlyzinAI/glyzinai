package ru.job4j.fp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Class FunctionRange.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 07.12.2018.
 */

public class FunctionRange {
    List<Double> lineFunc(int start, int end, double a, double k, BiFunction<Double, Double, Double> function) {
        List<Double> list = new ArrayList<>();
        for (double x = start; x <= end; x++) {
            list.add(function.apply(k, x) + a);
        }
        return list;
    }

    List<Double> squareFunc(int start, int end, double a, double b, double c, Function<Double, Double> function) {
        List<Double> list = new ArrayList<>();
        for (double x = start; x <= end; x++) {
            list.add(a * Math.pow(function.apply(x), 2) + b * function.apply(x) + c);
        }
        return list;
    }

    List<Double> logFunc(int start, int end, Function<Double, Double> function) {
        List<Double> list = new ArrayList<>();
        for (double x = start; x <= end; x++) {
            list.add(function.apply(x));
        }
        return list;
    }
}
