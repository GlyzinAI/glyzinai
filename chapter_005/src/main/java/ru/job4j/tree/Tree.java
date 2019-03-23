package ru.job4j.tree;

import java.util.*;

/**
 * Элементарная структура дерева.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 23.03.2019.
 */

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * Ссылка на корневой элемент дерева.
     */
    private final Node<E> root;

    /**
     * Счетчик структурных изменений (fail-fast поведение итератора).
     */
    private int modCount;

    /**
     * Формирует начальное состояние дерева, устанавливает переданный элемент в качестве корневого.
     *
     * @param root - значение корневого элемента.
     */
    public Tree(E root) {
        this.root = new Node<>(root);
    }

    /**
     * Добавляет новый дочерний элемент к заданному элементу.
     *
     * @param parent - уже существующий элемент дерева.
     * @param child  добавляемый потомок.
     * @return true or false
     */
    @Override
    public boolean add(E parent, E child) {
        boolean flag = false;
        Node<E> parentNode = findBy(parent).orElse(null);
        Node<E> childNode = new Node<>(child);
        if (parentNode != null && !parentNode.leaves().contains(child)) {
            parentNode.add(childNode);
            modCount++;
            flag = true;
        }
        return flag;
    }

    /**
     * Поиск заданного элемента в дереве.
     *
     * @param value искомое значение
     * @return контейнер, который содержит искомый элемент (если присутствует)
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                result = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    /**
     * Возвращает итератор для последовательного прохода в ширину по элементам дерева.
     *
     * @return итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private Queue<Node<E>> queue = new LinkedList<>();

            {
                queue.offer(root);
            }

            @Override
            public boolean hasNext() {
                checkModification();
                return (!queue.isEmpty());
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> element = queue.remove();
                for (Node<E> child : element.leaves()) {
                    queue.offer(child);
                }
                return element.getValue();

            }

            private void checkModification() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
