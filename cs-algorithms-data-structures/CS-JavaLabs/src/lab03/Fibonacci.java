//HYPOTHESIS - asks for alt code of Fibonacci
package lab03;

public class Fibonacci {
	
	//casting types for timer	
	public static double startTime = 0; 
	public static double endTime = 0;
	public static double result = 0;

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) { 
	
		int num = 40; //Fibonacci number to be calculated
		startTime = System.nanoTime();
		System.out.println("The Fibonacci number is " + fib(num));
		endTime = System.nanoTime();
		System.out.println("\n"+ "Total run time: " + getTimes());
		
	}  //main method prints Fibonacci numbers
	
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
	public static double fib (int n)  
	{
	      final int MAX_N = 9;
	
	      final String ERROR_MESSAGE = "\nThe number entered must be " +
	            "greater than 0 and at most " + MAX_N + ".";
	
	       if (n <= 0 || n > MAX_N)
	            throw new IllegalArgumentException (ERROR_MESSAGE);
	       
	       return f(n, 1, 1);
	       
	} // method fib

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
	public static long f (int n, long previous, long current)   {
	
		if (n <= 2)
		     return current; //returns current value when n is less then 2
		
		return f(n - 1, current, current + previous);		
	}//recursive method written as iterative style
	
	public static double getTimes()  {
		
		return endTime - startTime;
		
	} //method for measuring run time

}
