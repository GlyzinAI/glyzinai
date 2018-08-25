package ru.job4j.hero.undead;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Randomit;
import ru.job4j.hero.Weapon;

public class Hunter extends BaseHero {

    private final Weapon[] weapons = {new Weapon("стреляет из лука", 4), new Weapon("атакует", 2)};

    Weapon weapon = new Randomit().selectWeapon(weapons);

    public Hunter() {
        super("Нечисть| Охотник Нечисти","Нечисть");
        setHit(weapon.hit);
        setWeapon(weapon);
    }

    @Override
    public String nameWeapon() {
        return weapon.nameWeapon;
    }
}
