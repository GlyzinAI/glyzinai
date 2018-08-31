package ru.job4j.hero;

/**
 * Class BaseHero.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class BaseHero implements Hero {


    private String name;
    private String nameTeam;
    private int hp = 100;
    private double hit;
    private boolean privelege = false;
    private boolean nedug = false;

    private Weapon weapon;
    private Weapon[] weapons;

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public BaseHero(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setPrivelege(boolean privelege) {
        this.privelege = privelege;
    }

    public double getHit() {
        return hit;
    }

    public void editWeapon() {
    }

    public BaseHero() {
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public String getName() {
        return name;
    }

    public void setHit(double hit) {
        this.hit = hit;
    }

    public String nameWeapon() {
        return "Описание атаки";
    }

    public int getHp() {
        return hp;
    }

    public BaseHero(String name, String nameTeam) {
        this.name = name;
        this.nameTeam = nameTeam;
    }

    @Override
    public void attack(Hero evil) {
        evil.reduse((this.privelege ? 1.5 : 1) * this.hit);
    }

    @Override
    public void upgrade(Hero partner) {
        partner.skills(true);
    }

    @Override
    public void reduse(double value) {
        hp -= value;
    }

    @Override
    public boolean alive() {
        return hp > 0;
    }

    @Override
    public boolean actionToTeam() {
        return false;
    }

    @Override
    public void skills(boolean up) {
        this.privelege = up;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }

    public boolean isPrivelege() {
        return privelege;
    }

    public boolean isNedug() {
        return nedug;
    }

    public void setNedug(boolean nedug) {
        this.nedug = nedug;
    }
}
