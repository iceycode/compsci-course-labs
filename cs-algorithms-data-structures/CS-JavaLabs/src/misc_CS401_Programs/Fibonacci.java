package misc_CS401_Programs;
//Recursive Fibonacci Sequence
//Longer runtime than Iterative Fib sequence at larger numbers

public class Fibonacci {
	
	public static int fib(int n) {
                if (n < 2) {
                   return n;
                }
                else {
		   return fib(n-1)+fib(n-2);
                }
	}

}