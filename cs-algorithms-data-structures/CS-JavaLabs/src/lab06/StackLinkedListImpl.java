package lab06;

/**
 * (3) Implement stacks using the template given in the following Java files:
   CS401StackInterface.java CS401StackLinkedListImpl.java

(4) Infix to postfix evaluation: Using the Stack class developed in the previous assignment, evaluate the following expressions.   Note that you have to first change these infix expressions to postfix expressions as discussed in the book and the class lecture.  Once you have a postfix expression, evaluate it using the Stack class to get the result as discussed in the lecture.
Use the Java Scanner class to input the postfix expression for evaluation.
Here is the input data:
  (1) 1 + 3 * 8
  (2) 8 - 2 + 8 / 4 + 6 - 1 - 6 / 2
  (3) 8 - 3 - 4 * 6 + 3
  (4) 1 + 9 * 2 - 2 + 3 / 4 + 3 - 4 * 3 + 4
  (5) (1 + 9) / (3 - 1) + 6 - 2
  (6) 1 + 9 / 3 - 1 + (6 - 2)
For each infix expression above, first provide the postfix expression, and then use your Stack class to evaluate the expression and print the final answer.

		Postfix version
	1)	1 3 8 * +
	2)	8 2 Ð 8 4 / + 6 + 1 Ð 6 2/ - 
	3)	8 3 - 4 6 * - 3 +
	4)	1 9 2 *+ 2 Ð 3 4 / + 3 + 4 3* - 4+
	5)	1 9 +3 1 - / 6 + 2 - 
	6)	1 9 3 / + 1 Ð 6 2 - + 

 * @author Allen Jagoda Lab 06 Part 3 
 */

import java.util.Iterator;

import lab06.DblLinkedListImpl.LinkEntry;

public class StackLinkedListImpl<E> implements StackInterface<E> 
{
   private LinkEntry<E> head;
   private int num_elements;

   public StackLinkedListImpl()
   {
      head = null;	  //head used as first entry
      num_elements = 0;
   }

   public void push(E e)
   { 

      LinkEntry<E> temp = new LinkEntry<E>();
      temp.element = e;
      
      temp.next = head; //temp points to head
      head = temp; //head now equal to temp
      
      num_elements++; //increment size
      
   }//add to top of list

   public E pop()
   {
	   E e = head.element; 
	   head = head.next; 
	   
	   num_elements--; //decrement size
	 
	   return e;
   }//removes & returns top element

   public int size()	{
		return num_elements;
   }//returns size (tracked by push & pop methods)

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;

      protected LinkEntry() { element = null; next = null; }
   }
} /* CS401StackLinkedListImpl<E> */
