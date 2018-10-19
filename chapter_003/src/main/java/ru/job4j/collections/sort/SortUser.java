package ru.job4j.collections.sort;

import java.util.*;

/**
 * Class SortUser - sort users by age.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 19.10.2018.
 */

public class SortUser {

    /**
     * @param list - list users.
     * @return - sorting users.
     */

    public Set<User> sort(List<User> list) {
        Set<User> users = new TreeSet<>(list);
        return users;
    }
}
