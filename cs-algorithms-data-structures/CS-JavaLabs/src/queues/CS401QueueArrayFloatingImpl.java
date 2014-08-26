package queues;

/* 
 * Floating front and back implementation of a queue using an array */

public class CS401QueueArrayFloatingImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;

   public CS401ArrayImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }

   public void add(E element) {

      /*** Add code ***/
   }

   public E remove()  {
      
      /*** Add code ***/

   }
   public E peek()  {

      /*** Add code ***/

   }

   public boolean is_empty()  {

      /*** Add code ***/

   }

   public boolean is_full()  {

      /*** Add code ***/

   }

}
