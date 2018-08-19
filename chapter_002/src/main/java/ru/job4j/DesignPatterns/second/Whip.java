package ru.job4j.DesignPatterns.second;

public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.description + ", Whip";
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }
}
