package ru.job4j.hero.people;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Weapon;

public class WarriorPeople extends BaseHero {

    private Weapon weapon = new Weapon("атакует мечом", 18);

    public WarriorPeople() {
        super("Люди| Воин Человек","Люди");
        setHit(weapon.hit);
        setWeapon(weapon);
    }

    @Override
    public String nameWeapon() {
        return weapon.nameWeapon;
    }
}
