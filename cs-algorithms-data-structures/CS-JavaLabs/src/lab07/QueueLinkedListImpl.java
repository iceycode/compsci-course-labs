package lab07;

import java.util.NoSuchElementException;

public class QueueLinkedListImpl<E> implements QueueInterface<E>  {
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int num_elements;

   //element always added at back (tail)
   public void add(E element) {

	   LinkEntry<E> ne = new LinkEntry<E>();
	   ne.element = element;
	   
	   if (is_empty()){
		   head = tail = ne;
	   }
	   
	   tail.next = ne; //next points to ne
	   tail = ne; //tail is now ne
	   tail.next = null; //next points to null
	   
	   num_elements++; //increment num_elements
   }//add method
   
   // retrieves and removes element from front (head)
   public E remove()  {
	   
	  if (is_empty()){ 
		  throw new IllegalStateException("There are no elements in queue to remove!");
	  }
	  E element = head.element;
	  head = head.next; //next element in line is head
	  num_elements--; //decrements num_elements
	  
      return element;

   }//remove method
   
   /**
   * Retrieves, but does not remove, the head of this queue.
   *
   * @return the head of this queue.
   * @throws NoSuchElementException if this queue is empty.
   */
   public E peek()  {
	   if (is_empty()){ 
		   throw new IllegalStateException("There are no elements in queue!");
	   }

	   return head.element;
   }

   public boolean is_empty()  {
	 //doesn't contain anything if head & tail empty
      return head == null && tail == null; 
   }//is_empty method

   //LinkedList can grow without limits
   public boolean is_full()  {
      return false;
   }//is_full method

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;

      protected LinkEntry() { 
    	  element = null; 
    	  next = null; 
      }//LinkEntry constructor
   }//LinkEntry class
}
