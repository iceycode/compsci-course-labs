package lab04;
import java.util.*;

/** Excerise 6.13 from pages 262-263 in book
 * This is exercise 6.13 
 * An ArrayList is created known as words & several words are inputed into it.
 * There are 3 methods used to return only all the 4 letter words. They use:
 * a. indexes
 * b. explicit iterator
 * c. enhanced-for statement (uses ":")
 */

public class ArrayListWords {
	
	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<String>(); //creates ArrayList words
		words.add("run"); 					//adding 6 words
		words.add("butterfly");
		words.add("book");
		words.add("road");
		words.add("token");
		words.add("word");
		
		int length = 4; //length of words needed to be found
		
		new ArrayListWords().wordsIndex(words, length);
		new ArrayListWords().wordsIterator(words, length);
		new ArrayListWords().wordsFor(words, length);

	} //main method - creates ArrayList of words
	
	//Method for part a, which uses indexes to find and print out words with 4 letters
	public void wordsIndex (ArrayList<String> s, int len) {
		System.out.println("A. Using index, find words of length 4 within ArrayList words");
		
		for(int i = 0; i < s.size(); i++)     
        {     
            if(s.get(i).length() == len)     //compares length of index to length of 4
            {     
                System.out.println(s.get(i));
            } //if word is length 4, prints it
        } //for loops through size of ArrayList using index
		System.out.println("------END OF PART A------"); //prints a separator b/w next part
	}
	
	public void wordsIterator(ArrayList<String>s, int len){
		System.out.println("A. Using iterator, find words of length 4 within ArrayList words");
		
		ListIterator<String> iter = s.listIterator(); //ArrayList Iterator
		while (iter.hasNext())	{
			String word = iter.next( ); //defines current String as word
			if (word.length() == len)	{
				System.out.println(word);
			} //if word is length 4, prints it
		} //as long as there is another element in iterator
		System.out.println("------END OF PART B------"); //prints a separator b/w next part
	}
	
	//Method for part c, using an enhanced-for loop to find words of length 4
	public void wordsFor(ArrayList<String>s, int len) {
		System.out.println("C. Using enhanced-for, find words of length 4 within ArrayList words");
	
		for(String word : s) { 
			if (word.length() == len){
				System.out.println(word); 
			} //if word length 4, print it
		} //enhanced-for loop: for every item in ArrayList s, assign it String word
		System.out.println("------END OF PART C------"); //prints a separator b/w next part
	}

}

