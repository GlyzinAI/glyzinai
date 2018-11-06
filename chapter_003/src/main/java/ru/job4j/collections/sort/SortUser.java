package ru.job4j.collections.sort;

import java.util.*;

/**
 * Class SortUser - sort users by age.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 06.11.2018.
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

    public class CompareNameLength implements Comparator<User> {

        @Override
        public int compare(User o1, User o2) {
            return Integer.compare(o1.getName().length(), o2.getName().length());
        }
    }

    public class CompareAllFields implements Comparator<User> {

        @Override
        public int compare(User o1, User o2) {
            String x1 = o1.getName();
            String x2 = o2.getName();
            int sComp = x1.compareTo(x2);

            if (sComp != 0) {
                return sComp;
            } else {
                Integer x3 = o1.getAge();
                Integer x4 = o2.getAge();
                return x3.compareTo(x4);
            }
        }
    }

    /**
     * Method sortNameLength - sorts, compares the length of name, use class CompareNameLength.
     *
     * @param list - users.
     * @return - sorted users list by name length.
     */

    public List<User> sortNameLength(List<User> list) {
        CompareNameLength compareNameLength = new CompareNameLength();
        List<User> users = new ArrayList<>(list);
        users.sort(compareNameLength);
        return users;
    }

    /**
     * Method sortAllField - sorts, compares all fields, use Functional Interface Comparator.
     *
     * @param list - users.
     * @return - sorted users list by all fields.
     */

    public List<User> sortAllFieldsUseFunction(List<User> list) {
        Comparator<User> comparator = Comparator.comparing(user -> user.getName());
        comparator = comparator.thenComparing(user -> user.getAge());
        List<User> users = new ArrayList<>(list);
        users.sort(comparator);
        return users;
    }

    /**
     * Method sortAllField2 - sorts, compares all fields, use class CompareAllFields.
     *
     * @param list - users.
     * @return - sorted users list by all fields.
     */

    public List<User> sortAllField2(List<User> list) {
        CompareAllFields compareAllFields = new CompareAllFields();
        List<User> users = new ArrayList<>(list);
        users.sort(compareAllFields);
        return users;
    }
}
