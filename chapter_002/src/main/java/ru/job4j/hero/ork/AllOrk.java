package ru.job4j.hero.ork;

import ru.job4j.hero.BaseHero;

import java.util.ArrayList;

public class AllOrk {
    public ArrayList<BaseHero> ork() {
        ArrayList<BaseHero> ork = new ArrayList<>();
        ork.add(new ArcherOrk("Лучник Орк", 3, " стреляет из лука"));
        ork.add(new ArcherOrk("Лучник Орк", 3, " стреляет из лука"));
        ork.add(new ArcherOrk("Лучник Орк", 3, " стреляет из лука"));
        ork.add(new WarriorOrk("Гоблин Орк", 20, " атакует дубинкой"));
        ork.add(new WarriorOrk("Гоблин Орк", 20, " атакует дубинкой"));
        ork.add(new WarriorOrk("Гоблин Орк", 20, " атакует дубинкой"));
        ork.add(new WarriorOrk("Гоблин Орк", 20, " атакует дубинкой"));
        ork.add(new ShamanOrk("Шаман Орк", 20, " наносит урон магией"));

        return ork;
    }
}
