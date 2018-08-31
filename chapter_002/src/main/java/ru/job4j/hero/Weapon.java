package ru.job4j.hero;

/**
 * Class Weapon.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class Weapon {
    private String nameWeapon;
    private double hit;

    public Weapon(String nameWeapon, double hit) {
        this.nameWeapon = nameWeapon;
        this.hit = hit;
    }

    public Weapon(String nameWeapon) {
        this.nameWeapon = nameWeapon;
    }

    public String getNameWeapon() {
        return nameWeapon;
    }

    public double getHit() {
        return hit;
    }
}
