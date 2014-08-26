/**Programming Exercise 4.1
 * For each of the following, create and initialize a parameterized instance, add two elements to the instance, and
 * then print out the instance:
 *	a. an ArrayList object, scoreList, of Integer objects;
 *	b. a LinkedList object, salaryList, of Double objects;
 * 
 */

package chapter041;

import java.util.*;

public class Parametrized401 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Parametrized401().ArrayList();
		new Parametrized401().LinkedList();
	}//main method
	
	public void ArrayList()	{
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		scoreList.add(new Integer (94));
		scoreList.add(new Integer(95));
		System.out.println(scoreList);
		
	}//an ArrayList object, scoreList, of Integer objects;
	
	public void LinkedList()	{
		LinkedList<Double> salaryList = new LinkedList<Double>();
		salaryList.add(new Double(100000));
		salaryList.add(new Double(233333));
		System.out.println(salaryList);
		
	}// a LinkedList object, salaryList, of Double objects;
	
}
