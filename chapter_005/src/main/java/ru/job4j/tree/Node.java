package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Node.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 23.03.2019.
 */

public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }
}
