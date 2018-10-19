package ru.job4j.collections.sort;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class SortUserTest.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 19.10.2018.
 */

public class SortUserTest {
    @Test
    public void whenSortList() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Artur", 22);
        User user2 = new User("Denis", 35);
        User user3 = new User("Daria", 56);
        User user4 = new User("Alisa", 17);
        User user5 = new User("Denis", 19);
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user1, user2, user3, user4, user5));
        Set<User> setResult = sortUser.sort(list);
        List<User> result = new ArrayList<>(setResult);
        assertThat(result, is(Arrays.asList(user4, user5, user1, user2, user3)));
    }
}
