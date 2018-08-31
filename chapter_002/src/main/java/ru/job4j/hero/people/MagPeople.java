package ru.job4j.hero.people;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Randomit;
import ru.job4j.hero.Weapon;

/**
 * Class MagPeople.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */


public class MagPeople extends BaseHero {
    private Weapon[] weapons = {new Weapon("накладывает улучшение"), new Weapon("атакует магией", 4.0)};

    public MagPeople() {
        super("Люди| Маг Человек", "Люди");
        setWeapons(weapons);
    }

    @Override
    public String nameWeapon() {
        return getWeapon().getNameWeapon();
    }

    @Override
    public boolean actionToTeam() {
        if (getWeapon().getHit() == 0) return true;
        else return false;
    }

    public void editWeapon() {
        setWeapon(weapons[1]);
        setHit(getWeapon().getHit());
    }
}
