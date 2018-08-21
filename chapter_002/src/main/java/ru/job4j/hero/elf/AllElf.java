package ru.job4j.hero.elf;

import ru.job4j.hero.BaseHero;

import java.util.ArrayList;

public class AllElf {
    public ArrayList<BaseHero> elf() {
        ArrayList<BaseHero> elf = new ArrayList<>();
        elf.add(new ArcherElf("Лучник Эльф", 7, " стреляяет из лука"));
        elf.add(new ArcherElf("Лучник Эльф", 7, " стреляяет из лука"));
        elf.add(new ArcherElf("Лучник Эльф", 7, " стреляяет из лука"));
        elf.add(new WarriorElf("Воин Эльф", 15, " атакует мечом"));
        elf.add(new WarriorElf("Воин Эльф", 15, " атакует мечом"));
        elf.add(new WarriorElf("Воин Эльф", 15, " атакует мечом"));
        elf.add(new WarriorElf("Воин Эльф", 15, " атакует мечом"));
        elf.add(new MagElf("Маг Эльф", 20, " атакует магией"));

        return elf;
    }
}
