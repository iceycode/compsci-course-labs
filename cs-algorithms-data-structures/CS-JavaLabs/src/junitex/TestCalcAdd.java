package junitex;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestCalcAdd {

	@Test
	public void test() {
		Calculator calc = new Calculator();
		int result = calc.add(3,2);
		//to see if results go through, use assertEquals
		//assert Equals check to see if two values are equal
		assertEquals(5, result);
		
	}

}
