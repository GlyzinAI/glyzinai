package ru.job4j.hero.people;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Randomit;
import ru.job4j.hero.Weapon;

public class MagPeople extends BaseHero {
    private Weapon[] weapons = {new Weapon("наложение улучшения", 0), new Weapon("атакует магией", 4)};

    private Weapon weapon = new Randomit().selectWeapon(weapons);

    public MagPeople() {
        super("Люди| Маг Человек","Люди");
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
