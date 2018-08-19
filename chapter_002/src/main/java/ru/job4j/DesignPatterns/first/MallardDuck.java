package ru.job4j.DesignPatterns.first;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }


    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
