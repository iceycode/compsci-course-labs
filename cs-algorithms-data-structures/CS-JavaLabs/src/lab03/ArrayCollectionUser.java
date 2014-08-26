package lab03;

import java.util.*;

public class ArrayCollectionUser {
	protected ArrayCollection<String> a1, a2;
	
	public static void main(String args[]) {
		new ArrayCollectionUser().run();
	} // method main

	public void run() {
		final String SENTINEL = "***";

		final String INPUT_PROMPT = "\nIn the Input line, please enter a1 or a2 followed by the "
				+ "method identifier "
				+ "and, if applicable, the argument (or "
				+ SENTINEL
				+ " to quit): ";

		Scanner sc = new Scanner(System.in);

		String line;

		while (true) {
			try {
				System.out.print(INPUT_PROMPT);
				line = sc.nextLine();
				if (line.equals(SENTINEL))
					break;
				System.out.println(processMethodCall(line));
			} // try
			catch (Exception e) {
				System.out.println(e);
			} // catch
		} // while
	} // method run

	public String processMethodCall(String line) {
		final String OUTPUT_MESSAGE = "The calling object is now:\n";

		final String ADDED = " has been added to the ArrayCollection.";

		final String CONTAINED = " is contained in the ArrayCollection.";

		final String NOT_CONTAINED = " is not contained in the ArrayCollection.";

		final String EQUAL = "The ArrayCollection objects are equal.";

		final String NOT_EQUAL = "The ArrayCollection objects are not equal.";

		final String REMOVED = " was removed.";

		final String NOT_REMOVED = " was not removed because it is not in the ArrayCollection.";

		final String SIZE = "size = ";

		final String EMPTY = "The ArrayCollection is empty.";

		final String NOT_EMPTY = "The ArrayCollection is not empty.";

		ArrayCollection<String> callingObject = null, argument;

		Scanner lineScanner = new Scanner(line);

		String identifier = lineScanner.next(), result = "";

		String method = lineScanner.next();
		if (method.equals("ArrayCollection"))
			if (identifier.equals("a1")) {
				a1 = new ArrayCollection<String>();
				callingObject = a1;
			} // a1
			else {
				a2 = new ArrayCollection<String>();
				callingObject = a2;
			} // a2
		else {
			if (identifier.equals("a1"))
				callingObject = a1;
			else
				callingObject = a2;
			if (method.equals("isEmpty")) {
				if (callingObject.isEmpty())
					result = EMPTY;
				else
					result = NOT_EMPTY;
			} // isEmpty
			else if (method.equals("size"))
				result = SIZE + Integer.toString(callingObject.size());
			else if (method.equals("equals")) {
				if (lineScanner.next().equals("a1"))
					argument = a1;
				else
					argument = a2;
				if (callingObject.equals(argument))
					result = EQUAL;
				else
					result = NOT_EQUAL;
			}// else if equals
			else {
				String element = lineScanner.next();

				if (method.equals("add")) {
					callingObject.add(element);
					result = ADDED;
				} // add
				else if (method.equals("contains")) {
					if (callingObject.contains(element))
						result = CONTAINED;
					else
						result = NOT_CONTAINED;
				} // contains
				else if (method.equals("remove"))
					if (callingObject.remove(element))
						result = REMOVED;
					else
						result = NOT_REMOVED;
			} // operation add, contains, or remove
		} // not a constructor
		return result + OUTPUT_MESSAGE + callingObject.toString();
	} // method processMethodCall

} // class ArrayCollectionUser
