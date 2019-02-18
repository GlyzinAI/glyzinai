package ru.job4j.generics;

/**
 * Class UserStore.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 18.02.2019.
 */

public class UserStore extends AbstractStore<User> {

    public UserStore() {
        super();
    }

    public UserStore(int capacity) {
        super(capacity);
    }
}
