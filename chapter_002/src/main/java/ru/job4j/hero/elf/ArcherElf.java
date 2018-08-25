package ru.job4j.hero.elf;

import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Randomit;
import ru.job4j.hero.Weapon;

public class ArcherElf extends BaseHero {
    private final Weapon[] weapons = {new Weapon("стреляет из лука", 7), new Weapon("атакует", 3)};

    private Weapon weapon = new Randomit().selectWeapon(weapons);






    public ArcherElf() {
        super("Эльфы| Лучник Эльф", "Эльфы");
        setHit(weapon.hit);
        setWeapon(weapon);
    }

    @Override
    public String nameWeapon() {
        return weapon.nameWeapon;
    }
}
