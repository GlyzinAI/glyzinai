package ru.job4j.designpatterns.second;

public abstract class Beverage {

    String description = "Unknown";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}

