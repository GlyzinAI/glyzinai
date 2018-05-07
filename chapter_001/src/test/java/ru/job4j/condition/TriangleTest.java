package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * @author Artur Glyzin.
 * @since 01.05.2018.
 * @version 1.0.
 */

public class TriangleTest {
    @Test
    public void whenAreaTriangle() {
        Point a = new Point(0,0);
        Point b = new Point(0,2);
        Point c = new Point(2,0);

        Triangle triangle = new Triangle(a,b,c);
        double result = triangle.area();
        double expected = 2D;
        assertThat(result,closeTo(expected, 0.1));
    }
}