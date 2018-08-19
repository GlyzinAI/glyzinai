package ru.job4j.DesignPatterns.first;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public Duck() {

    }

    public abstract void display();

    public void perfomQuack() {
        quackBehavior.quack();
    }

    public void perfomFly() {
        flyBehavior.fly();
    }

    public void swim() {
        System.out.println("Все утки плавают, даже приманки!");
    }


}
