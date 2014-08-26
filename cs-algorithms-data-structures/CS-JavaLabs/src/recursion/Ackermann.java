package recursion;

import java.util.Scanner;

/* lab4.6.c : Ackerman's recursion
 *Ackermann's function is recursive function defined as such:
 * int A(int x, y){
	   if (x = 0) return y +1;
	   if (y = 0) return A(x-1, 1)
	   return A(x-1, A(x, y-1))
   }//ackermann's function recursive algorithm
 *
 */

public class Ackermann {
	
	public int count=0;

	public static void main(String[] args) {
		new Ackermann().run();

	}
	
	public void run(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter a variable x: ");
		int x = s.nextInt();
		
		System.out.println("Enter a variable y: ");
		int y = s.nextInt();
				
		System.out.println("A("+x+", "+y+") = " + ack(x,y) + "\n"
				+ "Num of recursive calls: " + count);
	}

	public int ack(int x, int y){
		
		if (x!=0 && y != 0){
			count++;
			return ack(x-1, ack(x, y-1));
		}
		else if (y == 0){
			count++;
			return ack(x-1, 1);
		}
		else
			return y+1;
		
	}
}
