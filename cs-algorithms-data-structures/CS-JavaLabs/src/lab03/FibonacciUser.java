/*
 * CONCLUSION - all 4 versions of fibonacci 
 *  ...Original Recursive, Iterative, My Recursive-Iterative, Formula
 *  ...one that works now is formula version, others are commented out
 * 
 */

package lab03;

import java.util.*;

public class FibonacciUser
{
  public static void main (String[] args)
  {
	  new FibonacciUser().run();
  } // method main

  
  /**
   *  The Fibonacci number of the integer entered has been printed.
   */
  public void run() 
  { 
     final int SENTINEL = -1;
 
     final String INPUT_PROMPT = "\n\nPlease enter the " +
        "positive integer whose Fibonacci number you want (or " +
         SENTINEL + " to quit): ";    
           
     final String FIBONACCI_MESSAGE = "\nIts Fibonacci number is ";
         
     Scanner sc = new Scanner (System.in);
    
     int n;

     while (true)
     {
        try
        {
          System.out.print (INPUT_PROMPT);
          n = sc.nextInt();
          if (n == SENTINEL)
        	  break;  
          System.out.println (FIBONACCI_MESSAGE + fib (n));
          timer();
        }//try
        catch (Exception e)
        {
          System.out.println (e);
          sc.nextLine();
        }//catch Exception      
     }//while     
  } // method run

  
  
  //My fibonacci method (fib wrapper & f) 
	/** 
	 * Returns the value in the Fibonacci sequence corresponding to a specified index.
	 *
	 * @param n - the specified index.
	 * 
	 * @return the nth value in the Fibonacci sequence.
	 *
	 * @throws IllegalArgumentException - if n <= 0 or > 92 (note
	 *         that fib (93) is larger than Long.MAX_VALUE).
	 *
	 */
	/*public static long fib (int n)  
	{
	      final int MAX_N = 92;
	
	      final String ERROR_MESSAGE = "\nThe number entered must be " +
	            "greater than 0 and at most " + MAX_N + ".";
	
	       if (n <= 0 || n > MAX_N)
	            throw new IllegalArgumentException (ERROR_MESSAGE);
	       
	       return f(n, 1, 1);
	       
	} // wrapper method fib for my method
*/
	/**
	 *  Returns a Fibonacci number from a given point in the sequence.
	 *
	 *  @param n - the integer whose Fibonacci number is sought from a given
	 *             point in the sequence.
	 *  @param previous - the first Fibonacci number in the sequence.
	 *  @param current - the next Fibonacci number in the sequence after 
	 *                   previous.
	 * 
	 * NOTE:                  
	 * Each recursion in f corresponds with one loop iteration in fib, within fib each n being
	 * 		decremented. Args corresponding to previous and current reflect how 
	 * 		those variables get new values during a loop iteration in the iterative version of fib
	 *		f(6,1,1) {print first number, return old prev, curr, n} --> fib(n) {iterate n: previous & current swap; 
	 *		return new values} --> f(5,1,2){...} 
	 */
/*	public static long f (int n, long previous, long current)   {
	
		if (n <= 2)
		     return current; //returns current value when n is less then 2
		
		return f(n - 1, current, current + previous);		
	}//recursive method written as iterative style
*/  
	
	
	//original fibonacci ITERATIVE method in FibonacciUser.java

  /**
   *  The Fibonacci number of the int n has been returned.
   * 
   * @param n an int whose Fibinacci number will be returned.
   *          n > 0.
   * 
   * @return a long containing the Fibonacci number of n.
   *
   * @throws IllegalArgumentException - if n <= 0 or > 92 (note 
   *         that fib (93) is larger than Long.MAX_VALUE).
   *
   */ 
  /*public static long fib (int n)  
  {
        final int MAX_N = 92;

        final String ERROR_MESSAGE = "\nThe number entered must be " +
            "greater than 0 and at most " + MAX_N + ".";

        long previous,
             current,
             temp;

        if (n <= 0 || n > MAX_N)
            throw new IllegalArgumentException (ERROR_MESSAGE);
  
        if (n <= 2) 
            return 1;
        previous = 1;
        current = 1;
        for (int i = 3; i <= n; i++) 
        {
            temp = current;
            current = current + previous;
            previous = temp;    
        } // for
        return current;
  } // fib iterative method
*/
	
/*
 * Original Recursive version
 * 
 */
/*public static long fib (int n)  
	{
		final int MAX_N = 92;

	        final String ERROR_MESSAGE = "\nThe number entered must be " +
	            "greater than 0 and at most " + MAX_N + ".";

	        if (n <= 0 || n > MAX_N)
	            throw new IllegalArgumentException (ERROR_MESSAGE);
	  	if (n <= 2 )
	    	    return 1;
	    	return fib (n - 1) + fib (n - 2); 
	} // method fib
 */
  
 
/*
 * Formula method 
 */
  public static long fib (int n)  
  {
  	final int MAX_N = 92;

          final String ERROR_MESSAGE = "\nThe number entered must be " +
              "greater than 0 and at most " + MAX_N + ".";

          if (n <= 0 || n > MAX_N)
              throw new IllegalArgumentException (ERROR_MESSAGE);
    
    	return (long)((1 / Math.sqrt (5)) *
                  (Math.pow((1 + Math.sqrt (5)) / 2, n)- 
             	Math.pow((1 - Math.sqrt (5)) / 2, n)));
  } // method fib

  
  public static void timer(){
	  final String MESSAGE_1 = "The elapsed time was ";

	  final double NANO_FACTOR = 1000000000.0;  // nanoseconds per second

	  final String MESSAGE_2 = " seconds.";

	  long startTime,
	       finishTime,
	       elapsedTime;

	  startTime = System.nanoTime();

	  // Perform the task:
	  fib(40);

	  // Calculate the elapsed time:
	  finishTime = System.nanoTime();
	  elapsedTime = finishTime - startTime;
	  System.out.println (MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2);
  }
  
} // class FibonacciUser
