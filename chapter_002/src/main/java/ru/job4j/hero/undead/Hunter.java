package ru.job4j.hero.undead;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Hero;
import ru.job4j.hero.Randomit;
import ru.job4j.hero.Weapon;

/**
 * Class Hunter.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class Hunter extends BaseHero {

    private final Weapon[] weapons = {new Weapon("стреляет из лука", 4.0), new Weapon("атакует", 2.0)};

    public Hunter() {
        super("Нечисть| Охотник Нечисти", "Нечисть");
        setWeapons(weapons);
    }

    @Override
    public String nameWeapon() {
        return getWeapon().getNameWeapon();
    }
}
