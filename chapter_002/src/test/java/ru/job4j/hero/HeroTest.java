package ru.job4j;

import org.junit.Test;
import ru.job4j.hero.*;
import ru.job4j.hero.elf.ArcherElf;
import ru.job4j.hero.elf.MagElf;
import ru.job4j.hero.people.ArcherPeople;
import ru.job4j.hero.undead.Hunter;
import ru.job4j.hero.undead.Necromant;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class HeroTest {
    @Test
    public void fight() throws IOException {
        ArrayList<BaseHero> elf = new ArrayList<>();
        ArrayList<BaseHero> ork = new ArrayList<>();
        elf.add(new ArcherElf());
        ork.add(new ArcherPeople());

        Team a = new Banda(elf);
        Team b = new Banda(ork);

        new StartGame().fight(a, b);
        assertThat(a.aliveTeam(), is(true));
        assertThat(b.aliveTeam(), is(false));
    }

    @Test
    public void fight2() throws IOException {
        ArrayList<BaseHero> people = new ArrayList<>();
        ArrayList<BaseHero> undead = new ArrayList<>();
        people.add(new ArcherPeople());
        undead.add(new Hunter());

        Team a = new Banda(people);
        Team b = new Banda(undead);

        new StartGame().fight(a, b);
        assertThat(a.aliveTeam(), is(true));
        assertThat(b.aliveTeam(), is(false));
    }

    @Test
    public void fight3() throws IOException {
        ArrayList<BaseHero> elf = new ArrayList<>();
        ArrayList<BaseHero> undead = new ArrayList<>();
        elf.add(new MagElf());
        undead.add(new Necromant());

        Team a = new Banda(elf);
        Team b = new Banda(undead);

        new StartGame().fight(a, b);
        assertThat(a.aliveTeam(), is(true));
        assertThat(b.aliveTeam(), is(false));
    }
}
