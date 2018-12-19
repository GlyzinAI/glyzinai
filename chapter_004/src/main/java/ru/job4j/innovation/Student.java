package ru.job4j.innovation;

/**
 * Class Student.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 19.12.2018.
 */

public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
