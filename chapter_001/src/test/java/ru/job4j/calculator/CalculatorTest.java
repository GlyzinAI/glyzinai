package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * class CalculatorTest - класс для тестировния всех методов класса Calculator.
 * @author Artur Glyzin.
 * @since 06.03.2018.
 * @version 1.0.
 */

public class CalculatorTest {

    /**
     * Test method add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test method subtract.
     */
    @Test
    public void whenAddTwoMinusOneThenOne() {
        Calculator calc = new Calculator();
        calc.subtract(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test method div.
     */
    @Test
    public void whenAddTwoDivTwoThenFour() {
        Calculator calc = new Calculator();
        calc.div(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }

    /**
     * Test method multiple.
     */
    @Test
    public void whenAddFourMultipleTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.multiple(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}