package ru.job4j.weight;

/**
 * class Fit - класс расчета идеального веса.
 * @author Artur Glyzin.
 * @since 01.05.2018.
 * @version 1.0.
 */

public class Fit {

	/**
	 * Идеальный вес для мужщины.
	 * @param height Рост.
	 * @return идеальный вес.
	 */

	public double manWeight(double height) {
		return (height - 100) * 1.15;
	}

	/**
	 * Идеальный вес для женщины.
	 * @param height Рост.
	 * @return идеальный вес.
	 */
	
	public double womanWeight(double height) {
		return (height -110) * 1.15;
	}

}