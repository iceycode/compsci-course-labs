package lab10;


/** Unnatural.java
 * 
 * The Unnatural class is used when the elements are ordered "unnaturally", that is, 
 * according to the compare method from a class that implements the Comparator interface.
 * In the Unnatural class,the assignment to result entails a call to the 
 * compare method to compare e1's element field to e2's element field.
 * 
 * @author Allen
 *
 * @param <E>
 */

import java.util.Comparator;

public class Unnatural<E> implements Comparator<E>
{
    protected Comparator<E> comp;
    
    public Unnatural (Comparator<E> comp) {
        this.comp = comp;
    } // constructor
    
    public int compare (E e1, E e2)  {
    	
       int result = comp.compare((E)((FairElement)e1).element, (E) ((FairElement)e2).element);

        
        if (result != 0)
            return result;
        
        return (int)(((FairElement)e1).count - ((FairElement)e2).count);
    } // method compare
  
} // class Unnatural
