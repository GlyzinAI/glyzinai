package ru.job4j.innovation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class StudentTest.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 19.12.2018.
 */

public class StudentTest {
    @Test
    public void whenCheckResultStudent() {
        Student student1 = new Student("Artur", 9);
        Student student2 = new Student("Darya", 12);
        Student student3 = new Student("Petr", 4);
        Student student4 = new Student("Max", 7);
        Student student5 = new Student("Anton", 2);
        Student student6 = new Student("Alena", 10);

        List<Student> allStudents = Arrays.asList(student1, student2, student3, student4, student5, student6);

        Filter filter = new Filter();
        List<Student> result = filter.levelOf(allStudents, 6);
        assertThat(result, is(Arrays.asList(student2, student6, student1, student4)));
    }
}
