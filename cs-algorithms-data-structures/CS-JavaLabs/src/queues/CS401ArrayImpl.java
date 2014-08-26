package queues;

public class CS401ArrayImpl<E> implements CS401CollectionInterface<E>
{
   private E[] elements;
   private int num_elements;
   private int max_elements;

   public CS401ArrayImpl()
   {
      max_elements = 100;
      elements = (E[]) new Object[max_elements];
      num_elements = 0;
   }

   public boolean is_full()
   {
      if (num_elements == max_elements - 1)
          return true;
      return false;
   }

   public boolean is_empty()
   {
      if (num_elements == 0) 
          return true;
      return false;
   }

   public int size() { return num_elements; }

   public boolean add(int index, E e)
   {
      if (index < 0 || index >= (max_elements-1))
      {
          System.out.println("index is " + index);
          throw new IndexOutOfBoundsException();
      }

      elements[index] = e;
      num_elements++;
      return true;
   }

   public boolean add(E e)
   {
      add(num_elements, e);
      return true;
   }
   
   public E remove(int index)
   {
      E e;
      if (index < 0 || index > num_elements-1)
          throw new IndexOutOfBoundsException();

      e = elements[index];

      for (int i = index+1; i < num_elements; i++)
           elements[i-1] = elements[i];

      num_elements--;

      return e;
   }

   public E remove()
   {
      throw new UnsupportedOperationException();  /* Not used for arrays */
   }

   public E get(int index)
   {
      if (index < 0 || index >= (max_elements-1))
          throw new IndexOutOfBoundsException();

      return elements[index];
   }

   public boolean contains(E e)
   {
      return false;  /* To add code */
   }

}
