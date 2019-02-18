package ru.job4j.generics;

/**
 * Class RoleStore.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 16.02.2019.
 */

public class RoleStore extends AbstractStore<Role> {

    public RoleStore() {
        super();
    }

    public RoleStore(int capacity) {
        super(capacity);
    }
}
