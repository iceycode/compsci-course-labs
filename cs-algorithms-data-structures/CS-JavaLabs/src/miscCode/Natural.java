package miscCode;

   import java.util.*;

   class Natural<E> implements Comparator<E>
   {
       public int compare (E e1, E e2) 
       {
           int result = 
        		   ((Comparable)(((FairElement)e1).element)).compareTo(((FairElement)e2).element);
          
           if (result != 0)
               return result;
           return (int)(((FairElement)e1).count - ((FairElement)e2).count);
       } // method compare

   } // class Natural
