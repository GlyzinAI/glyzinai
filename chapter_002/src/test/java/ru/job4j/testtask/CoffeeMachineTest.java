package ru.job4j.testtask;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * CoffeeMachineTest - тест класс для проверки поведения кофемашины.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 26.08.2018.
 */

public class CoffeeMachineTest {
    @Test
    public void whenWantCoffee() {
        CoffeeMachine coffeMachine = new CoffeeMachine();
        int[] res = coffeMachine.changes(67, 25);
        int[] expect = {10, 10, 10, 10, 2};
        assertThat(res, is(expect));
    }

    @Test
    public void whenWantCoffee2() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] res = coffeeMachine.changes(50, 35);
        int[] expect = {10, 5};
        assertThat(res, is(expect));
    }

    @Test
    public void whenWantCoffee3() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] res = coffeeMachine.changes(60, 32);
        int[] expect = {10, 10, 5, 2, 1};
        assertThat(res, is(expect));
    }
}
