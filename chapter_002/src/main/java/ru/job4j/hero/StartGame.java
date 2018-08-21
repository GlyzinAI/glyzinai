package ru.job4j.hero;

import ru.job4j.hero.elf.AllElf;
import ru.job4j.hero.ork.AllOrk;
import ru.job4j.hero.people.AllPeople;
import ru.job4j.hero.undead.AllUndead;

import java.util.ArrayList;


public class StartGame {
    private Team first;
    private Team second;

    ArrayList<BaseHero> priv = new ArrayList<>();

    public void init() {


        int count = 1;

        ArrayList<BaseHero> elf = new AllElf().elf();
        ArrayList<BaseHero> ork = new AllOrk().ork();
        ArrayList<BaseHero> people = new AllPeople().people();
        ArrayList<BaseHero> undead = new AllUndead().undead();



        Team first = new Banda(elf);
        Team second = new Banda(ork);


        boolean turn = true;
        System.out.println("------------- Start game --------------");
        /*BaseHero first = new StartGame().generateFirst(hero1, hero2);
        BaseHero second;*/
        // System.out.println("Первым ход делает - " + first. + "!");
        System.out.println("Да начнется битва!!!");
        System.out.println();


        do {

            System.out.println("-------------- " + count + "-й ход --------------");
            BaseHero master = turn ? first.turn() : second.turn();
            if (master.actionToTeam()) {
                BaseHero partner = turn ? first.turn() : second.turn();
                master.upgrade(partner);
                priv.add(partner);
                System.out.println(master.getName() + " накладвает улучшение на " +  partner.getName());
                System.out.println(partner.getName() + " переведен в привилегировнную группу");
            } else {
                BaseHero caller = !turn ? first.turn() : second.turn();

                master.attack(caller);

                System.out.println(master.getName() + master.getWeapon() + " - " + caller.getName() + ", и наносит  УРОН - " + "❤" + master.getHit());
            }
            turn = !turn;

            count++;


        } while (first.aliveTeam() && second.aliveTeam());

        System.out.println("-----------------");

        if (!first.aliveTeam()) {
            System.out.println("Победил отряд Орков!" );
        }

        else
            System.out.println("Победил отряд эльфов!");



    }

    public static void main(String[] args) {
        new StartGame().init();
    }
}
