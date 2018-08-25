package ru.job4j.hero.undead;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Weapon;

public class Zombie extends BaseHero {
    private final Weapon weapon = new Weapon("бьёт копьем", 18);

    public Zombie() {
        super("Нечисть| Зомби Нечисти","Нечисть");
        setHit(weapon.hit);
        setWeapon(weapon);
    }

    @Override
    public String nameWeapon() {
        return weapon.nameWeapon;
    }
}
