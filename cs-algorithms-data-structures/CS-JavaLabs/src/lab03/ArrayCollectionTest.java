package lab03;
//test for ArrayCollection.java class

/** ArrayCollectionTest.java
 * - tests to see if the ArrayCollection.java class is correct in equals & remove methods
 * 
 * @author Allen Jagoda lab 06 CS401 TEST
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayCollectionTest {
	
	ArrayCollectionUser user = new ArrayCollectionUser();
	ArrayCollection<String> a1 = new ArrayCollection<String>();
	ArrayCollection<String> a2 = new ArrayCollection<String>();


	@Test
	public void testIT(){
		
		
		user.processMethodCall ("a1 ArrayCollection");
		user.processMethodCall ("a1 add yes");
		user.processMethodCall ("a1 add no");
		user.processMethodCall ("a1 add maybe");
					
	}//tests to see if elements were added
	
	@Test 
	public void testEquals(){
		
		a1.add("yes");
		a2.add("yes");
		
		
		assertEquals(a2.equals("yes"), a1.equals("yes"));
	}


}
