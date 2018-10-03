package ru.job4j.collections.search;

/**
 * Class Task.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 03.10.2018.
 */

public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
