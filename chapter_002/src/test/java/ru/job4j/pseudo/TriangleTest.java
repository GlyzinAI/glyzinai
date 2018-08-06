package ru.job4j.pseudo;

/**
 * TriangleTest.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 06.08.2018.
 */

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TriangleTest {
    @Test
    public void drawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("    +    ")
                                .append("  +   + ")
                                .append("+ + + + +")
                                .toString()
                )
        );
    }
}
