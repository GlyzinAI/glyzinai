package ru.job4j.loop;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 27.07.2018.
 */

public class RefactoringPaintTest {
    @Test
    public void whenTestPaintHeight2() {
        Paint paint = new Paint();
        String res = paint.pyramid(2);
        assertThat(res, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add(" ^ ")
                        .add("^^^")
                        .toString()
                )
        );
    }

    @Test
    public void whenTestPainHeight3() {
        Paint paint = new Paint();
        String res = paint.pyramid(3);
        assertThat(res, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("  ^  ")
                        .add(" ^^^ ")
                        .add("^^^^^")
                        .toString()
                )
        );
    }
}
