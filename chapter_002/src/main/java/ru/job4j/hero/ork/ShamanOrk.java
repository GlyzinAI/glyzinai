package ru.job4j.hero.ork;

import ru.job4j.hero.*;

import java.util.Random;

/**
 * Class ShamanOrk.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class ShamanOrk extends BaseHero {

    private Weapon[] weapons = {new Weapon("накладывает улучшение на"), new Weapon("накладывает проклятие")};

    public ShamanOrk() {
        super("Орки| Шаман Орк", "Орки");
        setWeapons(weapons);
    }

    @Override
    public String nameWeapon() {
        return getWeapon().getNameWeapon();
    }

    @Override
    public boolean actionToTeam() {
        if (getWeapon() == weapons[0]) return true;
        else return false;
    }

    @Override
    public void attack(Hero evil) {
        super.attack(evil);
        new Banda().clList();
    }

    public void editWeapon() {
        setWeapon(weapons[1]);
        setHit(getWeapon().getHit());
    }
}
