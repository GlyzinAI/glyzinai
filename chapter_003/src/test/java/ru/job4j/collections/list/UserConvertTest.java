package ru.job4j.collections.list;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class UserConvertTest.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 19.12.2018.
 */

public class UserConvertTest {
    @Test
    public void whenListConvertToMap() {
        User user1 = new User(1, "Artur", "Spb");
        User user2 = new User(2, "Daria", "Spb");
        User user3 = new User(3, "Alex", "Moscow");

        List<User> list = List.of(user1, user2, user3);

        UserConvert userConvert = new UserConvert();

        Map<Integer, User> result = userConvert.process(list);
        Map<Integer, User> expect = Map.of(1, user1, 2, user2, 3, user3);

        assertThat(result, is(expect));
    }
}
