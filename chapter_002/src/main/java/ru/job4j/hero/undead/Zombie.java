package ru.job4j.hero.undead;

        import ru.job4j.hero.BaseHero;
        import ru.job4j.hero.Weapon;

/**
 * Class Zombie.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class Zombie extends BaseHero {
    private final Weapon weapon = new Weapon("бьёт копьем", 18.0);

    public Zombie() {
        super("Нечисть| Зомби Нечисти", "Нечисть");
        setHit(weapon.getHit());
        setWeapon(weapon);
    }

    @Override
    public String nameWeapon() {
        return weapon.getNameWeapon();
    }
}
