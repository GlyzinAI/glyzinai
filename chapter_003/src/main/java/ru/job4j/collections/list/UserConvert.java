package ru.job4j.collections.list;

import java.util.HashMap;
import java.util.List;

/**
 * Class UserConvert - преобразования List в Map.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 15.10.2018.
 */

public class UserConvert {

    /**
     * @param list - list(users)
     * @return map(id, user)
     */

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).getId(), list.get(i));
        }
        return map;
    }
}
