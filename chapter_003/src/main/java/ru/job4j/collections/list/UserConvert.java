package ru.job4j.collections.list;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class UserConvert - преобразования List в Map.
 *
 * @author Artur Glyzin.
 * @version 3.0.
 * @since 10.12.2018.
 */

public class UserConvert {

    /**
     * @param list - list(users)
     * @return map(id, user)
     */

    public Map<Integer, User> process(List<User> list) {
        return list.stream().collect(Collectors.toMap(User::getId, user -> user));
    }
}
