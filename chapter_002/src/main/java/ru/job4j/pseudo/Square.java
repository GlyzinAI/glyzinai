package ru.job4j.pseudo;

/**
 * Square.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 06.08.2018.
 */

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append("+   +");
        pic.append("+   +");
        pic.append("++++");
        return pic.toString();
    }
}
