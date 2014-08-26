import static org.junit.Assert.*;

import org.junit.Test;


public class TestCalcAdd {

	@Test
	public void testAdd() {
		Calculator calc = new Calculator();
		int result = calc.add(1, 2);
		assertEquals(3, result);
	}
}
