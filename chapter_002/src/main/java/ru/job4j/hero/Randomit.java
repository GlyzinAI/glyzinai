package ru.job4j.hero;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class Randomit.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */
public class Randomit {

    private Random rn = new Random();

    /**
     * selectWeapon - a random selection of weapons.
     *
     * @param weapons - array weapons
     * @return weapon
     */
    public Weapon selectWeapon(Weapon[] weapons) {
        int index = rn.nextInt(2);
        if (index == 0) return weapons[0];
        else return weapons[1];
    }

    /**
     * rmTurn - select hero, add weapon
     *
     * @param list - heroes of one team
     * @return hero
     */

    public BaseHero rmTurn(ArrayList<BaseHero> list) {
        int index = rn.nextInt(list.size());
        BaseHero hero = list.get(index);
        if (hero.getWeapons() == null) hero.setWeapon(hero.getWeapon());
        else hero.setWeapon(selectWeapon(hero.getWeapons()));
        if (hero.isNedug()) hero.setHit(hero.getWeapon().getHit() / 2.0);
        else hero.setHit(hero.getWeapon().getHit());
        return hero;
    }

    /**
     * rmTurnPartner - select hero is partner
     *
     * @param list - heroes of one team
     * @return hero
     */
    public BaseHero rmTurnPartner(ArrayList<BaseHero> list) {
        int index = rn.nextInt(list.size());
        BaseHero hero = list.get(index);
        return hero;
    }

    /**
     * selectTeam - choice of teams
     *
     * @param list1 team first
     * @param list2 - team second
     * @return team
     */
    public ArrayList<BaseHero> selectTeam(ArrayList<BaseHero> list1, ArrayList<BaseHero> list2) {
        int index = rn.nextInt(2);
        if (index == 0) return list1;
        else return list2;
    }
}
