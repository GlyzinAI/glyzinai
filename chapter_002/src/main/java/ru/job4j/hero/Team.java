package ru.job4j.hero;

import java.util.ArrayList;

/**
 * Interface Team.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public interface Team {

    boolean aliveTeam();

    BaseHero turn();

    void alive();

    void survivor();

    int lenghtList();

    ArrayList<BaseHero> getPrivilegedTeam();

    BaseHero turnPartner();
}
