package lab04;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
/**
 * JUnit tests for ArrayListRemoveInsert
 * @author Allen
 *
 */
public class ArrayListRemoveInsertTest {
	
    protected ArrayListRemoveInsert removein = new ArrayListRemoveInsert(); //create instance of ArrayList class
    protected ArrayList<Integer> randInts = new ArrayList<Integer> (2 * 50); //create ArrayList of rand numbers
    
	@Test
	public void testremoveMethod() {
		randInts.add(9);
		randInts.add(7);
		removein.removeMethod(randInts, 9);
		assertFalse(randInts.contains(9)); //checks to see if 9 was removed
		assertTrue(randInts.contains(7)); //checks to see if 7 is in the list & only 9 was removed
	} //test removes method to see if it DOES NOT contain the element removed
	
	@Test
	public void testinsertAfterIntMethod(){
		//add two numbers to test
		randInts.add(9);
		randInts.add(7);
		removein.removeMethod(randInts, 9); //method removes 9
		removein.insertAfterIntMethod(randInts, 7, 9); //runs method on two numbers
		//checks index of first instance of 7 & 9

		/* assertions for testing
		 * - checks if randInts contains 9 & 7
		 * - checks to see if originally removed integer 9 comes after 7
		 */
		assertTrue(randInts.contains(9)); 
		assertTrue(randInts.contains(7));
		assertEquals(randInts.indexOf(7)+1, randInts.indexOf(9));
	} //tests to see if removeInt, or 9, comes after the insertAfterInt position

}
