package ru.job4j.collections.list;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class UserConvertTest.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 15.10.2018.
 */

public class UserConvertTest {
    @Test
    public void whenListConvertToMap() {
        User user1 = new User(1, "Artur", "Spb");
        User user2 = new User(2, "Daria", "Spb");
        User user3 = new User(3, "Alex", "Moscow");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user1, user2, user3));

        UserConvert userConvert = new UserConvert();

        Map<Integer, User> result = userConvert.process(list);
        Map<Integer, User> expect = new HashMap<>();
        expect.put(1, new User(1, "Artur", "Spb"));
        expect.put(2, new User(2, "Daria", "Spb"));
        expect.put(3, new User(3, "Alex", "Moscow"));

        assertThat(result, is(expect));
    }
}
