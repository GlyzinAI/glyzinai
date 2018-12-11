package ru.job4j.collections.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class PhoneDictionary.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 10.12.2018.
 */

public class PhoneDictionary {

    private List<Person> person = new ArrayList<>();

    /**
     * method add
     *
     * @param person - person
     */

    public void add(Person person) {
        this.person.add(person);
    }

    public List<Person> find(String key) {

        List<Person> personList = person.stream()
                .filter(p -> p.getName().contains(key) || p.getSurname().contains(key) || p.getPhone().contains(key) || p.getAddress().contains(key))
                .collect(Collectors.toList());
        return personList;
    }
}
