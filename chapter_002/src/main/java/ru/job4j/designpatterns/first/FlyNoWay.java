package ru.job4j.designpatterns.first;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Я не могу летать!");
    }
}
