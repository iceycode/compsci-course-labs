import static org.junit.Assert.*;

import org.junit.Test;


public class TestCalcSub {

	@Test
	public void testSub() {
		Calculator calc = new Calculator();
		int result = calc.sub(10, 5);
		assertEquals(5, result);
	}

}
