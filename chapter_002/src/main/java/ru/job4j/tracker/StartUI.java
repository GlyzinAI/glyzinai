package ru.job4j.tracker;

/**
 * StartUI.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 05.08.2018.
 */

public class StartUI {
    private static final String ADD = "0"; //добавление заявки
    private static final String SHOWALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";

    private final Input input;

    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Общий цикл программы.
     */

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = input.ask("Введите пункт меню: ");
            if (ADD.equals(answer)) {
                this.creatItem();
            } else if (SHOWALL.equals(answer)) {
                this.showALL();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findByIdItem();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByNameItem();
            } else if (EXIT.equals(answer)) {
                if (exit())
                    exit = true;
            }
        }
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */

    private void creatItem() {
        System.out.println("--------- Добавление новой заявки ---------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("--------- Новая заявка с getId : " + item.getId() + "---------");
    }

    /**
     * Метод выводит в консоль таблицу всех заявок в хранилище.
     */

    private void showALL() {
        System.out.println("--------- Список всех заявок ---------");
        System.out.format("%16s%16s%16s", "Имя заявки", "Описание", "ID заявки");
        System.out.println();
        for (Item item : tracker.getAll()) {
            System.out.format("%16s%16s%16s", item.getName(), item.getDesc(), item.getId());
            System.out.println();
        }
    }

    /**
     * Метод редактирует заявку.
     */

    private void editItem() {
        System.out.println("--------- Редактирование заявки ---------");
        String id = this.input.ask("Введите id заявки: ");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item itemNew = new Item(name, desc);
        this.tracker.replace(id, itemNew);
        System.out.println("--------- Заявка отредактирована ---------");
    }

    /**
     * Метод удаляет заявку.
     */

    private void deleteItem() {
        System.out.println("--------- Удаление заявки ---------");
        String id = this.input.ask("Введите id удаляемой заявки: ");
        tracker.delete(id);
        System.out.println("--------- Заявка удалена ---------");
    }

    /**
     * Метод для поиска заявки по ID.
     */

    private void findByIdItem() {
        System.out.println("--------- Поиск заявки по её ID ---------");
        String id = this.input.ask("Введите id заявки: ");
        Item res = tracker.findById(id);
        System.out.println("--------- Заявка найдена ---------");
        System.out.format("%16s%16s%16s", "Имя заявки", "Описание", "ID заявки");
        System.out.println();
        System.out.format("%16s%16s%16s", res.getName(), res.getDesc(), res.getId());
        System.out.println();
    }

    /**
     * Метод для поиска заявки по имени.
     */

    private void findByNameItem() {
        System.out.println("--------- Поиск заявки по имени ---------");
        String name = this.input.ask("Введите имя заявки: ");
        Item[] res = tracker.findByName(name);
        System.out.println("--------- Заявка найдена ---------");
        System.out.format("%16s%16s%16s", "Имя заявки", "Описание", "ID заявки");
        System.out.println();
        for (Item item : res) {
            System.out.format("%16s%16s%16s", item.getName(), item.getDesc(), item.getId());
            System.out.println();
        }
    }

    /**
     * Метод реализующие выход из программы.
     *
     * @return true - выйти, false - продолжить работу
     */

    private boolean exit() {
        boolean res = false;
        String ans = this.input.ask("***** Вы точно хотите выйти из программы? y/n *****");
        if (ans.equals("y"))
            res = true;
        return res;
    }

    /**
     * Вывод в консоль пунктов меню.
     */

    private void showMenu() {
        System.out.println("Меню");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Запускт программы.
     *
     * @param args
     */

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }


}
