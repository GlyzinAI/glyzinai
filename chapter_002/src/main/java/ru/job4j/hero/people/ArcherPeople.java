package ru.job4j.hero.people;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Randomit;
import ru.job4j.hero.Weapon;

public class ArcherPeople extends BaseHero {
    public Weapon[] weapons = {new Weapon("стреляет из арбалета", 5), new Weapon("атакует", 3)};

    public Weapon weapon = new Randomit().selectWeapon(weapons);

    public ArcherPeople() {
        super("Люди| Лучник Человек","Люди");
        setHit(weapon.hit);
        setWeapon(weapon);
    }

    @Override
    public String nameWeapon() {
        return weapon.nameWeapon;
    }

}
