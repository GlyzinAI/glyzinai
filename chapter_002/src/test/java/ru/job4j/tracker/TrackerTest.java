package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackerTest {
    @Test
    public void addTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void replaceTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        item2.setId(item1.getId());
        tracker.replace(item1.getId(), item2);
        assertThat(tracker.findById(item2.getId()).getName(), is("test2"));
    }

    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item1", "desc1", 13L);
        tracker.add(item1);
        Item item2 = new Item("item2", "desc2", 14L);
        Item item3 = new Item("item3", "desc3", 145L);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item1.getId());
        assertThat(tracker.getAll()[0], is(item2));
        assertThat(tracker.getAll()[1], is(item3));
    }

    @Test
    public void getAllTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("task#1", "desc1", 123L);
        Item item2 = new Item("task#2", "desc2", 1234L);
        Item item3 = new Item("task#3", "desc3", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] result = tracker.getAll();
        assertThat(result, is(new Item[]{item1, item2, item3}));
    }

    @Test
    public void findByNameTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("item", "desc1", 13L);
        Item item2 = new Item("item1", "desc2", 14L);
        tracker.add(item1);
        tracker.add(item2);
        Item[] result = tracker.findByName("item");
        assertThat(result, is(new Item[]{item1}));
    }

    @Test
    public void findByIDTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("task#1", "desc1", 123L);
        Item item2 = new Item("task#2", "desc2", 123L);
        Item item3 = new Item("task#3", "desc3", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item result = tracker.findById(item3.getId());
        assertThat(result, is(item3));
    }
}
