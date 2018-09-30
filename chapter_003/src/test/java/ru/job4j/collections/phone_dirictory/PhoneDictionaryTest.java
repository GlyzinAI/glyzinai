package ru.job4j.collections.phone_dirictory;

import org.junit.Test;
import ru.job4j.collections.phone_directory.Person;
import ru.job4j.collections.phone_directory.PhoneDictionary;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class PhoneDictionaryTest.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 30.09.2018.
 */

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        Person person1 = new Person("Arthur", "Glyzin", "345678", "Lenina55");
        Person person2 = new Person("Darya", "Glyzina", "657833", "Popova30");
        Person person3 = new Person("Ivan", "Ivanov", "335356", "Borisovo10");

        PhoneDictionary pD = new PhoneDictionary();
        pD.add(person1);
        pD.add(person2);
        pD.add(person3);

        List<Person> persons = pD.find("Bor");
        assertThat(persons.iterator().next().getName(), is("Ivan"));
    }

    @Test
    public void whenFindByName2() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(new Person("Anton", "Petrov", "235234", "Vasina34"));
        List<Person> persons = phone.find("523");
        assertThat(persons.iterator().next().getSurname(), is("Petrov"));
    }

    @Test
    public void whenFindByName3() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(new Person("Alisa", "Fedorova", "99999", "Melonova5"));
        List<Person> persons = phone.find("onova");
        assertThat(persons.iterator().next().getName(), is("Alisa"));
    }
}
