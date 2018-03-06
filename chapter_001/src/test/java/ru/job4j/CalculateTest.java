package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test - тест для класса Calculate 
 * @author Artur Glyzin
 * @since 04.03.2018
 * @version 1
 */

public class CalculateTest {

	/**
	 Test echo
	 */
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Artur Glyzin";
		String expect = "Echo, echo, echo : Artur Glyzin";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}

}
	
	