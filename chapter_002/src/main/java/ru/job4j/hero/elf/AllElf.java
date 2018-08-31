package ru.job4j.hero.elf;

import ru.job4j.hero.Banda;
import ru.job4j.hero.BaseHero;

import java.util.ArrayList;

/**
 * Class AllElf.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class AllElf extends Banda {
    public ArrayList<BaseHero> elf() {
        ArrayList<BaseHero> elf = new ArrayList<>();
        elf.add(new ArcherElf());
        elf.add(new ArcherElf());
        elf.add(new ArcherElf());
        elf.add(new WarriorElf());
        elf.add(new WarriorElf());
        elf.add(new WarriorElf());
        elf.add(new WarriorElf());
        elf.add(new MagElf());

        return elf;
    }
}
