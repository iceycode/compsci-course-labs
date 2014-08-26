package lab10;

import java.util.Comparator;

/** Natural.java class
 * 
 * The Natural class is used when the elements are ordered "naturally", that is,
 * according to the compareTo method. In the Natural class, the assignment to
 * result entails a call to the compareTo method to compare e1's element field
 * to e2's element field.
 * 
 * @author from Collins W Data Structures lab 21
 * 
 * @param <E>
 */

public class Natural<E> implements Comparator<E>
{
    public int compare (E e1, E e2) 
    {
    	//need to add cast to element e2 to get element..added code after '='
        int result = ((Comparable)((FairElement)e1).element).compareTo(((FairElement)e2).element);

        if (result != 0)
            return result;
        
        return (int)(((FairElement)e1).count - ((FairElement)e2).count);     
    } // method compare

} // class Natural