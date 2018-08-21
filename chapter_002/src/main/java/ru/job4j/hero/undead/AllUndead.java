package ru.job4j.hero.undead;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.people.MagPeople;

import java.util.ArrayList;

public class AllUndead {
    public ArrayList<BaseHero> undead() {
        ArrayList<BaseHero> undead = new ArrayList<>();
        undead.add(new Hunter(" Охотник Нечисти",2, " атакует"));
        undead.add(new Hunter(" Охотник Нечисти",2, " атакует"));
        undead.add(new Hunter(" Охотник Нечисти",2, " атакует"));
        undead.add(new Zombie(" Зомби Нечисть", 18, " атакует копьем"));
        undead.add(new Zombie(" Зомби Нечисть", 18, " атакует копьем"));
        undead.add(new Zombie(" Зомби Нечисть", 18, " атакует копьем"));
        undead.add(new Zombie(" Зомби Нечисть", 18, " атакует копьем"));
        undead.add(new Necromant(" Некромант нечисть", 5, " атакует"));

        return undead;
    }
}
