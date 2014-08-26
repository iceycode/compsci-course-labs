import  java.util.*;

public class CS401PriorityQueue<E>
{
   private static final int DEFAULT_INITIAL_CAPACITY = 11;

  /**
   * Priority queue represented as a balanced binary heap: the two
   * children of queue[n] are queue[2*n+1] and queue[2*(n+1)].  The
   * priority queue is ordered by comparator, or by the elements'
   * natural ordering, if comparator is null: For each node n in the
   * heap and each descendant d of n, n <= d.  The element with the
   * lowest value is in queue[0], assuming the queue is nonempty.
   */
   private transient Object[] queue;

   /**
     * The number of elements in the priority queue.
     */
    private int size = 0;

   /**
    * Creates a {@code PriorityQueue} with the default initial
    * capacity (11) that orders its elements according to their
    * {@linkplain Comparable natural ordering}.
    */
   public CS401PriorityQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

   /**
    * Creates a {@code PriorityQueue} with the specified initial
    * capacity that orders its elements according to their
    * {@linkplain Comparable natural ordering}.
    *
    * @param initialCapacity the initial capacity for this priority queue
    * @throws IllegalArgumentException if {@code initialCapacity} is less
    *         than 1
    */
   public CS401PriorityQueue(int initialCapacity) 
   {
      if (initialCapacity < 1)
          throw new IllegalArgumentException();
      this.queue = new Object[initialCapacity];
   }

    /**
     * Inserts the specified element into this priority queue.
     *
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws ClassCastException if the specified element cannot be
     *         compared with elements currently in this priority queue
     *         according to the priority queue's ordering
     * @throws NullPointerException if the specified element is null
     */
    public boolean add(E e) {
        return offer(e);
    }

    /**
     * Inserts the specified element into this priority queue.
     *
     * @return {@code true} (as specified by {@link Queue#offer})
     * @throws ClassCastException if the specified element cannot be
     *         compared with elements currently in this priority queue
     *         according to the priority queue's ordering
     * @throws NullPointerException if the specified element is null
     */
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        int i = size;
        if (i >= queue.length)
            grow(i + 1);
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
    }

   public E remove()  
   {
      if (size == 0)
         throw new NoSuchElementException();

      int s = --size;
      
      E elem = (E) queue[0];
      E last = (E) queue[s];
     
      queue[s] = null;
      if (s != 0) siftDown(0, last);

      return elem;
   }

   public String toString()
   {
      String s = "";
      
      for (int i = 0; i < size; i++)
         s += queue[i] + " ";

      return s;
   }

   /* --- Private methods --- */

   /**
    * Increases the capacity of the array.
    *
    * @param minCapacity the desired minimum capacity
    */
   private void grow(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
      int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = ((oldCapacity < 64)?
                           ((oldCapacity + 1) * 2):
                           ((oldCapacity / 2) * 3));
        if (newCapacity < 0) // overflow
            newCapacity = Integer.MAX_VALUE;
        if (newCapacity < minCapacity)
            newCapacity = minCapacity;
        queue = Arrays.copyOf(queue, newCapacity);
   }


   private void siftUp(int k, E x) 
   {
       Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (key.compareTo((E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
   }

   private void siftDown(int k, E x) 
   {
        Comparable<? super E> key = (Comparable<? super E>)x;
        int half = size >>> 1;        // loop while a non-leaf
        while (k < half) {
            int child = (k << 1) + 1; // assume left child is least
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                c = queue[child = right];
            if (key.compareTo((E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = key;
   }
}
