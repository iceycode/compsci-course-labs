package queues;

public class CS401QueueLinkedListImpl<E> implements CS401QueueInterface<E>  {
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int num_elements;

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

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;

      protected LinkEntry() { element = null; next = null; }
   }
}
