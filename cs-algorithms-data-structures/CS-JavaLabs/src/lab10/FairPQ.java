package lab10;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FairPQ<E> extends PriorityQueue<E>
{
  
   public static final int DEFAULT_INITIAL_CAPACITY = 11;
    
   protected long count;   
   
    
   /**
    * Initializes this FairPQ object.
    */
   public FairPQ() 
   {                     
        super (DEFAULT_INITIAL_CAPACITY, new Natural<E>());
        count = 0;
   } // default constructor
  
  
   /**
    * Initializes this FairPQ object, in which comp 
    * will be used for element comparisons.
    * 
    * @param size the initial capacity of this FairPQ object.
    * @param comp a Comparator that dictates what type of
    *             comparison will be used between the 
    *             elements of the FairPQ.
    */
   public FairPQ (int size, Comparator<E> comp) 
   {         
      super (size, new Unnatural<E> (comp));  
      count = 0;
   } // constructor
   
  
   /**
    * Inserts a specified element to this FairPQ object. 
    * The worstTime(n) is O(n), and averageTime(n) is constant.
    * 
    * @param element -- the element that will be added to the FairPQ.
    */
   public boolean add (E element)  {    
      return super.add ((E) new FairElement<E> (element, count++));    
   } // method add
  
  
   /**
    * Returns the smallest-valued element in this non-empty FairPQ object.
    * 
    * @return the smallest-valued element in this FairPQ object
    */
   public E element() 
   {    
      FairElement<E> fairElement = (FairElement<E>)super.element();
    
      return fairElement.element;    
   } // method element
  
  
   /**
    * Removes and returns the smallest-valued element in this 
    * non-Empty FairPQ object.
    * The worstTime(n) is O(log n).
    * 
     * @return the element that was just removed.
    */
   public E remove() 
   {
       FairElement<E> fairElement = (FairElement<E>)super.remove();
    
       return (E)fairElement.element;    
   } // method remove 

} // classFairPQ

/**
 * 
 * Note: A trick is being played on the compiler in the add method when the fair
 * element is cast to E. The PriorityQueue class's add method is really being
 * called to insert a (reference to a) fair element, but the cast to E is needed
 * because the PriorityQueue class's add method is supposed to insert an element
 * of type E. And there is no ClassCastException at run time because then, in
 * effect, E is replaced by Object.
 */