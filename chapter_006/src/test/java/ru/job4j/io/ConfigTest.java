package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ConfigTest - test for Config.class
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 24.04.2019.
 */

public class ConfigTest {
    private Config config;
    private String key1;
    private String key2;
    private String key3;
    private String key4;
    private String key5;

    @Before
    public void setUp() {
        config = new Config("C:/projects/app.properties");
        key1 = "hibernate.dialect";
        key2 = "hibernate.connection.url";
        key3 = "hibernate.connection.driver_class";
        key4 = "hibernate.connection.username";
        key5 = "hibernate.connection.password";
    }

    @Test
    public void whenCheckValue() {
        config.load();
        assertEquals("org.hibernate.dialect.PostgreSQLDialect", config.value(key1));
        assertEquals("jdbc:postgresql://127.0.0.1:5432/trackstudio", config.value(key2));
        assertEquals("org.postgresql.Driver", config.value(key3));
        assertEquals("postgres", config.value(key4));
        assertEquals("password", config.value(key5));
    }
}