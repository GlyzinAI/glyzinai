package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * StartUITest - тест класс для проверки поведения пользователя.
 *
 * @author Artur Glyzin.
 * @version 4.0.
 * @since 16.10.2018.
 */

public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    String ls = System.lineSeparator();
    StringBuilder menu = new StringBuilder()
            .append("0. Add new Item").append(ls)
            .append("1. Show all items").append(ls)
            .append("2. Edit item").append(ls)
            .append("3. Delete item").append(ls)
            .append("4. Find item by Id").append(ls)
            .append("5. Find items by name").append(ls)
            .append("6. Exit Program").append(ls);

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
        Input input = new StubInput(Arrays.asList("0", "test name", "desc", "6"));

        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("test name"));
    }

    @Test
    public void editItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("task#1", "desc#1"));
        Input input = new StubInput(Arrays.asList("2", item.getId(), "newTask", "newDesc", "6"));
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("newTask"));
    }

    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("task#1", "desc#1"));
        Item item2 = tracker.add(new Item("task#2", "desc#2"));
        Input input = new StubInput(Arrays.asList("3", item2.getId(), "6"));
        new StartUI(input, tracker).init();
        List<Item> itemResult = new ArrayList<>();
        itemResult.add(item1);
        assertThat(tracker.getAll(), is(itemResult));
    }

    @Test
    public void showAllItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("task#1", "desc#1");
        Item item2 = new Item("task#2", "desc#2");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(Arrays.asList("1", "6"));
        new StartUI(input, tracker).init();

        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append(menu)
                        .append("--------- Список всех заявок ---------").append(ls)
                        .append(String.format("%16s%16s%16s", "Имя заявки", "Описание", "ID заявки")).append(ls)
                        .append(String.format("%16s%16s%16s", item1.getName(), item1.getDesc(), item1.getId())).append(ls)
                        .append(String.format("%16s%16s%16s", item2.getName(), item2.getDesc(), item2.getId())).append(ls)
                        .append(menu).toString()

        ));
    }

    @Test
    public void findID() {
        Tracker tracker = new Tracker();
        Item item = new Item("task#1", "desc#1");
        tracker.add(item);
        Input input = new StubInput(Arrays.asList("4", item.getId(), "6"));
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("--------- Поиск заявки по её ID ---------").append(ls)
                                .append("--------- Заявка найдена ---------").append(ls)
                                .append(String.format("%16s%16s%16s", "Имя заявки", "Описание", "ID заявки")).append(ls)
                                .append(String.format("%16s%16s%16s", item.getName(), item.getDesc(), item.getId())).append(ls)
                                .append(menu).toString()
                ));
    }

}
