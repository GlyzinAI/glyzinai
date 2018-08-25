package ru.job4j.hero.elf;

import ru.job4j.hero.Banda;
import ru.job4j.hero.BaseHero;

import java.util.ArrayList;

public class AllElf {
    public ArrayList<BaseHero> elf() {
        ArrayList<BaseHero> elf = new ArrayList<>();
        elf.add(new ArcherElf());
       // elf.add(new ArcherElf());
        //elf.add(new ArcherElf());
        elf.add(new WarriorElf());
      //  elf.add(new WarriorElf());
       // elf.add(new WarriorElf());
       // elf.add(new WarriorElf());
        elf.add(new MagElf());

        return elf;
    }
}
