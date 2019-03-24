package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class Node.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 24.03.2019.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node<?> node = (Node<?>) o;
        return Objects.equals(children, node.children) && Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children, value);
    }
}
