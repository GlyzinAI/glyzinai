package ru.job4j.pseudo;

/**
 * Triangle.
 *
 * @author Artur Glyzin.
 * @version 1.0.
 * @since 06.08.2018.
 */

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("    +    ");
        pic.append("  +   + ");
        pic.append("+ + + + +");
        return pic.toString();
    }
}
