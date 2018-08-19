package ru.job4j.DesignPatterns.first;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Кряк!!!");
    }
}
