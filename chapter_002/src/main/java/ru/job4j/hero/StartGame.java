package ru.job4j.hero;

import ru.job4j.hero.elf.AllElf;
import ru.job4j.hero.ork.AllOrk;
import ru.job4j.hero.people.AllPeople;
import ru.job4j.hero.undead.AllUndead;

import java.util.ArrayList;


public class StartGame {
    private Team first;
    private Team second;
    ArrayList<BaseHero> privilegedTeamOne = new ArrayList<>();
    ArrayList<BaseHero> privilegedTeamTwo = new ArrayList<>();



    public void init() {

        // System.setOut(new PrintStream(new FileOutputStream("D:\\output5.txt")));


        int count = 1;


        ArrayList<BaseHero> elf = new AllElf().elf();
        ArrayList<BaseHero> ork = new AllOrk().ork();
        ArrayList<BaseHero> people = new AllPeople().people();
        ArrayList<BaseHero> undead = new AllUndead().undead();


        Team first = new Banda(people);
        Team second = new Banda(undead);


        boolean turn = true;
        System.out.println("------------- Start game --------------");

        System.out.println("Да начнется битва!!!");
        System.out.println();


        do {

            System.out.println("-------------- " + count + "-й ход --------------");
            BaseHero master = turn ? first.turn(privilegedTeamOne) : second.turn(privilegedTeamTwo);
            if (master.actionToTeam() && first.lenghtList() > 1 && second.lenghtList() > 1) {
                BaseHero partner = null;
                do {
                    partner = turn ? first.turn(privilegedTeamOne) : second.turn(privilegedTeamTwo);
                }while (master.equals(partner));

                master.upgrade(partner);
                if (turn) privilegedTeamOne.add(partner);
                else privilegedTeamTwo.add(partner);
                System.out.println(master.getName() + " " + master.nameWeapon() + " " + partner.getName());
                System.out.println(partner.getName() + " переведен в привилегировнную группу");


            } else {

                BaseHero caller = !turn ? first.turn(privilegedTeamOne) : second.turn(privilegedTeamTwo);

                master.attack(caller);


                master.setPrivelege(false);
                if (turn) privilegedTeamOne.remove(master);
                else privilegedTeamTwo.remove(master);

                System.out.println(master.getName() + " " + master.nameWeapon() + " - " + caller.getName() + ", и наносит  УРОН - " + master.getHit() + "❤");
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

    public static void main(String[] args) {
        new StartGame().init();

    }
}
