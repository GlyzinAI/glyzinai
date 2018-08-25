package ru.job4j.hero.ork;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Randomit;
import ru.job4j.hero.Weapon;

import java.util.Random;

public class ShamanOrk extends BaseHero {

    private Weapon[] weapons = {new Weapon("накладывает улучшение на", 0), new Weapon("наложение проклятия на", 0)};

    private Weapon weapon = new Randomit().selectWeapon(weapons);

    public ShamanOrk() {
        super("Орки| Шаман Орк","Орки");
        setHit(weapon.hit);
        setWeapon(weapon);
    }

    @Override
    public String nameWeapon() {
        return weapon.nameWeapon;
    }

    @Override
    public boolean actionToTeam() {
        return true;
    }
}
