package ru.job4j.innovation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class Filter - filter students.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 19.12.2018.
 */

public class Filter {

    /**
     * @param students - list of students.
     * @param bound    - score.
     * @return - list of students with a score above bound.
     */

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }
}
