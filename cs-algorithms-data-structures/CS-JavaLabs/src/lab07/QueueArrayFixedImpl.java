package lab07;

/** QueueArrayFixedImpl.java
 * Fixed front implementation of a Queue using arrays 
 * - fixed front means head does not move if element removed from back of queue
 * - therefore head == null after first remove
 * 
 * 
 * */

public class QueueArrayFixedImpl<E> implements QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;

   public QueueArrayFixedImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }//constructor

   //add (enqueue) element to queue tail
   public void add(E element) {
	   if (!is_full()){
		   data[back] = element;
		   back++; //increment back by 1
	   }
	   else	{
		   throw new IllegalStateException("Queue is full! Cannot add more!");
	   }//could also use a resize method
   }

   //remove first element, shift everything down since front doesn't move
   public E remove()  {
	   E element = null;
      
	  if (!is_full()){
		  element = data[front];
	      data[front] = null; //nothing in front, front still 0
	      
	      for (int i = 0; i < capacity; i++){
	    	  data[i] = data[i+1];
	      }//shift all elements down one...runtime O(n)
	      back--; //back shifts down one
	  }
	  else	{
		   throw new IllegalStateException("No elements in queue!");
	   }//no element to remove
      
      return element;

   }
   
   //retrive first element, but don't remove
   public E peek()  {
	   E element = null;
	   
	   if (!is_full()){
		   element = data[front];
	   }
	   else	{
		   throw new IllegalStateException("No elements in queue!");
	   }//no elements to peek 
	   return element;
   }

 //empty if capacity equals 0
   public boolean is_empty()  {

      return capacity == 0;

   }//is_empty() method
   
   //test to see if capacity equals array length
   public boolean is_full()  {
	   
      return capacity == data.length;

   }//is_full() method
}
