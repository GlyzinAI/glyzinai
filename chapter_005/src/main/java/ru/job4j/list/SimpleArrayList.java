package ru.job4j.list;

/**
 * SimpleArrayList - implementation single-linked list.
 *
 * @param <E> - param.
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 27.02.2019.
 */

public class SimpleArrayList<E> {

    /**
     * Class LoopLinkedList - class for keep data.
     *
     * @param <E> - param.
     */

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private int size; // keeps track of the number of elements
    private Node<E> head; // reference to the first node

    /**
     * Method add element in list.
     *
     * @param element - input element.
     */

    public void add(E element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node<E> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(element);
        }
        size++;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return.
     * @return the element at the specified position in this list.
     */

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list.
     */

    public int getSize() {
        return size;
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @return the element previously at the specified position.
     */

    public E delete() {
        Node<E> node = head;
        head = node.next;
        size--;
        return node.data;
    }
}
