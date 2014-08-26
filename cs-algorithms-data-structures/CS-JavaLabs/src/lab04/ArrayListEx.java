package lab04;

/** Exercise 6.4
 * - programming exercise on page 260 in book
 */

import java.util.*;

public class ArrayListEx {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		/*
		 * Exercise 6.4 Hypothesis what will happen when the following code
		 * fragement is run, and then test your hypothesis. Hint: This exercise
		 * illustrates why the copy constructor is superior to the clone()
		 * method.
		 * 
		 * I hypothesized that there would be some kind of check error and there
		 * was, but only when running via command-line (Terminal). The following
		 * was shown when attempting to compile in Terminal: “ArrayListEx.java
		 * uses unchecked or unsafe operations.” Within the Eclipse IDE, the
		 * element “yes” actually printed out. However, when using the clone()
		 * method, the Eclipse IDE shows a warning, “Unchecked Cast from Object
		 * to Array<Integer>”, which indicates that this will not properly
		 * transform any elements stored in the copy if those elements where not
		 * the right type. This could be potentially troublesome when stored
		 * using copies of ArrayLists that were meant to store Integers with
		 * String functions, potentially leading to errors in math functions if
		 * the copy element was used instead of the original one. A
		 * copy-constructor would automatically transform an element properly.
		 * 
		 */
		ArrayList<String> original = new ArrayList<String>();
		original.add("yes");
		ArrayList<Integer> copy = (ArrayList<Integer>) original.clone();

		System.out.println(copy.get(0));

	}

}
