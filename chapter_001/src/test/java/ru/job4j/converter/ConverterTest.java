package ru.job4j.converter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * class ConverterTest - класс для тестировния всех методов класса Converter.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 13.10.2018.
 */

public class ConverterTest {

    @Test
    public void when140RubleToEuroThen2() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(140);
        assertThat(result, is(2));
    }

    @Test
    public void when180RubleToDollarThen3() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(180);
        assertThat(result, is(3));
    }

    @Test
    public void when1EuroToRubleThen70() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(1);
        assertThat(result, is(70));
    }

    @Test
    public void when2DollarToRubleThen120() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(2);
        assertThat(result, is(120));
    }
}