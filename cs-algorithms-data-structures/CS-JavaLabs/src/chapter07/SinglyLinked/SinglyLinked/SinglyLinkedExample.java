package chapter07.SinglyLinked.SinglyLinked;

import java.util.*;

public class SinglyLinkedExample
{
  public static void main (String [ ] args) 
  {
    new SinglyLinkedExample().run();
  } // method main

  public void run()
  {
         final double SENTINEL = -1.0;

         final String INPUT_PROMPT = 
           "\nPlease enter a GPA (or " + SENTINEL + " to quit): ";        
         
         final String AVERAGE_MESSAGE = "\n\nThe average GPA is ";
         
         final String NO_VALID_INPUT = 
           "\n\nError: there were no valid grade-point-averages in the input.";

         SinglyLinkedList<Double> gpaList = new SinglyLinkedList<Double>();

         Scanner sc = new Scanner (System.in);

         double oneGPA,
                sum = 0.0;

         while (true)
         {
           try
           {
              System.out.print (INPUT_PROMPT);
              oneGPA = sc.nextDouble();
             if (oneGPA == SENTINEL)
                   break;
              gpaList.addToFront (oneGPA);
           } // try
           catch (Exception e)
           {
             System.out.println (e);
             sc.nextLine();
           } // catch
         } // while         
         for (Double gpa : gpaList)
           sum += gpa;
         if (gpaList.size() > 0)
           System.out.println(AVERAGE_MESSAGE + (sum/gpaList.size ()));
         else
           System.out.println (NO_VALID_INPUT);
  }  // method run

} // class SinglyLinkedExample
