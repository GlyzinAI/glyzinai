package ru.job4j.list;

/**
 * Class LoopLinkedList - check loop node.
 *
 * @param <E> - param.
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 04.03.2019.
 */

public class LoopLinkedList<E> {

    protected static class Node<E> {
        protected E value;
        protected Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }

    /**
     * Returns loop node true or false.
     *
     * @param first - first element in the list.
     * @return true or false.
     */

    public boolean hasCycle(Node<E> first) {
        if (first == null) {
            return false;
        }

        Node<E> elementA = first;
        Node<E> elementB = first.next;
        while (true) {
            if (elementA == elementB) {
                return true;
            }

            if (elementA == null || elementB == null || elementB.next == null) {
                return false;
            }
            elementA = elementA.next;
            elementB = elementB.next.next;
        }
    }
}
