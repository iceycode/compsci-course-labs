package lab10;

import java.util.*;

/** Student.java class
 *  
 * @author from Collins W. Data Structures lab 21
 *
 */


public class Student implements Comparable<Student> 
{
    protected String name;

    protected double gpa;

    /**
     *  Initializes this Student object from a specified String object.
     *
     *  @param s - the String object used to initialize this Student object.
     *
     */     
    public Student (String s) 
    {
        Scanner sc = new Scanner (s);
        
        name = sc.next();
        gpa = sc.nextDouble();
    } // constructor
    
    
    /**
     *  Compares this Student object to a specified object by grade point 
     *  average.
     *
     *  @param obj - the specified object.
     *
     *  @return a negative integer, 0, or a positive integer, depending
     *  on whether this Student object’s grade point average is less than,
     *  equal to, or greater than obj’s grade point average.
     * 
     *  @throws ClassCastException - if the run-time type of obj is not Student.
     *
      */                         
    public int compareTo (Student otherStudent) 
    {
        if (gpa < otherStudent.gpa)
             return -1;
        if (gpa == otherStudent.gpa)
             return 0;
        return 1;
    } // method compareTo

    
    /**
     *  Returns a String representation of this Student object.
     *
     *  @return  a String representation of this Student object: name “ “ gpa
     *
     */
    public String toString() 
    {
        return name + "  " + gpa;
    } // method toString

} // class Student
