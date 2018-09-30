package ru.job4j.collections.phone_directory;

/**
 * Class Person.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 30.09.2018.
 */

public class Person {

    private String name;
    private String surname;
    private String phone;
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
