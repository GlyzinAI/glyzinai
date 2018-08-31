package ru.job4j.hero.people;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Randomit;
import ru.job4j.hero.Weapon;

/**
 * Class ArcherPeople.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class ArcherPeople extends BaseHero {
    private Weapon[] weapons = {new Weapon("стреляет из арбалета", 5.0), new Weapon("атакует", 3.0)};

    public ArcherPeople() {
        super("Люди| Лучник Человек", "Люди");
        setWeapons(weapons);
    }

    @Override
    public String nameWeapon() {
        return getWeapon().getNameWeapon();
    }

}
