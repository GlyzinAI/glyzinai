package ru.job4j.hero;

public class BaseHero implements Hero {
    private String name;
    private int hp = 100;
    private int hit;
    private String weapon;
    public boolean privelege = false;

    public void setPrivelege(boolean privelege) {
        this.privelege = privelege;
    }

    public boolean isPrivelege() {
        return privelege;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getName() {
        return name;
    }

    public int getHit() {
        return hit;
    }

    public int getHp() {
        return hp;
    }

    public BaseHero(String name, int hit, String weapon) {
        this.name = name;
        this.hit = hit;
        this.weapon = weapon;
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
        return hp >= 0;
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
