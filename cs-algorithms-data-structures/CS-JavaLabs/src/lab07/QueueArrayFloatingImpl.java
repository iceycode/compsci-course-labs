package lab07;

/** QueueArrayFloatingImpl.java 
 * Floating front and back implementation of a queue using an array 
 * - front does change when element is removed from back of queue
 * - back moves to front position if at end, front moves up to next index
 * - back keeps moving up with front, wrapping around
 * 
 * */

public class QueueArrayFloatingImpl<E> implements QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;

   public QueueArrayFloatingImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];  
      front = back = 0;    
   }

   //adds element to back of array
   public void add(E element) {

	   if (!is_full()){
		   data[back] = element;
		   //change position
		   back = (back+1) % capacity;
	   }
	   else
		   throw new IllegalStateException("Queue is full! Cannot add more!");
	   
   }

   //retrieves & removes element from front
   public E remove()  {
	   E element = null; //initalize element to null
      if (!is_empty()){
    	  element = data[front];
    	  //change position of front
    	  front = (front - 1) % capacity;
    	  
      }//make sure not empty
      else
    	  throw new IllegalStateException("There are no elements in queue!");
      
      return element;
      
   }
   
   //retrieves but does not remove element
   public E peek()  {

      E element = null;
      
      if (!is_empty()){
    	  element = data[front];
      }
      else
    	  throw new IllegalStateException("There are no elements in queue!");
      
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
