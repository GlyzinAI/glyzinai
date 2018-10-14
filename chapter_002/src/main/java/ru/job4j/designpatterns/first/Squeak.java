package ru.job4j.designpatterns.first;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Пи-пи");
    }
}
