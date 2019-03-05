package ru.job4j.list;

import java.util.Iterator;

/**
 * Class SimpleSet - implementation Set.
 *
 * @param <E> - param.
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 05.03.2019.
 */

public class SimpleSet<E> implements Iterable<E> {

    private MyArrayList<E> list = new MyArrayList<>();

    public void add(E element) {
        if (!isDuplicate(element)) {
            list.add(element);
        }
    }

    private boolean isDuplicate(E element) {
        boolean flag = false;
        if (list.getSize() != 0) {
            for (E value : list) {
                if (value.equals(element)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public int size() {
        return list.getSize();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
