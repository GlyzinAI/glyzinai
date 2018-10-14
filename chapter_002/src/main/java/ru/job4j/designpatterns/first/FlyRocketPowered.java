package ru.job4j.designpatterns.first;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Я летаю реактивно!");
    }
}
