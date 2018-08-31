package ru.job4j.hero.elf;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Randomit;
import ru.job4j.hero.Weapon;

import java.util.Random;

/**
 * Class MagElf.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class MagElf extends BaseHero {
    private final Weapon[] weapons = {new Weapon("накладывает улучшения"), new Weapon("атакует магией", 10.0)};

    public MagElf() {
        super("Эльфы| Маг Эльф", "Эльфы");
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
