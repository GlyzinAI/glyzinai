package ru.job4j.tracker;

import java.util.Scanner;

/**
 * ConsoleInput - класс отвечает за ввод данных пользователем.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 05.08.2018.
 */

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
