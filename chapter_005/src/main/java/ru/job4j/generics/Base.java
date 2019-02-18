package ru.job4j.generics;

/**
 * Class Base.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 18.02.2019.
 */

public abstract class Base {

    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
