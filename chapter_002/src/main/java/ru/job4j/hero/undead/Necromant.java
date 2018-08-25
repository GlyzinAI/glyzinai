package ru.job4j.hero.undead;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Randomit;
import ru.job4j.hero.Weapon;

public class Necromant extends BaseHero {

    private final Weapon[] weapons = {new Weapon("насылает недуг на", 0), new Weapon("атакует магией", 5)};

    private Weapon weapon = new Randomit().selectWeapon(weapons);

    public Necromant() {
        super("Нечисть| Некромант Нечисти","Нечисть");
        setHit(weapon.hit);
        setWeapon(weapon);
    }

    @Override
    public String nameWeapon() {
        return weapon.nameWeapon;
    }

    @Override
    public boolean actionToTeam() {
        if (weapon.hit == 0) return true;
        else return false;
    }
}
