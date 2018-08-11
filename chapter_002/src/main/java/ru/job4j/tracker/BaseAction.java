package ru.job4j.tracker;

/**
 * BaseAction.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 11.08.2018.
 */

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    protected BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
