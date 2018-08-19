package ru.job4j.DesignPatterns.first;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("<< Тишина >>");
    }
}
