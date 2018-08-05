package ru.job4j.tracker;

import java.util.*;

/**
 * Tracker - хранилище item(заявок).
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 03.08.2018.
 */

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[10];
    private static final Random RN = new Random();

    /**
     * Указатель ячейки для новой заявки.
     */
    int position = 0;

    /**
     * Метод реализующий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public void replace(String id, Item item) {
        item.setId(id); //установка id для передаваемой в метод заявки
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                break;
            }
        }
    }

    /**
     * Удаление заявки
     *
     * @param id - id заявки, которую необходимо удалить
     */
    public void delete(String id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, items.length - i - 1);
                position--;
                break;
            }
        }
    }

    /**
     * Получения списка всех заявок
     *
     * @return массив всех заявок
     */

    public Item[] getAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Получения списка по имени
     *
     * @param key - название(name) заявки
     * @return double item массив заявок
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[position];
        int k = 0;
        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                result[k++] = items[i];
            }
        }
        return Arrays.copyOf(result, 1);
    }

    /**
     * Получение заявки по переданному id.
     *
     * @param id - id заявки, которую необходимо вытащить из хранилища.
     * @return заявка, соответствующая переданному id.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}



