package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * StartUITest - тест класс для проверки поведения пользователя.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 06.08.2018.
 */

public class StartUITest {
    @Test
    public void addItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
    public void editItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("task#1", "desc#1"));
        Input input = new StubInput(new String[]{"2", item.getId(), "newTask", "newDesc", "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("newTask"));
    }

    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("task#1", "desc#1"));
        Item item2 = tracker.add(new Item("task#2", "desc#2"));
        Input input = new StubInput(new String[]{"3", item2.getId(), "6", "y"});
        new StartUI(input, tracker).init();
        Item[] itemResult = {item1};
        assertThat(tracker.getAll(), is(itemResult));
    }
}
