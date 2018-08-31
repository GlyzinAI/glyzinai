package ru.job4j.hero.undead;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Hero;
import ru.job4j.hero.Weapon;

/**
 * Class Necromant.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class Necromant extends BaseHero {

    private final Weapon[] weapons = {new Weapon("насылает недуг на"), new Weapon("атакует магией", 5.0)};

    public Necromant() {
        super("Нечисть| Некромант Нечисти", "Нечисть");
        setWeapons(weapons);
    }

    @Override
    public String nameWeapon() {
        return getWeapon().getNameWeapon();
    }

    @Override
    public boolean actionToTeam() {
        return false;
    }

    @Override
    public void attack(Hero evil) {
        if (getHit() == 0) {
            evil.setNedug(true);

        } else
            super.attack(evil);
    }
}
