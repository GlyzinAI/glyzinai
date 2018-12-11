package ru.job4j.tracker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Tracker - хранилище item(заявок).
 *
 * @author Artur Glyzin.
 * @version 5.0.
 * @since 11.12.2018.
 */

public class Tracker {
    /**
     * Лист для хранения заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * для генерации уникального номера
     */

    private static final Random RN = new Random();

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
        int index = this.positionById(id);
        if (index != -1) {
            items.set(index, item);
        }
    }

    /**
     * Удаление заявки
     *
     * @param id - id заявки, которую необходимо удалить
     */
    public void delete(String id) {
        int index = this.positionById(id);
        if (index != -1) {
            items.remove(index);
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
        return this.items.stream()
                .filter(i -> i != null && i.getName().equals(key))
                .collect(Collectors.toList());
    }

    /**
     * Получение заявки по переданному id.
     *
     * @param id - id заявки, которую необходимо вытащить из хранилища.
     * @return заявка, соответствующая переданному id.
     */
    public Item findById(String id) {
        int index = this.positionById(id);
        return index != -1 ? this.items.get(index) : null;
    }

    private int positionById(String id) {
        return IntStream.range(0, this.items.size())
                .filter(i -> this.items.get(i).getId().equals(id))
                .findFirst().orElse(-1);
    }
}



