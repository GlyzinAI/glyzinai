package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

/**
 * ConsoleInput - класс отвечает за ввод данных пользователем.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 10.08.2018.
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
        return key;
    }
}
