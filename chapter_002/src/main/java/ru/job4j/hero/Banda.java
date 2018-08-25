package ru.job4j.hero;

import java.util.ArrayList;

public class Banda implements Team {
    ArrayList<BaseHero> list;

    public Banda(ArrayList<BaseHero> list) {
        this.list = list;
    }

    @Override
    public void alive() {
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i).alive())) {
                System.out.println(list.get(i).getName() + " погибает †");
                list.remove(i);
            }
        }
    }

    @Override
    public boolean aliveTeam() {
        if (list.isEmpty()) return false;
        else return true;
    }

    @Override
    public void survivor() {
        if (!list.isEmpty()) System.out.println("Победила команда " + list.get(0).getNameTeam());
        System.out.println("Выжившие герои:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + " XP:" + list.get(i).getHp());
        }
    }

    @Override
    public BaseHero turn(ArrayList<BaseHero> priv) {
        if (priv.isEmpty()) {
            return new Randomit().rmTurn(list);
        } else return new Randomit().rmTurn(priv);
    }

    @Override
    public int lenghtList() {
        return list.size();
    }


}

