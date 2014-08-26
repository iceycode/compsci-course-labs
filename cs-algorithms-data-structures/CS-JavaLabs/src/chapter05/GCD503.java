/**
 * Given two positive integers i and j , the greatest common divisor of i and j , written
		gcd (i, j)
	is the largest integer k such that
			(i % k = 0) and (j % k = 0).
	For example, gcd (35, 21) = 7 and gcd (8, 15) = 1. Test and develop a wrapper method and a wrapped
	recursive method that return the greatest common divisor of i and j . Here is the method specification for the
	wrapper method:
	Big hint: According to Euclid’s algorithm, the greatest common divisor of i and j is j if i % j = 0. Otherwise,
	the greatest common divisor of i and j is the greatest common divisor of j and (i % j).
 */

package chapter05;



public class GCD503 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(5,3));
	}
	/**
	* Finds the greatest common divisor of two given positive integers
	*
	* @param i – one of the given positive integers.
	* @param j – the other given positive integer.
	*
	* @return the greatest common divisor of iand j.
	*
	* @throws IllegalArgumentException – if either i or j is not a positive integer.
	*
	*/
	public static int gcd (int i, int j){
		
		int temp;
		
		//want to make things easier so always want j to be smaller then i 
		if (i < j) {
			temp = i; //temp turns to i
			i = j; //i turns to j
			j = temp; //j turns to temp (which stored i) 
		} //for swapping i & j if values are different
			
		return g(i, j);		
	} //wrapper method
	
	//recursive method for finding gcd
	public static int g (int x, int y){
		int r; //remainder if x%y not equal to 0 
		
		if (x % y == 0){
			return y;
		}
		r = x%y; //from Euclid's Algorithm
		x = y; //x now becomes y, the larger of the two
		
		return g(x, r);
	}


}
