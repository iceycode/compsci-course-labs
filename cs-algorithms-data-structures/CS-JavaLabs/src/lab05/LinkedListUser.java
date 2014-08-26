package lab05;

/** LinkedListUser.java
 * - exercises 7.2 and 7.6 in Collins W (2011)
 * - some code from pages 318, 319 in Collins W (2011)
 * - OUTPUT: [p, e, r, f, e, c, t]
 * - 
 *
 */

import java.util.ListIterator;

import java.util.LinkedList;

public class LinkedListUser {

	public static void main(String[] args) {
		
		//------------Exercise 7.2---------------
		LinkedList<Character> letters = new LinkedList<Character>();
		
		ListIterator<Character> itr = letters.listIterator();
		
		
		itr.add ('f');
		itr.add ('t');
		itr.previous();
		itr.previous();
		itr.add ('e');
		itr.add ('r');
		itr.next();
		itr.add ('e');
		itr.add ('c');
		itr = letters.listIterator();
		itr.add ('p');
		System.out.println (letters);
		//-----------------------------------------
		
		//------------Exercise 7.6-----------------
		//NOTE: itr1 originally itr in book's code
		LinkedList<Double> weights = new LinkedList<Double>();
		ListIterator<Double> itr1;
		weights.add (5.3);
		weights.add (2.8);
		itr1 = weights.listIterator();
		
		//....testing legality of message sequences (illegal commented out)
		/*a----LEGAL*/
		itr1.add(8.8); itr1.next(); itr1.remove();
		/*b----ILLEGAL: remove() called after add() and cannot*/
		//itr1.add (8.8); itr1.remove(); itr1.next(); 
		/*c----ILLEGAL*/
		//itr1.next(); itr1.add (8.8); itr1.remove(); 
		/*d----LEGAL*/ 
		itr1.next(); itr1.remove(); itr1.add (8.8); 
		/*e----ILLEGAL, nothing to remove*/
		//itr1.remove(); itr1.add (8.8); itr1.next(); 
		/*f----ILLEGAL as well*/
		//itr1.remove(); itr1.next(); itr1.add (8.8);
		


	}

}
