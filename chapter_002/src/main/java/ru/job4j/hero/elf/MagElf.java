package ru.job4j.hero.elf;

import ru.job4j.hero.BaseHero;

import java.util.Random;

public class MagElf extends BaseHero {
    public MagElf(String name, int hit, String weapon) {
        super(name, hit, weapon);
    }

    @Override
    public boolean actionToTeam() {
        boolean k = false;
        Random rn = new Random();
        int count = rn.nextInt(2);
        if (count == 0) {
            return k = true;
        }
        return k;
    }
}
