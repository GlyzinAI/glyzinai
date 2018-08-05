package ru.job4j.tracker;

/**
 * Item - класс описания заявки.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 03.08.2018.
 */

public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
}
