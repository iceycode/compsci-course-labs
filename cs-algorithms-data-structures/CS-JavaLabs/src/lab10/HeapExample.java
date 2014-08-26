package lab10;

import java.util.*;

/** Heap.java
 * 
 * @author from Collins W. Data Structures lab 21
 *
 */

public class HeapExample
{
    public static void main (String[ ] args)
    {
        new HeapExample().run();
    } // method main
    
    
    public void run()
    {
         final String PROMPT1 = "Please enter student's name and GPA, or " ;

         final String PROMPT2 = " to quit: ";

         final String SENTINEL = "***";

         final String RESULTS1 = "\nHere are the student names and GPAs, " +
                                 "in increasing order of GPAs:";

         final String RESULTS2 = "\nHere are the student names and GPAs, " +
                                 "in alphabetical order of names:";
         
         FairPQ<Student> pq1 = new FairPQ<Student>(),
                         pq2 = new FairPQ<Student> (11, new ByName());

         Scanner sc = new Scanner (System.in);

         String line;

         while (true)
         {
             System.out.print (PROMPT1 + SENTINEL + PROMPT2);
             line = sc.nextLine();
             if (line.equals (SENTINEL))
                 break;
             pq1.add (new Student (line));
             pq2.add (new Student (line));
         } // while
         System.out.println (RESULTS1);
         while (!pq1.isEmpty())
             System.out.println (pq1.remove());
         
         System.out.println (RESULTS2);
         while (!pq2.isEmpty())
             System.out.println (pq2.remove());                        
     } // method run

} // class Heap
