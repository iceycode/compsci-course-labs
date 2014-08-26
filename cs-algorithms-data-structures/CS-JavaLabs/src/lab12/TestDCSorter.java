package lab12;

/** TestDCSorter.java
 * 
 * @author Allen Jagoda Lab12
 *  
 */

import static org.junit.Assert.*;
import static org.junit.runner.JUnitCore.runClasses;

import java.io.FileReader;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Result;

public class TestDCSorter {
	protected Student[] sArray;
	
	public static void main(String[ ] args) {
	        Result result = runClasses (DCSorter.class);
	        System.out.println ("Tests run = " + result.getRunCount() +
	                            "\nTests failed = " + result.getFailures());
    } // method main
	
	@Before
	public void setUpBefore() throws Exception {

		String fileLocation = "/Users/Allen/Google Drive/ajagoda@u.rochester.edu/workspace/CS401 Labs/src/lab11/students.dat";
		FileReader file = new FileReader(fileLocation);

		Scanner sc = new Scanner(file);

		//StudentSorter b = new StudentSorter(); //to sort sArray using StudentSorter
		//		Comparator<Student> comp = new StudentComparator();
		//		PriorityQueue<Student> pq = new PriorityQueue<Student>(3780, comp);

		Student[] sArray = new Student[3380];
		int index = 0;

		while (sc.hasNextLine()){
			Student s1 = new Student(sc.nextLine());
			//pq.add(s1);
			sArray[index] = s1; 
			index++;
		}
		
		this.sArray = sArray;
	}//run before each test

	@Test
	public void testHeapSort() {
		DCSorter hs = new DCSorter();
		hs.heapSort_1(sArray); //sorted in ascending order
		//hs.heapSort_2(sArray);
		
		assertEquals(sArray[3379].toString(), "Ainsley, Audrey Arno 1066119696");
		assertEquals(sArray[0].toString(), "Washington, Taylor Zalachenko 1343287436");
	}//tests to see if heap sorted 
	
	@Test
	public void testMergesort(){
		DCSorter ms = new DCSorter();
		ms.mergeSort(sArray);
		
		assertEquals(sArray[3379].toString(), "Washington, Taylor Zalachenko 1343287436");
		assertEquals(sArray[0].toString(), "Ainsley, Audrey Arno 1066119696");
	}
	
	@Test
	public void testQuicksort(){
		DCSorter qs = new DCSorter();
		qs.quickSort(sArray);
		
		assertEquals(sArray[3379].toString(), "Washington, Taylor Zalachenko 1343287436");
		assertEquals(sArray[0].toString(), "Ainsley, Audrey Arno 1066119696");
	}
}
