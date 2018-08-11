package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * ValidateInputTest.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 11.08.2018.
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream m = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.m));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1"})
        );
        input.ask("Enter", new ArrayList<>());
        assertThat(
                this.m.toString(),
                is(
                        String.format("Пожалуйста, введите корректное значение!%n")
                )
        );
    }
}