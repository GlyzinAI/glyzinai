package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * StartUI.
 *
 * @author Artur Glyzin.
 * @version 4.0.
 * @since 12.08.2018.
 */

public class StartUI {

    private boolean working = true;

    private final Input input;

    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Общий цикл программы.
     */

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        menu.allActions(range);
        do {
            menu.show();
            menu.select(input.ask("select:", range));
        } while (this.working);
    }

    public void stop() {
        this.working = false;
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

}
