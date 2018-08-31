package ru.job4j.hero;

import ru.job4j.hero.elf.AllElf;
import ru.job4j.hero.ork.AllOrk;
import ru.job4j.hero.people.AllPeople;
import ru.job4j.hero.undead.AllUndead;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class StartGame.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class StartGame {
    private Team first;
    private Team second;

    public static void main(String[] args) throws IOException {

        FileOutputStream file = new FileOutputStream("C:\\hero.txt");
        TeePrintStream tee = new TeePrintStream(file, System.out);
        System.setOut(tee);

        ArrayList<BaseHero> team1 = new Randomit().selectTeam(new AllElf().elf(), new AllPeople().people());
        ArrayList<BaseHero> team2 = new Randomit().selectTeam(new AllOrk().ork(), new AllUndead().undead());


        System.out.println("------------- Start game --------------");
        System.out.println();
        System.out.println("Обходя окрестности своего замка отряд - " + team1.get(0).getNameTeam() + ", встретил отряд - " + team2.get(0).getNameTeam() + ".");
        System.out.println("Отряды состояли из следующих воинов:");
        System.out.println("Команда " + team1.get(0).getNameTeam() + ":");
        for (int i = 0; i < team1.size(); i++) {
            System.out.println(team1.get(i).getName());
        }

        System.out.println();
        System.out.println("Команда " + team2.get(0).getNameTeam() + ":");
        for (int j = 0; j < team2.size(); j++) {
            System.out.println(team2.get(j).getName());
        }
        System.out.println();
        ArrayList<BaseHero> one = new Randomit().selectTeam(team1, team2);
        ArrayList<BaseHero> two = new ArrayList<>();
        if (one.equals(team1)) two = team2;
        else two = team1;

        System.out.println("Атаку первым начал отряд - " + one.get(0).getNameTeam());
        System.out.println("===========================================");

        Team first = new Banda(one);
        Team second = new Banda(two);

        new StartGame().fight(first, second);

    }

    /**
     * method fight
     *
     * @param first  - team first
     * @param second - team second
     */

    public void fight(Team first, Team second) {
        int count = 1;
        boolean turn = true;

        do {
            System.out.println("-------------- " + count + "-й ход --------------");
            BaseHero master = turn ? first.turn() : second.turn();
            if (master.actionToTeam() && first.lenghtList() > 1 && second.lenghtList() > 1) {
                BaseHero partner;
                do {
                    partner = turn ? first.turnPartner() : second.turnPartner();
                } while (master.equals(partner));

                master.upgrade(partner);
                if (turn) first.getPrivilegedTeam().add(partner);
                else second.getPrivilegedTeam().add(partner);
                System.out.println(master.getName() + " " + master.nameWeapon() + " " + partner.getName());
                System.out.println(partner.getName() + " переведен в привилегировнную группу");

            } else {

                if (master.actionToTeam() && (first.lenghtList() == 1 || second.lenghtList() == 1)) {
                    master.editWeapon();
                }

                BaseHero caller = !turn ? first.turn() : second.turn();

                if (master.isPrivelege() && !master.isNedug())
                    System.out.println(master.getName() + " " + master.nameWeapon() + " - " + caller.getName() + ", и наносит  УРОН - " + 1.5 * master.getHit() + "❤");
                else if (master.getWeapon().getHit() == 0)
                    System.out.println(master.getName() + " " + master.nameWeapon() + " - " + caller.getName());

                else if (master.isNedug())
                    System.out.println(master.getName() + " " + master.nameWeapon() + " - " + caller.getName() + ", и наносит  УРОН - " + master.getHit() + "❤");
                else
                    System.out.println(master.getName() + " " + master.nameWeapon() + " - " + caller.getName() + ", и наносит  УРОН - " + master.getHit() + "❤");

                master.attack(caller);
                master.setPrivelege(false);
                master.setNedug(false);
                if (turn) first.getPrivilegedTeam().remove(master);
                else second.getPrivilegedTeam().remove(master);
            }
            first.alive();
            second.alive();
            turn = !turn;
            count++;

        } while (first.aliveTeam() && second.aliveTeam());

        System.out.println("-----------------");

        if (!first.aliveTeam()) {
            second.survivor();
        } else {
            first.survivor();
        }
    }
}
