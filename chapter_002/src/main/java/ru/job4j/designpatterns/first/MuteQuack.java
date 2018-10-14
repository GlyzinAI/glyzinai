package ru.job4j.designpatterns.first;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("<< Тишина >>");
    }
}
