package ru.job4j.hero.ork;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Randomit;
import ru.job4j.hero.Weapon;

public class ArcherOrk extends BaseHero {

    private final Weapon[] weapons = {new Weapon("стреляет из лука", 3), new Weapon("бьёт клинком", 2)};

    private Weapon weapon = new Randomit().selectWeapon(weapons);

    public ArcherOrk() {
        super("Орки| Лучник Орк","Орки");
        setHit(weapon.hit);
        setWeapon(weapon);

    }

    @Override
    public String nameWeapon() {
        return weapon.nameWeapon;
    }
}
