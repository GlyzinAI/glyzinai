package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * MenuTracker.
 *
 * @author Artur Glyzin.
 * @version 6.0.
 * @since 09.12.2018.
 */

public class MenuTracker {
    /**
     * @param input хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param tracker хранит ссылку на объект .
     */
    private Tracker tracker;

    /**
     * @param actions хранит ссылку на массив типа UserAction.
     */

    private List<UserAction> actions = new ArrayList<>();

    /**
     * @param consumer - for show menu.
     */


    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения длинны массива меню.
     *
     * @return длину массива
     */

    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddAction(0, "Add new Item"));
        this.actions.add(new ShowAllItem(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemByName(5, "Find items by name"));
        this.actions.add(new Exit(6, "Exit Program", ui));
    }


    public void allActions(List<Integer> range) {
        for (UserAction action : actions) {
            range.add(action.key());
        }
    }

    public static class AddAction extends BaseAction implements UserAction {
        /**
         * Поля для инициализации.
         */

        private int key;

        private String desc;

        public AddAction(int key, String desc) {
            super(key, desc);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("--------- Добавление новой заявки ---------");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("--------- Новая заявка с именем : " + item.getName() + " ---------");
            System.out.println("--------- Новая заявка с описанием : " + item.getDesc() + " ---------");
            System.out.println("--------- Новая заявка с getId : " + item.getId() + " ---------");
        }

    }


    public static class ShowAllItem extends BaseAction implements UserAction {

        private int key;

        private String desc;

        public ShowAllItem(int key, String desc) {
            super(key, desc);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("--------- Список всех заявок ---------");
            System.out.format("%16s%16s%16s", "Имя заявки", "Описание", "ID заявки");
            System.out.println();
            for (Item item : tracker.getAll()) {
                System.out.format("%16s%16s%16s", item.getName(), item.getDesc(), item.getId());
                System.out.println();
            }
        }

    }

    public static class EditItem extends BaseAction implements UserAction {

        private int key;

        private String desc;

        public EditItem(int key, String desc) {
            super(key, desc);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("--------- Редактирование заявки ---------");
            String id = input.ask("Введите id заявки: ");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            Item itemNew = new Item(name, desc);
            tracker.replace(id, itemNew);
            System.out.println("--------- Заявка отредактирована ---------");
        }

    }

    public static class DeleteItem extends BaseAction implements UserAction {

        private int key;

        private String desc;

        public DeleteItem(int key, String desc) {
            super(key, desc);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("--------- Удаление заявки ---------");
            String id = input.ask("Введите id удаляемой заявки: ");
            tracker.delete(id);
            System.out.println("--------- Заявка удалена ---------");
        }

    }

    public static class FindItemById extends BaseAction implements UserAction {

        private int key;

        private String desc;

        public FindItemById(int key, String desc) {
            super(key, desc);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("--------- Поиск заявки по её ID ---------");
            String id = input.ask("Введите id заявки: ");
            Item res = tracker.findById(id);
            if (res == null) {
                System.out.println("-------- Заявка не найдена --------");
            } else {
                System.out.println("--------- Заявка найдена ---------");
                System.out.format("%16s%16s%16s", "Имя заявки", "Описание", "ID заявки");
                System.out.println();
                System.out.format("%16s%16s%16s", res.getName(), res.getDesc(), res.getId());
                System.out.println();
            }
        }
    }

    public static class FindItemByName extends BaseAction implements UserAction {
        private int key;

        private String desc;

        public FindItemByName(int key, String desc) {
            super(key, desc);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("--------- Поиск заявки по имени ---------");
            String name = input.ask("Введите имя заявки: ");
            List<Item> res = tracker.findByName(name);
            if (res.size() == 0) {
                System.out.println("-------- Заявка не найдена --------");
            } else {
                System.out.println("--------- Заявка найдена ---------");
                System.out.format("%16s%16s%16s", "Имя заявки", "Описание", "ID заявки");
                System.out.println();
                for (Item item : res) {
                    System.out.format("%16s%16s%16s", item.getName(), item.getDesc(), item.getId());
                    System.out.println();
                }
            }
        }
    }

    public static class Exit extends BaseAction implements UserAction {
        private final StartUI ui;

        private int key;

        private String desc;

        public Exit(int key, String name, StartUI ui) {
            super(key, name);
            this.ui = ui;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            this.ui.stop();
        }

    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */

    public void select(int key) {

        for (UserAction action : actions) {
            if (action.key() == key) {
                action.execute(this.input, this.tracker);
            }
        }
    }

    /**
     * method show - show menu, use Consumer<String>
     * <p>
     * Метод выводит на экран меню.
     */

    public void show(Consumer<String> consumer) {
        for (UserAction action : this.actions) {
            if (action != null) {
                consumer.accept(action.info());
            }
        }
    }
}





