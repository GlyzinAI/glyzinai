package ru.job4j.collections.sort;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class SortUserTest.
 *
 * @author Artur Glyzin.
 * @version 3.0.
 * @since 10.12.2018.
 */

public class SortUserTest {

    @Test
    public void whenSortUserByAge() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Сергей", 27);
        User user2 = new User("Иван", 38);
        User user3 = new User("Анатолий", 25);
        User user4 = new User("Оля", 19);
        User user5 = new User("Мария", 33);
        User user6 = new User("Ян", 14);
        List<User> listUsers = Arrays.asList(user1, user2, user3, user4, user5, user6);
        Set<User> expect = new HashSet<>();
        Collections.addAll(expect, user6, user4, user3, user1, user5, user2);
        Set<User> res = sortUser.sort(listUsers);
        assertThat(res, is(expect));
    }

    @Test
    public void whenSortNameLength() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Сергей", 27);
        User user2 = new User("Иван", 38);
        User user3 = new User("Анатолий", 25);
        User user4 = new User("Оля", 19);
        User user5 = new User("Мария", 33);
        User user6 = new User("Ян", 14);
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user1, user2, user3, user4, user5, user6));
        List<User> result = sortUser.sortNameLength(list);
        assertThat(result, is(Arrays.asList(user6, user4, user2, user5, user1, user3)));
    }

    @Test
    public void whenSortAllFieldsUseFunctionInterface() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Сергей", 20);
        User user2 = new User("Иван", 30);
        User user3 = new User("Сергей", 25);
        User user4 = new User("Иван", 25);
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user1, user2, user3, user4));
        List<User> result = sortUser.sortAllFieldsUseFunction(list);
        assertThat(result, is(Arrays.asList(user4, user2, user1, user3)));
    }


    @Test
    public void whenSortAllFields() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Сергей", 27);
        User user2 = new User("Дарья", 38);
        User user3 = new User("Анатолий", 25);
        User user4 = new User("Антон", 19);
        User user5 = new User("Мария", 33);
        User user6 = new User("Ян", 14);
        User user7 = new User("Сергей", 20);
        User user8 = new User("Иван", 30);
        User user9 = new User("Сергей", 25);
        User user10 = new User("Антон", 27);
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10));
        List<User> result = sortUser.sortAllFieldsUseFunction(list);
        assertThat(result, is(Arrays.asList(user3, user4, user10, user2, user8, user5, user7, user9, user1, user6)));
    }
}
