package ru.job4j.list;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class UserTest - test model User.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 16.03.2019.
 */

public class UserTest {
    @Test
    public void outputMapWithoutOverrideMethods() {
        User first = new User("Archi", 2, null);
        User second = new User("Archi", 2, null);
        Map<User, Object> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        assertThat(first.equals(second), is(true));
        System.out.println(map);
        System.out.println("Hashcode user1 - " + first.hashCode());
        System.out.println("Hashcode user2 - " + second.hashCode());
    }

    @Test
    public void outputMapOverrideMethods() {
        User first = new User("Archi", 2, null);
        User second = new User("Max", 2, null);
        Map<User, Object> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        assertThat(first.equals(second), is(false));

    }
}