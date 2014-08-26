package lab04;

import java.util.*;

public class ArrayListRemoveInsert
{  
    public static void main (String[] args)
    {
        new ArrayListRemoveInsert().run();
    } // method main
    
    public void run()
    {
        final int SEED = 1000;

        final int INITIAL_CAPACITY = 50;
    
        final int MAX = 10;
  
        final String START_MESSAGE = "Here is the original array:\n";
                 
        final String REMOVE_PROMPT =
             "\n\nIn the Input line, please enter an integer in 1...10: ";
    
         final String MESSAGE_AFTER_REMOVAL =
             "\n\nHere is the array after removal of each occurrence of " +
             "the integer you entered:\n";
    
         final String SIZE_MESSAGE = "\nThe current size of the array is: ";
    
         final String INSERT_AFTER_PROMPT =
             "\n\nPlease enter another integer in 1...10: ";
    
         final String MESSAGE_AFTER_INSERTION =
             "\n\nHere is the array after the removed integer has been " +
             "inserted right after the integer you just entered:\n";
         
         Scanner sc = new Scanner (System.in);

         Integer removeInt = new Integer (-1), // ensures initialization
                 insertAfterInt;
  
         ArrayList<Integer> randInts = new ArrayList<Integer> (2 * INITIAL_CAPACITY); // to avoid resizing

         Random random = new Random (SEED);     

         boolean isFirstLine = true;            
            
         for (int i = 0; i < INITIAL_CAPACITY; i++)
             randInts.add (random.nextInt(MAX) + 1);
         System.out.println (START_MESSAGE + randInts);              
         
         while (true)
         {
             try
             {    
                 if (isFirstLine) 
                 {                   
                     System.out.print (REMOVE_PROMPT);
                     removeInt = sc.nextInt();
              
                     // Your call to the ArrayListRemoveInsert class's remove method goes here:
                     removeMethod (randInts, removeInt);
                     
                     System.out.println (MESSAGE_AFTER_REMOVAL + randInts);
                     System.out.println (SIZE_MESSAGE + randInts.size());
                     System.out.print (INSERT_AFTER_PROMPT);
                     isFirstLine = false;
                 } // processing first line of input
                 else 
                 {
                     insertAfterInt = sc.nextInt();   
              
                     // Your call to the ArrayListRemoveInsert class's insert method goes here:
                     insertAfterIntMethod (randInts, insertAfterInt, removeInt);
                     
                     System.out.println (MESSAGE_AFTER_INSERTION + randInts);
                     System.out.println (SIZE_MESSAGE + randInts.size());              
                     break;
                 } // else
             }//try
             catch (InputMismatchException e)
             {
                 System.out.println (e + ": " + sc.nextLine());
             }//catch InputMismatchException        
         }//while
    } // method run  
    
    // Your declaration and definition of the ArrayListRemoveInsert's remove method goes here:
    public void removeMethod(ArrayList<Integer> a, Object o)	{ 
    	while(a.contains(o))	{
       	 a.remove(o);
        }
    } //ArrayListRemoveInsert's remove method (takes in ArrayList & object)
        
    // Your declaration and definition of the ArrayListRemoveInsert's insert method goes here:
    public void insertAfterIntMethod (ArrayList<Integer> a, Object o1, Object o2){
    	for (int i = 0; i < a.size(); i++ ) {
			if (o1.equals(a.get(i)))	{
				a.add(i+1,(Integer) o2); //adds element to index after the one containing o1
			} //checks to see if the o1 is in the index
		}
    } //ArrayListRemoveInsert's insert method (takes in ArrayList & object)

    
    
} // class ArrayListRemoveInsert
