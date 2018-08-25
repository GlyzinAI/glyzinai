package ru.job4j.hero.elf;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Randomit;
import ru.job4j.hero.Weapon;

import java.util.Random;

public class MagElf extends BaseHero {
    private final Weapon[] weapons = {new Weapon("накладывает улучшения", 0), new Weapon("атакует магией", 10)};

    private Weapon weapon = new Randomit().selectWeapon(weapons);

    public MagElf() {
        super("Эльфы | Маг Эльф","Эльфы");
        setHit(weapon.hit);
        setWeapon(weapon);
    }

    @Override
    public String nameWeapon() {
        return weapon.nameWeapon;
    }

    @Override
    public boolean actionToTeam() {
        if (weapon.hit == 0) return true;
        else return false;
    }
}
