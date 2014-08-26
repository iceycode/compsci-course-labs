package chapter04.Collections;

import java.util.*;

public class EnhancedFor
{
  public static void main (String [ ] args)
  {
    new EnhancedFor().run();
  } // method main

  public void run()
  {
    final double MIN_GPA = 0.0,
                 MAX_GPA = 4.0,
                 SENTINEL = -1.0;
    
    final String INPUT_PROMPT = "Please enter a GPA in the range" +
                                " from " + MIN_GPA + " to " + MAX_GPA + ", inclusive (or " +
                                SENTINEL + " to quit): ";
    
    final String RANGE_ERROR = "The grade point average must" +
                               " be at least " + MIN_GPA + " and at most " + MAX_GPA + ".";
    
    final String MESSAGE = "\n\nThe mean GPA is ";
    
    final String NO_VALID_INPUT = "\n\nError: there were no valid " +
                                  "grade-point-averages in the input.";
    
    ArrayList<Double> gpaList = new ArrayList<Double>();
    
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
        if (oneGPA < MIN_GPA | oneGPA > MAX_GPA)
          throw new ArithmeticException (RANGE_ERROR);
        gpaList.add (oneGPA); // inserts at end of gpaList
      } // try
      catch (Exception e)
      {
        System.out.println (e + "\n");
        sc.nextLine();
      } // catch Exception
    } // while
    for (Double gpa : gpaList)
      sum += gpa;
    if (gpaList.size() > 0)
      System.out.println (MESSAGE + (sum / gpaList.size()));
    else
      System.out.println(NO_VALID_INPUT);
  } // method run
} // class EnhancedFor