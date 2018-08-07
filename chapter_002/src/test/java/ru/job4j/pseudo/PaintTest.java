package ru.job4j.pseudo;

/**
 * Refactor PainTest.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 07.08.2018.
 */

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("+   +")
                                .append("+   +")
                                .append("++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );

    }

    @Test
    public void drawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("  ^  ")
                                .append(" ^ ^ ")
                                .append("^^^^^")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

}