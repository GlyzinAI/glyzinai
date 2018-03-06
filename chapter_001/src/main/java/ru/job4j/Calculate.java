package ru.job4j;

/**
 * Class Calculate - Класс для каких-либо вычислений
 * @author Artur Glyzin
 * @since 04.03.2018
 * @version 1
 */

public class Calculate {

	/**
	 * Main Главный метод - с него всё начинается.
	 * Выводим в консоль - "Hello world"
	 * @param args - args
	 */

	public static void main(String[] args) {
		System.out.println("Hello word!");
	}

	/**
	 * Method echo.
	 * @param name Your name.
	 * @return Echo plus your name.
	 */
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}

}
