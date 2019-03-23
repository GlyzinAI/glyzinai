package ru.job4j.tree;

import java.util.Optional;

/**
 * Interface SimpleTree.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 23.03.2019.
 */

public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}
