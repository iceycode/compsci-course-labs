package lab04;
import java.util.*;


public class RemoveDuplicates {
	
	
	/**
	 * @param - creates an ArrayList with duplicates & without them
	 */
	public static void main(String[] args)  {
		
		ArrayList<Integer> duplicateList = new ArrayList<Integer>(); //creates ArrayList words
		duplicateList.add(2); //duplicate in list
		duplicateList.add(8); //duplicate
		duplicateList.add(3);
		duplicateList.add(8); //duplicate
		duplicateList.add(2); //duplicate
		duplicateList.add(5);
		duplicateList.add(6);
		duplicateList.add(7); 
		
		System.out.println("Original List: " + duplicateList);
		//ArrayList<Integer> newList = new ArrayList<Integer> (duplicateList);
		
		new RemoveDuplicates().uniquefy(duplicateList);
		
		System.out.println("List with removed duplicates: "+ duplicateList);

	} //main method

	/**
	 * In a given integer ArrayList, remove all duplicates.
	 * The worstTime(n) is O(n^2).
	 * @return 
	 * 
	 * @param list - the given ArrayList.
	 * 
	 * @return - an ArrayList that is the same as the one given, except without copies of duplicate elements
	 * 
	 * @throws - NullPointException
	 */
	public ArrayList<Integer> uniquefy (ArrayList<Integer> list) throws NullPointerException {
				
		int size = list.size(); //size of list
		int i = 0;
		int j = 0; //indexes 
		
		//NOTE: i needs to be less then j in order to not throw IndexOutOfBoundsException
		for (j = 0; j < size-1; j++)	{
			//start comparing next item
			for (i = j+1; i < size; i++) { 
				
				if (!list.get(i).equals(list.get(j))) 
	                continue; //continue checking if list elements are not equal at indexes
				
	            list.remove(i); //remove element that was a duplicate
	            
	            i--; 		// decrease i because the array got re-indexed
	            size--; 	// decrease the size of the array
			} // for i inner loop 	
		} //checks if item is already in list(outer loop)
				
		return list;  //ArrayList lacking duplicates		
	} 	// method for removing duplicates in quadratic time (worsttime(n) is Big-O(n2)

}
