package ru.job4j.hero;

import java.util.ArrayList;
import java.util.Random;

public class Banda implements Team {
    ArrayList<BaseHero> list;
    ArrayList<BaseHero> privegi = new StartGame().priv;


    public Banda(ArrayList<BaseHero> list) {
        this.list = list;
    }

    @Override
    public boolean aliveTeam() {
        boolean alive = true;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).alive())
                alive = false;
        }
        return alive;
    }


    @Override
    public BaseHero turn() {
        if (privegi.isEmpty()){
            Random rn = new Random();
            int index = rn.nextInt(list.size());
            BaseHero hero = list.get(index);
            return hero;
        }
        else
            return privegi.get(0);
    }

}
