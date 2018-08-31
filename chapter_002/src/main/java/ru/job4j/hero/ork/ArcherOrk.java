package ru.job4j.hero.ork;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Randomit;
import ru.job4j.hero.Weapon;

/**
 * Class ArcherOrk.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class ArcherOrk extends BaseHero {

    private final Weapon[] weapons = {new Weapon("стреляет из лука", 3.0), new Weapon("бьёт клинком", 2.0)};

    public ArcherOrk() {
        super("Орки| Лучник Орк", "Орки");
        setWeapons(weapons);

    }

    @Override
    public String nameWeapon() {
        return getWeapon().getNameWeapon();
    }
}
