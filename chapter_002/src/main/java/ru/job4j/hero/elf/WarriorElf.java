package ru.job4j.hero.elf;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Weapon;

public class WarriorElf extends BaseHero {

    private final Weapon weapon = new Weapon("атакует мечом", 15);

    public WarriorElf() {
        super("Эльфы| Воин Эльф","Эльфы");
        setHit(weapon.hit);
        setWeapon(weapon);
    }

    @Override
    public String nameWeapon() {
        return weapon.nameWeapon;
    }
}
