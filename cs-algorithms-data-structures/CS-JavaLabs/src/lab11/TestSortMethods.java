package lab11;

import static org.junit.Assert.*;
import static org.junit.runner.JUnitCore.runClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Result;

/** TestSortMethods.java 
 * - jUnit test for sort methods in StudentSorter.java
 * - tests to see if arrays actually sorted
 * 
 * @author Allen Jagoda 
 *
 */

public class TestSortMethods {
	protected Student[] sArray; //array for storing students
	
    public static void main(String[] args)
    {
        Result result = runClasses (StudentSorter.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main
    
	@Before
	public void setUpBefore() throws Exception {
		Student[] tempArr = new Student[3380];
		String fileLocation = "/Users/Allen/Google Drive/ajagoda@u.rochester.edu/workspace/CS401 Labs/src/lab11/students.dat";
		FileReader file = new FileReader(fileLocation);

		Scanner sc = new Scanner(file);
		
		int index = 0;

		while (sc.hasNextLine()){
			Student s1 = new Student(sc.nextLine());
			tempArr[index] = s1; 
			index++;
		}
		
		sArray = tempArr;
	}//run before each test

	@Test
	public void testBubbleSort() throws FileNotFoundException {
		
		StudentSorter bs = new StudentSorter(); //for bubble sort
		
		bs.bubbleSort(sArray);
		
		//checks to see if last & first elements are correctly sorted
		assertEquals(sArray[3379].toString(), "Washington, Taylor Zalachenko 1343287436");
		assertEquals(sArray[0].toString(), "Ainsley, Audrey Arno 1066119696");
		
	}//test bubblesort method
	@Test
	public void testInsertionSort() throws FileNotFoundException{
		StudentSorter is = new StudentSorter(); //for insertion sort
		
		sArray = is.insertionSort(sArray);
		
		//checks to see if last & first elements are correctly sorted
		assertEquals(sArray[3379].toString(), "Washington, Taylor Zalachenko 1343287436");
		assertEquals(sArray[0].toString(), "Ainsley, Audrey Arno 1066119696");
	}//test for insertion sort
	
	@Test
	public void testSelectionSort() throws FileNotFoundException{
		StudentSorter ss = new StudentSorter(); //for selection sort

		sArray = ss.bubbleSort(sArray);
		
		//checks to see if last & first elements are correctly sorted
		assertEquals(sArray[3379].toString(), "Washington, Taylor Zalachenko 1343287436");
		assertEquals(sArray[0].toString(), "Ainsley, Audrey Arno 1066119696");
	}//tests selectSort method

	
}
