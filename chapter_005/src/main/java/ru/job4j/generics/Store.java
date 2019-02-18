package ru.job4j.generics;

/**
 * Interface Store.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 18.02.2019.
 */

public interface Store<T extends Base> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
