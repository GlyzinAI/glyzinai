package ru.job4j.hero.elf;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Weapon;

/**
 * Class WarriorElf.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class WarriorElf extends BaseHero {

    private final Weapon weapon = new Weapon("атакует мечом", 15.0);

    public WarriorElf() {
        super("Эльфы| Воин Эльф", "Эльфы");
        setHit(weapon.getHit());
        setWeapon(weapon);
    }

    @Override
    public String nameWeapon() {
        return getWeapon().getNameWeapon();
    }
}
