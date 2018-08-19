package ru.job4j.DesignPatterns.second;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.description + " $ " + beverage.cost());

        Beverage beverage1 = new Decaf();
        beverage1 = new Milk(beverage1);
        System.out.println(beverage1.getDescription() + " $ " + beverage1.cost());

        Beverage beverage2 = new Decaf();
        System.out.println(beverage2.description + " $ " + beverage2.cost());

        Beverage beverage3 = new Espresso();
        beverage3 = new Milk(beverage3);
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);

        System.out.println(beverage3.getDescription() + " $ " + beverage3.cost());
    }
}
