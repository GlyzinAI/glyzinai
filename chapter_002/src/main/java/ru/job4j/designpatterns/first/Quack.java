package ru.job4j.designpatterns.first;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Кряк!!!");
    }
}
