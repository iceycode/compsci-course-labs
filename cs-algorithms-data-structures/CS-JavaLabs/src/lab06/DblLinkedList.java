package lab06;
/** Lab 06 part 2 
 * - implements LinkedList.java
 * - adds String variables to list & tests methods
 * To test your code, create a doubly linked list and enter the following elements of type String in it:
      Bill, Rohan, James, Krishna, Javier, Lisa
  (a) Print the linked list starting at the beginning.
  
  (b) Print the linked list starting at the end.
  
  (c) Remove Bill and print the linked list starting from beginning.
  
  (d) Remove Lisa and print the linked list starting from end.
  
  (e) Remove Krishna and print the linked list starting from the beginning.

 * @author Allen
 *
 */

import java.util.Iterator;

public class DblLinkedList {

	public static void main(String[] args) {
		run();
	}
	
	public static void run(){
		DblLinkedListImpl<String> names = new DblLinkedListImpl<String>();
		
		names.add("Bill");
		names.add("Rohan");
		names.add("James");
		names.add("Krishna");
		names.add("Javier");
		names.add("Lisa");
		
		//(a) printing names starting at beginning
		System.out.println("(a) Printing from front (in order added)");
		names.print_from_beginning();
		System.out.println("-----------");
		
		//(b) print starting from end
		System.out.println("(b) Printing from end (in reverse order)");
		names.print_from_end();
		System.out.println("-----------");
		
		//(c) remove Bjll (at index 1) & print from beginning
		System.out.println("(c) Remove Bill & printing from beginning");
		names.remove(1);
		names.print_from_beginning();
		System.out.println("-----------");
		
		
		//(d) remove Lisa & print from end (Lisa at 5 now since Bill removed)
		System.out.println("(d) Remove Lisa & print from end");
		names.remove(5);
		names.print_from_end();
		System.out.println("-----------");
		
		//(e) remove Krishna (at index 3 now) & print from beginning
		System.out.println("(d) Remove Krishna & print from beginning");
		names.remove(3);
		names.print_from_beginning();
		
	}

}
