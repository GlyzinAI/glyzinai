package ru.job4j.collections.search;

import java.util.LinkedList;

/**
 * Class PriorityQueue - очередь с приоритетом на LinkedList.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 03.10.2018.
 */

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {

        int index = 0;

        for (Task t : tasks) {
            if (t != null && t.getPriority() > task.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
