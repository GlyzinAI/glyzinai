package ru.job4j.pseudo;

/**
 * SquareTest.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 06.08.2018.
 */


import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SquareTest {
    @Test
    public void drawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("+   +")
                                .append("+   +")
                                .append("++++")
                                .toString()
                )
        );
    }
}
