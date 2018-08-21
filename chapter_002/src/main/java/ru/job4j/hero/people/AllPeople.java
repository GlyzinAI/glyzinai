package ru.job4j.hero.people;

import ru.job4j.hero.BaseHero;

import java.util.ArrayList;

public class AllPeople {
    public ArrayList<BaseHero> people() {
        ArrayList<BaseHero> people = new ArrayList<>();
        people.add(new ArcherPeople(" Лучник Человек", 3, " атакует"));
        people.add(new ArcherPeople(" Лучник Человек", 3, " атакует"));
        people.add(new ArcherPeople(" Лучник Человек", 3, " атакует"));
        people.add(new WarriorPeople(" Воин Человек", 18, " атакует мечом"));
        people.add(new WarriorPeople(" Воин Человек", 18, " атакует мечом"));
        people.add(new WarriorPeople(" Воин Человек", 18, " атакует мечом"));
        people.add(new WarriorPeople(" Воин Человек", 18, " атакует мечом"));
        people.add(new MagPeople(" Маг Человек", 4, " атакует магией"));

        return people;
    }
}
