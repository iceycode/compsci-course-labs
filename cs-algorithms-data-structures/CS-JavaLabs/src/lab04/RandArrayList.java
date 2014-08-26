package lab04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;


/**  LAB 10;
 * RANDOM NUMBER ArrayList
 * Generates 10 integers b/w 1 & 10...
 * spits these out into an Array for use with ArrayList class
 * ...creates an array of 50 random integers
 */
public class RandArrayList {
	
	final static String SIZE = "The current size of the ArrayList: ";
  
	public static void main(String[] Args) throws IOException  {
	 
	  new RandArrayList().run();
	  
	} //main method
  
	public void run() throws IOException { 
	  
	    /*
	     * A list of 50 random integers is created
	     */
		ArrayList<Integer> randList = new ArrayList<Integer>(); //creates an ArrayList object with Integer type
				
		/*
		 * Fills out randList
		 * Prints out original Array & size of original array
		 */
		Random rand = new Random(); //creates new random object for (pseudo)random number generator
	    for (int index = 0; index < 50; ++index)  {
	    	randList.add(rand.nextInt(10)+1);
	    } //adds 50 random integers into ArrayList randList
	    System.out.println("Here is the original ArrayList: \n" + randList + "\n"
	    		+ SIZE + randList.size());
	    
		/*
		 * User enters a value to be removed
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("In the Input line, please enter an integer in 1...10: "); //user prompt
		Integer num1 = sc.nextInt(); //user input number to be taken out
		
		while(randList.contains(num1))	{
				randList.remove(num1);
		} // checks list to see if number is in it, if contains number (or returns true), removes it
		
		System.out.println("Here is the current ArrayList, after removal of each occurrence of the integer you entered: \n"
				+ randList + "\n" + SIZE + randList.size()); 		//prints new list
		/*
		 * user enters a number, after which the removed number will be placed immediately after
		 * size is altered as well
		 */
		System.out.print("In the Input line, please enter another integer in 1...10: "); //user prompt
		Integer num2 = sc.nextInt(); //user input number to be taken out
		
		
		/* NOTE: (Issue resolved itself)
		 * For some reason, this code gave a java Heap space error, but only in some cases. 
		 * -Nothing seemed to help with this except for simply coming back to it after a night.
		 * -My computer has 8 GB RAM, so I don't think that was the problem. 
		 * -After looking up online, a solution I found was java -Xmx1g RandArrayList - did not fix problem
		 * -problem resolved itself & code currently works! 
		 */
		for (int i = 0; i < randList.size(); i++ ) {
			if (num2.equals(randList.get(i)))	{
				randList.add(i+1, num1); //adds element to index after the one containing num2
			} //checks to see if the num2 is in the index
		}

		System.out.println("Here is the current ArrayList, after inserting removed number after each occurrence of the integer you entered: \n"
				+ randList + "\n" + SIZE + randList.size()); //prints
	} //run method (throws IOException if a number entered is 
}