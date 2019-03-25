package ru.job4j.statistics;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class Analyze - сollection statistics.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 25.03.2019.
 */

public class Analyze {

    /**
     * Analyzes past and current versions of collections, returns statistics of changes.
     *
     * @param previous - previous version
     * @param current  - current version.
     * @return change statistics.
     */
    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, User> users = previous.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        Info result = new Info();
        current.forEach(user -> {
            User tempUser = users.remove(user.id);
            if (tempUser == null) {
                result.added++;
            } else if (!tempUser.getName().equals(user.getName())) {
                result.changed++;
            }
        });
        result.deleted = users.size();
        return result;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}