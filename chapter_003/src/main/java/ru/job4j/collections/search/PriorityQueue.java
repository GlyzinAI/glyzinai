package ru.job4j.collections.search;

import java.util.LinkedList;

/**
 * Class PriorityQueue - очередь с приоритетом на LinkedList.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 19.12.2018.
 */

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * method put
     *
     * @param task - task
     */

    public void put(Task task) {

        var index = 0;

        for (Task t : tasks) {
            if (t != null && t.getPriority() > task.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    /**
     * @return first element tasks(LinkedList)
     */

    public Task take() {
        return this.tasks.poll();
    }
}
