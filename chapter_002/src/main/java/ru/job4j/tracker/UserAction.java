package ru.job4j.tracker;

/**
 * Interface UserAction - определяет основное поведения для меню.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 08.08.2018.
 */

public interface UserAction {

    /**
     * Метод возвращает ключ опции.
     *
     * @return ключ
     */

    int key();

    /**
     * Основной метод. Выполнение основных действий.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */

    void execute(Input input, Tracker tracker);

    /**
     * Метод возвращает информацию о данном пункте меню.
     *
     * @return Строка меню
     */

    String info();


}
