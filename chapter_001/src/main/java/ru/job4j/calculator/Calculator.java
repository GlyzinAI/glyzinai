package ru.job4j.calculator;

/**
 * class Calculator - для арифметических вычислений +,-,*,/.
 * @author Artur Glyzin.
 * @since 30.04.2018.
 * @version 2.0.
 */

public class Calculator {
    private double result;

    /**
     * method add - метод вычисляющий сумму чисел.
     * @param first - первый аргумент.
     * @param second - второй аргумент.
     */

    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * method getResult возвращает значения поля result.
     * @return значения поля result.
     */

    public double getResult() {
        return this.result;
    }

    /**
     * method subtract - метод вычисляющий разницу чисел.
     * @param first - первый аргумент.
     * @param second - второй аргумент.
     */

    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * method div - метод вычисляющий перемножение чисел.
     * @param first - первый аргумент.
     * @param second - второй аргумент.
     */

    public void div(double first, double second) {
        this.result = first * second;

    }

    /**
     * method multiple - метод для вычисления деления одного аргумента на другой.
     * @param first - первый аргумент.
     * @param second - второй аргумент.
     */

    public void multiple(double first, double second) {
        this.result = first / second;
    }


}