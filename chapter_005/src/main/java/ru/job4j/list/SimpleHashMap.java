package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * SimpleHashMap - implementation HashMap.
 *
 * @param <K> - key.
 * @param <V> - value.
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 20.03.2019.
 */

public class SimpleHashMap<K, V> {
    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key) && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {

            return Objects.hash(key, value);
        }
    }

    /**
     * The default initial capacity - MUST be a power of two.
     */

    private static final int DEFAULT_CAPACITY = 16;

    /**
     * The load factor used when none specified in constructor.
     */

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * The table, initialized on first use, and resized as
     * necessary. When allocated, length is always a power of two.
     * (We also tolerate length zero in some operations to allow
     * bootstrapping mechanics that are currently not needed.)
     */

    private Node<K, V>[] table;

    /**
     * The number of key-value mappings contained in this map.
     */

    private int size;

    /**
     * The next size value at which to resize (capacity * load factor).
     *
     * @serial
     */

    private int threshold;

    /**
     * The number of times this HashMap has been structurally modified
     * Structural modifications are those that change the number of mappings in
     * the HashMap or otherwise modify its internal structure (e.g.,
     * rehash).  This field is used to make iterators on Collection-views of
     * the HashMap fail-fast.  (See ConcurrentModificationException).
     */

    private int modCount; // change counter

    public SimpleHashMap() {
        this.table = new Node[DEFAULT_CAPACITY];
        threshold = (int) (table.length * DEFAULT_LOAD_FACTOR);
    }

    /**
     * Computes key.hashCode() and spreads (XORs) higher bits of hash to lower.
     *
     * @param key - key from this map.
     * @return
     */

    private int hash(K key) {
        int h = key.hashCode();
        return key == null ? 0 : (h ^ h >>> 16);
    }

    /**
     * Return bucket's index.
     *
     * @param hash - result method hash().
     * @return - bucket's index.
     */

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key - return false.
     *
     * @param key   - key from this map.
     * @param value - value to be associated with the specified key.
     * @return true or false.
     */

    public boolean insert(K key, V value) {
        int hash = hash(key);
        int index = indexFor(hash);
        if (size >= threshold) {
            table = resize();
            index = hash & (table.length - 1);
        } else if (table[index] != null) {
            return false;
        }
        table[index] = new Node<>(hash, key, value, null);
        size++;
        modCount++;
        return true;
    }

    /**
     * Initializes or doubles table size.  If null, allocates in
     * accord with initial capacity target held in field threshold.
     * Otherwise, because we are using power-of-two expansion, the
     * elements from each bin must either stay at same index, or move
     * with a power of two offset in the new table.
     *
     * @return the new table
     */

    private Node<K, V>[] resize() {
        Node<K, V>[] oldTab = table;
        Node<K, V>[] newTable = new Node[DEFAULT_CAPACITY * 2];
        for (Node<K, V> old : oldTab) {
            if (old == null) {
                continue;
            }
            int index = old.hash & (newTable.length - 1);
            if (newTable[index] == null && old.key != null) {
                newTable[index] = old;
            }
        }
        return newTable;
    }

    /**
     * Returns the value to which the specified key is mapped.
     *
     * @param key - key from this map.
     * @return - value to which the specified key is mapped.
     */

    public V get(K key) {
        int hash = hash(key);
        int index = indexFor(hash);
        return table[index].getValue();
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key - key from this map.
     * @return true or false.
     */

    public boolean delete(K key) {
        size--;
        modCount++;
        boolean flag = true;
        int hash = hash(key);
        int index = indexFor(hash);
        if (table[index] == null) {
            flag = false;
        } else {
            table[index] = null;
        }
        return flag;
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */

    public int size() {
        return this.size;
    }

    public Iterator<V> iterator() {
        return new Iterator<>() {
            private int cursor = -1;
            private int expectedModCount = modCount;
            private int count;

            @Override
            public boolean hasNext() {
                checkForModification();
                return count < size;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                do {
                    cursor++;
                } while (hasNext() & table[cursor] == null);
                count++;
                return table[cursor].value;
            }

            private void checkForModification() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
