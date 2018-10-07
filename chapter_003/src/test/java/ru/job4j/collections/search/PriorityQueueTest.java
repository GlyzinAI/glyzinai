package ru.job4j.collections.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PriorityQueueTest.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 07.10.2018.
 */

public class PriorityQueueTest {
    @Test
    public void whenPutTask() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("MakeBreakfast", 3));
        queue.put(new Task("GetUp", 1));
        queue.put(new Task("WalkingTheDog", 2));
        queue.put(new Task("GoToWork", 4));
        Task result = queue.take();
        assertThat(result.getDesc(), is("GetUp"));
    }

    @Test
    public void whenPutTask2() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("MakeBreakfast", 3));
        queue.put(new Task("GetUp_1", 1));
        queue.put(new Task("GetUp", 4));
        queue.put(new Task("GetUp_2", 1));
        queue.put(new Task("GetUp_3", 1));
        queue.put(new Task("WalkingTheDog", 2));
        queue.put(new Task("GoToWork", 4));
        Task result = queue.take();
        assertThat(result.getDesc(), is("GetUp_1"));
    }
}
