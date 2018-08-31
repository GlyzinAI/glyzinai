package ru.job4j.hero.ork;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Weapon;

/**
 * Class WarriorOrk.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class WarriorOrk extends BaseHero {

    private Weapon weapon = new Weapon("атакует дубинкой", 20.0);

    public WarriorOrk() {
        super("Орки| Гоблин Орк", "Орки");
        setWeapon(weapon);
    }

    @Override
    public String nameWeapon() {
        return getWeapon().getNameWeapon();
    }

}
