package ru.job4j.DesignPatterns.first;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Я не могу летать!");
    }
}
