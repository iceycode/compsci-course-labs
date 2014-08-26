package misc_CS401_Programs;
//Iterative Fibonacci sequence -- faster then recursiv


public class FibonacciIterative {

		public static int fib(int n) {
	                int prev1=0, prev2=1;
	                for(int i=0; i<n; i++) {
	                    int savePrev1 = prev1;
	                    prev1 = prev2;
	                    prev2 = savePrev1 + prev2;
	                }
	                return prev1;
		}
       
}
