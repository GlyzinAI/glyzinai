package ru.job4j.collections.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class UserConvert - преобразования List в Map.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 16.10.2018.
 */

public class UserConvert {

    /**
     * @param list - list(users)
     * @return map(id, user)
     */

    public Map<Integer, User> process(List<User> list) {
        Map<Integer, User> map = new HashMap<>();
        for (User user : list) {
            map.put(user.getId(), user);
        }
        return map;
    }
}
