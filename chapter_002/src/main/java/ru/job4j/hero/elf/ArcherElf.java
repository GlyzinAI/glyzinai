package ru.job4j.hero.elf;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Hero;
import ru.job4j.hero.Randomit;
import ru.job4j.hero.Weapon;

/**
 * Class ArcherElf.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class ArcherElf extends BaseHero {
    private final Weapon[] weapons = {new Weapon("стреляет из лука", 7.0), new Weapon("атакует", 3.0)};

    public ArcherElf() {
        super("Эльфы| Лучник Эльф", "Эльфы");
        setWeapons(weapons);
    }

    @Override
    public String nameWeapon() {
        return getWeapon().getNameWeapon();
    }
}
