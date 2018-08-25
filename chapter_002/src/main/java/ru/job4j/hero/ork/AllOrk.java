package ru.job4j.hero.ork;

import ru.job4j.hero.Banda;
import ru.job4j.hero.BaseHero;
import ru.job4j.hero.Team;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AllOrk  {
    public ArrayList<BaseHero> ork() {
        ArrayList<BaseHero> ork = new ArrayList<>();
        ork.add(new ArcherOrk());
       // ork.add(new ArcherOrk());
       // ork.add(new ArcherOrk());
        ork.add(new WarriorOrk());
       // ork.add(new WarriorOrk());
       // ork.add(new WarriorOrk());
      //  ork.add(new WarriorOrk());
        ork.add(new ShamanOrk());

        return ork;
    }
}
