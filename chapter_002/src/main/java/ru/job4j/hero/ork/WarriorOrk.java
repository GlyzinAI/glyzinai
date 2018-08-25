package ru.job4j.hero.ork;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Weapon;

public class WarriorOrk extends BaseHero {

    private Weapon weapon = new Weapon("атакует дубинкой", 20);

    public WarriorOrk() {
        super("Орки| Гоблин Орк","Орки");
        setHit(weapon.hit);
        setWeapon(weapon);
    }

    @Override
    public String nameWeapon() {
        return weapon.nameWeapon;
    }

}
