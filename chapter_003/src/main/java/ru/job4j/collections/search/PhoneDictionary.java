package ru.job4j.collections.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Class PhoneDictionary.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 30.09.2018.
 */

public class PhoneDictionary {

    private List<Person> person = new ArrayList<>();

    public void add(Person person) {
        this.person.add(person);
    }

    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person p : person) {
            if (p.getAddress().contains(key) || p.getName().contains(key) || p.getPhone().contains(key) || p.getSurname().contains(key)) {
                result.add(p);
            }
        }
        return result;
    }
}
