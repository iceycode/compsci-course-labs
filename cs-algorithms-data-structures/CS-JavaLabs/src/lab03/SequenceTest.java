package lab03;

/** JUnit test for Sequence
 * - tests the get, set & append methods
 * - also tests to see that default constructor contains null
 */

import static org.junit.Assert.*;
import static org.junit.runner.JUnitCore.runClasses;

import java.util.List;

import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class SequenceTest {	
	
	private static Sequence s = new Sequence(20); //object created for testing

	public static void main(String[] args) {
		
		for (int i = 0; i < 20; i++)
			s.append(i);
		
		Result result = runClasses(SequenceTest.class);
		System.out.println("Tests run = " + result.getRunCount()
				+ "\nTests failed = " + result.getFailures());
	} // method main for JUnit test

	@Test(expected = IndexOutOfBoundsException.class)
	public void testIllegalGet() {
		s.get(-1);
	} // method testing to see if a negative number in get yields 

	@Test
	public void testGet() {
		s.set(1, 100);
		assertEquals(100, s.get(1));
	} // method to make sure element was replaced
	
	@Test
	public void testAppend(){
		Sequence s1 = new Sequence();
		
		s1.append(111); //adds the number 111 to data at positi

		assertEquals(111, s1.get(0)); //checks 21st element
	}
	
	@Test
	public void testNull(){
		Sequence s2 = new Sequence();
		
		assertEquals(null, s2.get(0));
	}
}
