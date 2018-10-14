package ru.job4j.weight;

/**
 * class Fit - класс расчета идеального веса.
 *
 * @author Artur Glyzin.
 * @version 2.0.
 * @since 13.10.2018.
 */

public class Fit {

    /**
     * Идеальный вес для мужщины.
     *
     * @param height Рост.
     * @return идеальный вес.
     */

    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Идеальный вес для женщины.
     *
     * @param height Рост.
     * @return идеальный вес.
     */

    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }

}