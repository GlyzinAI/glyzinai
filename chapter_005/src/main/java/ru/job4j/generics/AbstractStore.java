package ru.job4j.generics;

import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * Class AbstractStore.
 *
 * @param <T> extends class {@link Base}.
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 18.02.2019.
 */

public abstract class AbstractStore<T extends Base> implements Store<T> {

    /**
     * Default storage size.
     */

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Object store.
     */

    private final SimpleArray<T> store;

    /**
     * Constructor sets the default size.
     */

    public AbstractStore() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor sets size.
     *
     * @param capacity - size store.
     */

    public AbstractStore(int capacity) {
        this.store = new SimpleArray<>(capacity);
    }

    /**
     * Add element in store.
     *
     * @param model - element.
     */

    @Override
    public void add(T model) {
        this.store.add(model);
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param id    - id of the element to replace
     * @param model - element to be stored at the specified position
     * @return - if successfully -> true
     */

    @Override
    public boolean replace(String id, T model) {
        boolean res = false;
        int index = findIndexById(id);
        if (index != -1) {
            store.set(index, model);
            res = true;
        }
        return res;
    }

    /**
     * Delete the element at the specified position.
     *
     * @param id - id of the element to delete
     * @return if successfully -> true
     */

    @Override
    public boolean delete(String id) {
        boolean res = false;
        Iterator<T> iterator = this.store.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
                res = true;
            }
        }
        return res;
    }

    /**
     * Return an element with the specified id.
     *
     * @param id - id of the element.
     * @return element.
     */

    @Override
    public T findById(String id) {
        int index = findIndexById(id);
        return index != -1 ? store.get(index) : null;
    }

    /**
     * Method for search element's index.
     *
     * @param id - id of the element.
     * @return element's index.
     */

    private int findIndexById(String id) {
        return IntStream.range(0, this.store.size())
                .filter(i -> this.store.get(i).getId().equals(id))
                .findFirst().orElse(-1);
    }
}

