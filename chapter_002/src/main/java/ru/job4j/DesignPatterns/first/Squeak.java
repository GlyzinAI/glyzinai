package ru.job4j.DesignPatterns.first;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Пи-пи");
    }
}
