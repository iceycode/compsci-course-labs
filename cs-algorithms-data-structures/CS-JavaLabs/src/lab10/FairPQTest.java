package lab10;

import static org.junit.Assert.*;
import static org.junit.runner.JUnitCore.runClasses;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Result;

/**
 * Tests to see if elements removed fairly
 * 
 * @author Allen
 * @param <fairElem>
 * 
 */

public class FairPQTest  {

    public static void main(String[ ] args)
    {
        Result result = runClasses (FairPQ.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main
    
    //Student & FairPQ objects
    protected Student student;
    
    protected FairPQ<Student> pq1 = new FairPQ<Student>(),
            				  pq2 = new FairPQ<Student> (11, new ByName());

    //String array of 11 student names with GPAs 
    String[] students = {"Mike 3.0", "Alex 3.9", "Maggie 3.3", "Bob 2.4", "Jennifer 4.0", "Kurt 3.0",
    		"Roland 3.1", "Alex 3.5", "Cassandra 2.4", "Opie 2.0", "Sandra 3.9"};
    
	@Before
	public void setUpBeforeClass() throws Exception {
		
		for (int i = 1; i < students.length; i++){
			Student student = new Student(students[i]); //adding student
			
			pq1.add(student);
			pq2.add(student);
			
		}//adding elements to FairPQ
		
	}//runs before each test

	
	/* Test remove by GPA
	 * - tests to see if remove is "fair" or "unfair", that is,
	 * student 1st added with same gpa as latter one added, is removed 1st
	 */
	@Test
	public void testRemovebyGPA(){
		
		//checking to see if Opie has been removed since lowest GPA
		assertEquals("Opie  2.0", pq1.remove().toString());
		
		//check to see that Bob was removed instead of Cassandra (since Bob was 1st in PQ)
		assertEquals("Bob  2.4", pq1.remove().toString());

	}
	
	/* Test removal by name
	 * - tests to see if names removed fairly
	 */
	@Test
	public void testRemovebyName(){
		//check to see that the first Alex with GPA of 3.9 is removed
		assertEquals("Alex  3.9", pq2.remove().toString());
		
		//check to see that 2nd Alex is now removed
		assertEquals("Alex  3.5", pq2.remove().toString());
	}

}
