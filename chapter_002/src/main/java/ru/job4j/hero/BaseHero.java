package ru.job4j.hero;

public class BaseHero implements Hero {


    private String name;
    private int hp = 100;
    private int hit;
    private String nameTeam;
    public boolean privelege = false;

    private Weapon weapon;

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setPrivelege(boolean privelege) {
        this.privelege = privelege;
    }

    public int getHit() {
        return hit;
    }

    public BaseHero() {
    }

    public String getNameTeam() {
        return nameTeam;
    }


    public String getName() {
        return name;
    }


    public void setHit(int hit) {
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
        evil.reduse((this.privelege ? 2 : 1) * this.hit);
    }

    @Override
    public void upgrade(Hero partner) {
        partner.skills(true);
    }

    @Override
    public void reduse(int value) {
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
}
