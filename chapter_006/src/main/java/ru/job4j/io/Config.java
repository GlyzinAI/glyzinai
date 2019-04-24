package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Config - read file configuration.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 24.04.2019.
 */

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!(line.isEmpty() || line.startsWith("#") || line.startsWith("/"))) {
                    String[] split = line.split("=");
                    values.put(split[0], split[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }
}