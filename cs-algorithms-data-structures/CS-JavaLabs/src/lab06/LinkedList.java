package lab06;

/** LinkedList.java lab 06 part 1
 * - contains elements to test out the remove method in LinkedListImpl.java
 * - adds 1 element, deletes it
 * - adds 2 elements deletes first  
 * - adds 2 elements, deletes last one
 * - adds 3 elements, deletes the middle one
 */

import java.util.Iterator;

public class LinkedList
{
	public static void main(String[] args)
	{
		deleteOneofOne();
		deleteFirstofTwo();
		deleteLastofTwo();
		deleteMiddleofThree();

		/*
		 * Alternatively, you can iterate them more explicitly as follows:
      Iterator<Chores> itr = chores_list.iterator();
      while (itr.hasNext())
          System.out.println(itr.next()); */
	}

	public static void deleteOneofOne(){

		LinkedListImpl<Chores> chores_list = new LinkedListImpl<Chores>();
		Chores a = new Chores("Make bed", 10); //allocating memory

		chores_list.add(a); 
		Iterator<Chores> itr = chores_list.iterator();

		System.out.println("Elements in list before remove: --> ");
		for (Chores c: chores_list){
			System.out.println("  " +c);
		}
		itr.remove();

		System.out.println("Elements in list after remove: -->");
		for (Chores c: chores_list){
			System.out.println("  " + c);
		} //prints elements in list
	}

	public static void deleteFirstofTwo(){

		LinkedListImpl<Chores> chores_list = new LinkedListImpl<Chores>();
		//allocating memory
		Chores a = new Chores("Make Bed", 10);
		Chores b = new Chores("Do Laundry", 5);
		//Chores c = new Chores("Take out garbage", 20);
		
		chores_list.add(a);
		chores_list.add(b);
		
		Iterator<Chores> itr = chores_list.iterator();

		System.out.println("Elements in list before remove: --> ");
		for (Chores c1: chores_list){
			System.out.println("  " +c1);
		}
		
		while (itr.hasNext()){
			if (itr.next() == a) 
				itr.remove(); //removes first element at head
		}
		 
		System.out.println("Elements in list after remove: -->");
		for (Chores c2: chores_list){
			System.out.println("  " +c2);
		} //prints elements in list
	}

	public static void deleteLastofTwo(){
		LinkedListImpl<Chores> chores_list = new LinkedListImpl<Chores>();
		
		Chores a = new Chores("Make Bed", 10);
		Chores b = new Chores("Do Laundry", 5);
		//Chores c = new Chores("Take out garbage", 20);
		
		chores_list.add(a);
		chores_list.add(b);
		
		Iterator<Chores> itr = chores_list.iterator();

		System.out.println("Elements in list before remove: -->");
		for (Chores c1: chores_list){
			System.out.println("  " + c1);
		} //prints elements in list
		
		while (itr.hasNext()){

			if (itr.next() == b){
				itr.remove();//removes last element at tail
			}

		}
		
		System.out.println("Elements in list after remove: -->");
		for (Chores c2: chores_list){
			System.out.println("  " + c2);
		} //prints elements in list
	}

	public static void deleteMiddleofThree(){
		LinkedListImpl<Chores> chores_list = new LinkedListImpl<Chores>();
		
		Chores a = new Chores("Make Bed", 10);
		Chores b = new Chores("Do Laundry", 5);
		Chores c = new Chores("Take out garbage", 20);
		
		//adding elements
		chores_list.add(a);
		chores_list.add(b);
		chores_list.add(c);
		
		Iterator<Chores> itr = chores_list.iterator();

		System.out.println("Elements in list before remove: -->");
		for (Chores c1: chores_list){
			System.out.println("  " + c1);
		} //prints elements in list
		
		while (itr.hasNext()){
			if (itr.next() == a){
				itr.remove();//removes middle element at tail
			}//points to a b/c of remove() method details
		}
		
		System.out.println("Elements in list after remove: -->");
		for (Chores c2: chores_list){
			System.out.println("  " + c2);
		} //prints elements in list

	}
}
