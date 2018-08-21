package ru.job4j.hero.ork;

import ru.job4j.hero.BaseHero;

import java.util.Random;

public class ShamanOrk extends BaseHero {
    public ShamanOrk(String name, int hit, String weapon) {
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
