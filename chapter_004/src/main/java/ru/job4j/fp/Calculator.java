package ru.job4j.fp;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;

public class Calculator {
    public void multiple(int start, int finish, int value, Operation operation) {
        for (int i = start; i < finish; i++) {
            System.out.println(operation.calc(value, i));
        }
    }

    public void multiple2(int start, int finish, int value, BiFunction<Integer, Integer, Double> op, Consumer<Double> media) {
        for (int i = start; i < finish; i++) {
            media.accept(op.apply(value, i));
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        /*calculator.multiple(0, 10, 2, new Operation() {
            @Override
            public double calc(int left, int right) {
                return left * right;
            }
        });*/

        // calculator.multiple(0, 10, 2, (value, index) -> value * index);

        calculator.multiple(0, 10, 2, (value, index) -> {
            int res = value * index;
            System.out.printf("Multiple %s * %s = %s %n", value, index, res);
            return res;
        });

        calculator.multiple2(0, 10, 2, (value, index) -> {
                    double res = value * index;
                    System.out.printf("Multiply %s * %s = %s %n", value, index, res);
                    return res;
                }, System.out::println
        );

        //reference

        Calculator calc = new Calculator();
        calc.multiple2(0, 10, 2, MathUtil::add, System.out::println);
    }
}
