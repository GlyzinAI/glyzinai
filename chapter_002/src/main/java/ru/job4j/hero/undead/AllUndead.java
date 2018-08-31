package ru.job4j.hero.undead;

import ru.job4j.hero.Banda;
import ru.job4j.hero.BaseHero;
import ru.job4j.hero.people.MagPeople;

import java.util.ArrayList;

/**
 * Class AllUndead.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public class AllUndead {
    public ArrayList<BaseHero> undead() {
        ArrayList<BaseHero> undead = new ArrayList<>();
        undead.add(new Hunter());
        undead.add(new Hunter());
        undead.add(new Hunter());
        undead.add(new Zombie());
        undead.add(new Zombie());
        undead.add(new Zombie());
        undead.add(new Zombie());
        undead.add(new Necromant());

        return undead;
    }
}
