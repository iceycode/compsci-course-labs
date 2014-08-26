package lab06;

/** Lab 6 part 3,4 
 * 
 * - uses StackLinkedListImpl.java to solve postfix problems
 * - makes use of stack pops and pushes 
 * - Following are postfix expressions that are solved:
   	1)	1 3 8 * +
	2)	8 2 Ð 8 4 / + 6 + 1 Ð 6 2/ - 
	3)	8 3 - 4 6 * - 3 +
	4)	1 9 2 *+ 2 Ð 3 4 / + 3 + 4 3* - 4+
	5)	1 9 +3 1 - / 6 + 2 - 
	6)	1 9 3 / + 1 Ð 6 2 - + 
 * 
 * NOTE: when dividing and subtracting, var num2 comes before num1 (num2/num1 OR num2 -num1)
 * 		[#] means that the number is currently in the stack
 * @author Allen Jagoda Lab 06 Part 4
 *
 */

public class StackLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StackLinkedList().run();

	}//main method
	
	public void run(){

        System.out.println("Solution to 1 3 8 * + : " + solve1());
        System.out.println("Solution to 82Ð84 /+ 6 + 1 Ð 6 2/-: " + solve2());
		System.out.println("Solution to 8 3 - 4 6 * - 3 + : " + solve3());
		System.out.println("Solution to 192 *+2Ð3 4/+ 3+ 4 3*-4+: " + solve4());
		System.out.println("Solution to 1 9 +3 1 - / 6 + 2 - : " + solve5());
		System.out.println("Solution to 1 9 3 / + 1 Ð 6 2 - +: " + solve6());
	}//run method
	


	public Integer solve1(){
		//solves 1 3 8 * +    (INFIX: 1 + 3 * 8)
		
		//variables for when using operators to evaluate
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		StackLinkedListImpl<Integer> stack = new StackLinkedListImpl<Integer>();
		
		//push numbers to stack
		stack.push(1);
		stack.push(3);
		stack.push(8);
		
		//pop 8 & 3 for eval
		num1 = stack.pop();
		num2 = stack.pop();
		result = num1*num2;
		
		//push result onto stack
		stack.push(result);
		
		//pop 1 & result to add
		num1 = stack.pop();
		num2 = stack.pop();
		result = num1 + num2;

		return result;		
	}
	
	private Integer solve2() {
		// Solve 8 2 Ð 8 4 / + 6 + 1 Ð 6 2/ -     (INFIX: 8 - 2 + 8 / 4 + 6 - 1 - 6 / 2)
		//push 8 & 2 to stack
		//variables for when using operators to evaluate
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		StackLinkedListImpl<Integer> stack = new StackLinkedListImpl<Integer>();
		
		//push 8 & 2--> pop to subtract --> push result back to stack
		stack.push(8);
		stack.push(2);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2 - num1; //= 6
		stack.push(result); //push 6
		
		//[6] 8 4 / + 6 + 1 Ð 6 2/ -
		//push 8 & 4--> pop both to divide --> push result to stack
		stack.push(8);
		stack.push(4);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2/num1; //= 2
		stack.push(result); //push 2
	
		//[6 2] + 6 + 1 Ð 6 2/ -
		//pop nums to add--> push to stack
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2 + num1; //= 8
		stack.push(result); //push 8
		
		//[8] 6 + 1 Ð 6 2/ -
		//push 6 --> pop nums to add --> push to stack
		stack.push(6);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2 + num1; //= 14
		stack.push(result); //push 14
		
		//[14] 1 Ð 6 2/ -
		//push 1 --> pop nums to subtract --> push to stack
		stack.push(1);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2 - num1; //= 13
		stack.push(result); //push 13
		
		//[13] 6 2 / -
		//push 6 & 2--> pop nums to divide --> push to stack
		stack.push(6);
		stack.push(2);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2/num1; //= 3
		stack.push(result); //push 3
		
		//[13 3] -
		//pop 3 & 15 to subtract --> return result
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2 - num1; //= 3
		
		return result;
	}
	
	private Integer solve3() {
		// Solve 8 3 - 4 6 * - 3 +     (INFIX: 8 - 3 - 4 * 6 + 3)
		//variables for when using operators to evaluate
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		StackLinkedListImpl<Integer> stack = new StackLinkedListImpl<Integer>();
		
		//push 8, 3 --> pop to subtract --> push result
		stack.push(8);
		stack.push(3);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2-num1; //= 5
		stack.push(result); //push 5
		
		//[5] 4 6 * - 3 + 
		//push 4, 6--> pop to multiply 4*6 --> push result
		//   --> pop to subtract --> push result
		stack.push(4);
		stack.push(6);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2*num1; //= 24
		stack.push(result); //push 24
		//[5 24] - 3 +
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2-num1; //= -19
		stack.push(result); //push -19
		
		//[-19] 3 + 
		//push 3 --> pop nums to add --> return result
		stack.push(3);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2+num1; //= -16
		
		return result;
		
	}
	
	private Double solve4() {
		// Solves 1 9 2 *+ 2 Ð 3 4 / + 3 + 4 3* - 4+  (INFIX: 1 + 9 * 2 - 2 + 3 / 4 + 3 - 4 * 3 + 4)
		double num1 = 0;
		double num2 = 0;
		double result = 0;
		
		StackLinkedListImpl<Double> stack = new StackLinkedListImpl<Double>();
		
		//push 1, 9 & 2--> pop 9 * 2 to multiply --> push result back to stack
		// --> pop result & 1 to add --> push back to stack
		stack.push(1.0);
		stack.push(9.0);
		stack.push(2.0);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2*num1; //= 18
		stack.push(result); //push 18
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2 + num1; //= 19
		stack.push(result); //push 19
		
		//[19] 2 Ð 3 4 / + 3 + 4 3* - 4+    
		stack.push(2.0);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2-num1; //= 17
		stack.push(result); //push 17
		
		//[17] 3 4 /+ 3 + 4 3* - 4 +    
		stack.push(3.0);
		stack.push(4.0);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2/num1; //= .75
		stack.push(result); //push .75
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2 + num1; //= 17.75
		stack.push(result); //push 17.75
		
		//[17.75] 3 + 4 3* - 4 +
		stack.push(3.0);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2+num1; //= 20.75
		stack.push(result); //push 20.75
		
		//[21.75] 4 3* - 4 +
		stack.push(4.0);
		stack.push(3.0);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2*num1; //= 11
		stack.push(result); //push 11
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2 - num1; //= 8.75
		stack.push(result); //push 8.75
		
		//9.75 4 +
		stack.push(4.0);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2+num1; //12.75
		
		return result;
	}
	
	private Integer solve5() {
		// Solves 1 9 +3 1 - / 6 + 2 -    (INFIX: (1 + 9) / (3 - 1) + 6 - 2)
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		StackLinkedListImpl<Integer> stack = new StackLinkedListImpl<Integer>();
		
		//1 9 +3 1 - / 6 + 2 -
		stack.push(1);
		stack.push(9);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2+num1; //= 10
		stack.push(result); //push 10
		
		//[10] 3 1 - / 6 + 2 -
		stack.push(3);
		stack.push(1);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2-num1; //= 2
		stack.push(result); //push 2
		
		//[10 2] / 6 + 2 -
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2/num1; //= 5
		stack.push(result); //push 5
		
		//[5] 6 + 2 -
		stack.push(6);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2+num1; //= 11
		stack.push(result); //push 11
		
		//[11] 2 -
		stack.push(2);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2-num1; //=9
		
		return result;
	}
	
	private Integer solve6() {
		//Solves 1 9 3 / + 1 Ð 6 2 - +   (INFIX: 1 + 9 / 3 - 1 + (6 - 2))
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		StackLinkedListImpl<Integer> stack = new StackLinkedListImpl<Integer>();
		
		//1 9 3 / + 1 Ð 6 2 - +
		stack.push(1);
		stack.push(9);
		stack.push(3);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2/num1; //= 3
		stack.push(result); //push 3
		
		//[1 3] + 1 Ð 6 2 - +
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2+num1; //= 4
		stack.push(result);//push 4
		
		//[4] 1 Ð 6 2 - +
		stack.push(1);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2-num1; //= 3
		stack.push(result); //push 3
		
		// [3] 6 2 - +
		stack.push(6);
		stack.push(2);
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2-num1; //= 4
		stack.push(result); //push 4
		//[3 4] +
		num1 = stack.pop();
		num2 = stack.pop();
		result = num2+num1; //=7
		
		return result;
	}

}
