package ru.job4j.tracker;

import java.util.*;

/**
 * Tracker - хранилище item(заявок).
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 16.10.2018.
 */

public class Tracker {
    /**
     * Лист для хранения заявок.
     */
    private final List<Item> items = new ArrayList<>();
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
        this.items.add(item);
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
        for (Item it : items) {
            if (it.getId().equals(id)) {
                items.set(items.indexOf(it), item);
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
        for (Item it : items) {
            if (it != null && it.getId().equals(id)) {
                items.remove(it);
                break;
            }
        }
    }

    /**
     * Получения списка всех заявок
     *
     * @return лист всех заявок
     */

    public List<Item> getAll() {
        return items;
    }

    /**
     * Получения списка по имени
     *
     * @param key - название(name) заявки
     * @return list result - лист заявок
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item it : items) {
            if (it != null && it.getName().equals(key)) {
                result.add(it);
            }
        }
        return result;
    }

    /**
     * Получение заявки по переданному id.
     *
     * @param id - id заявки, которую необходимо вытащить из хранилища.
     * @return заявка, соответствующая переданному id.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item it : items) {
            if (it != null && it.getId().equals(id)) {
                result = it;
                break;
            }
        }
        return result;
    }
}



