import java.util.Iterator;

public class CS401DblLinkedListImpl<E> implements CS401CollectionInterface<E> 
{
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int s = 1;

   public CS401DblLinkedListImpl()
   {
      head = tail = null;
   }

   public boolean is_empty()
   {
      if (head == null) 
          return true;

      return false;
   }

   public boolean is_full() { return false; }

   public int size()
   {
      return size_r(head) - 1;
      /*
       * Note that an iterative solution that traverses the list from
       * the front would be as follows:
       * 
       * LinkEntry<E> temp;
       * int i = 0;
       *
       * for (temp = head; temp != null; temp = temp.next)
       *      i++;
       * return i;
       */
   }

   public boolean add(int index, E e)
   {
      throw new UnsupportedOperationException();
   }

   /*
    * Add e to the end of the doubly linked list.
    * Returns true - if e was successfully added, false otherwise.
    */
   public boolean add(E e)
   {
      /** Add code here **/             
      return true;
   }

   /*
    * Remove the nth element in the list.  The first element is element 1.
    * Return the removed element to the caller.
    */
   public E remove(int n)
   {
      /** Add code here **/             
        
      return null;
   }

   /*
    * Print the doubly linked list starting at the beginning.
    */
   public void print_from_beginning()
   {
      /** Add code here **/
      return;
   }

   /*
    * Print the doubly linked list starting the end.
    */
   public void print_from_end()
   {
      /** Add code here **/
      return;
   }

   public E remove()
   {
      throw new UnsupportedOperationException();
   }

   public E get(int index)
   {
      throw new UnsupportedOperationException();
   }

   public boolean contains(E e)
   {
      throw new UnsupportedOperationException();
   }

   private int size_r(LinkEntry<E> head)  /* Think about this recursive call! */
   {
      if (head != null)
         s = s + size_r(head.next);
      return s;
   }
   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;
      protected LinkEntry<E> previous;

      protected LinkEntry() { element = null; next = previous = null; }
   }
} /* CS401LinkedListImpl<E> */
