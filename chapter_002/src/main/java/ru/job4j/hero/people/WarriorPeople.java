package ru.job4j.hero.people;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Weapon;

/**
 * Class WarriorPeople.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class WarriorPeople extends BaseHero {

    private Weapon weapon = new Weapon("атакует мечом", 18.0);

    public WarriorPeople() {
        super("Люди| Воин Человек", "Люди");
        setHit(weapon.getHit());
        setWeapon(weapon);
    }

    @Override
    public String nameWeapon() {
        return weapon.getNameWeapon();
    }
}
