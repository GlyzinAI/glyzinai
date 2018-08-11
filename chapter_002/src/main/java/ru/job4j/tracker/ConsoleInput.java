package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

/**
 * ConsoleInput - класс отвечает за ввод данных пользователем.
 *
 * @author Artur Glyzin.
 * @version 3.0.
 * @since 11.08.2018.
 */

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("out of menu range.");
        }
        return key;
    }
}
