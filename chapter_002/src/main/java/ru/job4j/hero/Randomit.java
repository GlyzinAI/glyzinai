package ru.job4j.hero;

import java.util.ArrayList;
import java.util.Random;

public class Randomit {
    Random rn = new Random();

    public Weapon selectWeapon(Weapon[] weapons) {
        int index = rn.nextInt(2);
        if (index == 0) return weapons[0];
        else return weapons[1];
    }


    public BaseHero rmTurn(ArrayList<BaseHero> list) {
        Random rn = new Random();
        int index = rn.nextInt(list.size());
        BaseHero hero = list.get(index);
        return hero;
    }
}
