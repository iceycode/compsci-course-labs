package lab05;

import java.util.Iterator;

import lab05.CircularLinkedList.LinkedListIterator;


/** CircularLinkedListUser.java
 * - implements CircularLinkedList.java class
 * - used to test to see if elements added to list correctly
 * - also used to see if 
 * 
 * @author Allen
 *
 */

public class CircularLinkedListUser {

	public static void main(String[] args) {
		
		int counter = 0; //counter to show list items order
		
		CircularLinkedList<String> cll = new CircularLinkedList<String>();
		
		System.out.println("----Added 4 to list----");
		cll.add("apples");
		cll.add("oranges");
		cll.add("bananas");
		cll.add("coconuts");

		Iterator<String> itr = cll.iterator();
		
		counter = 1; //counter set to 1
		while (itr.hasNext()){
			System.out.println(counter + ": " + itr.next());	
			counter++;
		}
		
		itr.remove();

		System.out.println("----Removed 1----");
		//print after removing
		counter = 1; //counter reset to 1
		while (itr.hasNext()){
			System.out.println(counter + ": " + itr.next());	
			counter++;
		}//-----------------------------------------------shown to be successfully remove apple 
		
		System.out.println("----Added 2 more----");
		cll.add("pears");  //-----------------:adding more
		cll.add("peaches");
		Iterator<String> itr1 = cll.iterator();
		//print after adding two more
		counter = 1; //counter reset to 1
		while (itr1.hasNext()){
			System.out.println(counter + ": " + itr1.next());	
			counter++;
		}
		
		itr.remove();  //-------------------------------successfully removes coconut
		cll.add("pineapples");
		cll.add("apricots");
		
		
		System.out.println("----Removed 1 and added 2 more----");
		//print again after removing
		counter = 1; //counter reset to 1
		while (itr.hasNext()){
			System.out.println(counter + ": " + itr.next());	
			counter++;
		}
	          
	}

}
