package ru.job4j.hero;

import java.util.ArrayList;

/**
 * Class Banda.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class Banda implements Team {
    private ArrayList<BaseHero> list;
    private ArrayList<BaseHero> privilegedTeam = new ArrayList<>();

    public ArrayList<BaseHero> getPrivilegedTeam() {
        return privilegedTeam;
    }

    public Banda(ArrayList<BaseHero> list) {
        this.list = list;
    }

    @Override
    public void alive() {
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i).alive())) {
                System.out.println(list.get(i).getName() + " погибает †");
                list.remove(i);
                privilegedTeam.clear();
            }
        }
    }

    public Banda() {
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
    public BaseHero turn() {
        if (privilegedTeam.isEmpty()) {
            return new Randomit().rmTurn(list);
        } else return new Randomit().rmTurn(privilegedTeam);
    }

    @Override
    public BaseHero turnPartner() {
        if (privilegedTeam.isEmpty()) {
            return new Randomit().rmTurnPartner(list);
        } else return new Randomit().rmTurnPartner(privilegedTeam);
    }

    public void clList() {
        privilegedTeam.clear();
    }

    @Override
    public int lenghtList() {
        return list.size();
    }
}

