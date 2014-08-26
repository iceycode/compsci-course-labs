//TEST for my method

package lab04;
  
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;

public class FibonacciTest 
{
	//Fibonacci fib= new Fibonacci();
	
  public static void main(String[] args)
  {  
    Result result = runClasses (FibonacciTest.class);
    System.out.println ("Tests run = " + result.getRunCount() +
                        "\nTests failed = " + result.getFailures());
  } // method main          
    
  @Test (expected = IllegalArgumentException.class)
  public void test0Illegal()
  {

    fib(0);    
  } // method test1Illegal
  
  @Test (expected = IllegalArgumentException.class)
  public void test93Illegal()
  {
	  fib(93);    
  } // method test93Illegal
    
  @Test
  public void test1Legal()
  {        
    assertEquals (1, fib (1));    
  } // method test1Legal
  
  @Test
  public void test5Legal()
  {        
    assertEquals (5, fib (5));    
  } // method test5Legal
  
  @Test
  public void test10Legal()
  {        
    assertEquals (55, fib (10));    
  } // method test10Legal
  
  @Test
  public void test15Legal()
  {      
    assertEquals (610, fib (15));    
  } // method test15Legal
    
  public static long fib (int n)  
  {
	  final int MAX_N = 92;
		
      final String ERROR_MESSAGE = "\nThe number entered must be " +
            "greater than 0 and at most " + MAX_N + ".";

       if (n <= 0 || n > MAX_N)
            throw new IllegalArgumentException (ERROR_MESSAGE);
       
       return f(n, 1, 1);
     //throw new RuntimeException(); //original code for fib
  } // method fib
  
  //my method f
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
  

} // class FibonacciTest    