package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    StringBuilder menu = new StringBuilder()
            .append("Меню")
            .append(System.lineSeparator())
            .append("0. Add new Item")
            .append(System.lineSeparator())
            .append("1. Show all items")
            .append(System.lineSeparator())
            .append("2. Edit item")
            .append(System.lineSeparator())
            .append("3. Delete item")
            .append(System.lineSeparator())
            .append("4. Find item by Id")
            .append(System.lineSeparator())
            .append("5. Find items by name")
            .append(System.lineSeparator())
            .append("6. Exit Program")
            .append(System.lineSeparator());


    @Before
    public void loadOutput() {


        System.setOut(new PrintStream(this.out));

    }

    @After
    public void backOutput() {

        System.setOut(this.stdout);

    }

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

    @Test
    public void showAllItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("task#1", "desc#1");
        Item item2 = new Item("task#2", "desc#2");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"1", "6", "y"});
        new StartUI(input, tracker).init();

        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append(menu)
                        .append("--------- Список всех заявок ---------")
                        .append(System.lineSeparator())
                        .append(String.format("%16s%16s%16s", "Имя заявки", "Описание", "ID заявки"))
                        .append(System.lineSeparator())
                        .append(String.format("%16s%16s%16s", item1.getName(), item1.getDesc(), item1.getId()))
                        .append(System.lineSeparator())
                        .append(String.format("%16s%16s%16s", item2.getName(), item2.getDesc(), item2.getId()))
                        .append(System.lineSeparator())
                        .append(menu)

        ));
    }
}
