/** Programming Exercise 4.2
 * Develop a main method in which two ArrayList objects are created, 
 * one with String elements and one with Integer elements. 
 * For each list:
 * - add three elements to the list, 
 * - remove the element at index 1, 
 * - add an element at index 0, 
 * - and print out the list.
 */

package chapter041;

import java.util.*;

public class ArrayLists402 {

	public static void main(String[] args) {
		// new ArrayList objects
		ArrayList<String> stringList = new ArrayList<String>();
		ArrayList<Integer> integerList = new ArrayList<Integer>();
		
		//adding elements to ArrayList objects
		stringList.add(new String("something")); //add to StringList
		stringList.add(new String("nothing"));
		stringList.add(new String("anything"));
		
		integerList.add(new Integer(1)); //add to integerList
		integerList.add(new Integer(2)); 
		integerList.add(new Integer(3));
		
		//remove element from index 1 & add to index 0
		stringList.remove(1); //for stringList
		stringList.add(0, "adding to index 0");
		
		integerList.remove(1); //for integerList
		integerList.add(0, 4);

		//printing out stringList & integerList
		System.out.println(stringList); 
		System.out.println(integerList);

	}//main method

}
