package ru.job4j.hero;

public interface Hero {

    void attack(Hero evil);

    void upgrade(Hero partner);

    void reduse(int value);

    boolean alive();

    boolean actionToTeam();

    void skills(boolean up);

}
