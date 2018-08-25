package ru.job4j.hero;

import java.util.ArrayList;

public interface Team {

    boolean aliveTeam();
    BaseHero turn(ArrayList<BaseHero> priv);

    void alive();

    void survivor();

    int lenghtList();



}
