package ru.job4j.DesignPatterns.second;

public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.description + ", Soy";
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }
}
