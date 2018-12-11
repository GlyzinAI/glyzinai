package ru.job4j.collections.sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class SortUser - sort users by age.
 *
 * @author Artur Glyzin.
 * @version 3.0.
 * @since 10.12.2018.
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

    /**
     * Method sortNameLength - sorts, compares the length of name, use Functional Interface Comparator.
     *
     * @param list - users.
     * @return - sorted users list by name length.
     */

    public List<User> sortNameLength(List<User> list) {
        List<User> users = list.stream().sorted((n1, n2) -> Integer.compare(n1.getName().length(), n2.getName().length())).collect(Collectors.toList());
        return users;
    }

    /**
     * Method sortAllField - sorts, compares all fields, use Functional Interface Comparator.
     *
     * @param list - users.
     * @return - sorted users list by all fields.
     */

    public List<User> sortAllFieldsUseFunction(List<User> list) {
        Comparator<User> comparator = Comparator.comparing(User::getName);
        comparator = comparator.thenComparing(User::getAge);
        List<User> users = list.stream().sorted(comparator).collect(Collectors.toList());
        return users;
    }
}
