package ru.job4j.hero;

/**
 * Interface Hero.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 31.08.2018.
 */

public interface Hero {

    void attack(Hero evil);

    void upgrade(Hero partner);

    void reduse(double value);

    boolean alive();

    boolean actionToTeam();

    void skills(boolean up);

    String getName();

    void setNedug(boolean nedug);

    boolean isNedug();

}
