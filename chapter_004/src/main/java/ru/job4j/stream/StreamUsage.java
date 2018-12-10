package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class StreamUsage.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 10.12.2018.
 */

public class StreamUsage {

    private static class Task {
        private final String name;
        private final long spent;

        private Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    +
                    "name='" + name + '\''
                    +
                    ", spent=" + spent
                    +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );

        List<Task> bug = tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .collect(Collectors.toList());
        bug.forEach(System.out::println);


        List<String> names = tasks.stream()
                .map(task -> task.name)
                .collect(Collectors.toList());
        names.forEach(System.out::println);

        Long total = tasks.stream()
                .map(task -> task.spent)
                .reduce(0L, Long::sum);
        System.out.println(total);
    }

}
