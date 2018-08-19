package ru.job4j.DesignPatterns.first;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Я летаю!!");
    }
}
