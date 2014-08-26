package lab04;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RemoveDuplicatesTest {

	protected RemoveDuplicates removeDups = new RemoveDuplicates(); //create instance of class
	
	protected ArrayList<Integer> list = new ArrayList<Integer> (5) ; //create ArrayList of 6 numbers to test

	/*
	 * Test should show the following:
	 * - duplicates have all been removed
	 * - checks if non-duplicates have not been removed by comparing what is in index before & after
	 */
	@Test
	public void testuniquefy() {
		
		//add 6 elements for testing
		list.add(2); //duplicate in index 0
		list.add(1); //duplicate in index 1
		list.add(2); //duplicate in index 2
		list.add(3); //---NON-duplicate index 3
		list.add(4); //---NON-duplicate index 4
		list.add(1); //duplicate in index 5
		
		assertTrue(list.get(5).equals(1));
		
		removeDups.uniquefy(list); //runs method for testing
        
        assertTrue(list.contains(3)); //check the elements are still there
		assertTrue(list.contains(4)); 
		assertTrue(list.contains(1)); 
		assertTrue(list.contains(2));
		assertTrue(list.get(3).equals(4)); //checks if last index, 3 (since 2 elements removed) contains 4
		assertFalse(list.get(3).equals(3)); //makes sure 3 is no longer at index 3
	}

}
