package lab11;

import java.util.*;

/**
 * Student.java class - puts student into a linked list
 * 
 * @author from Collins W. Data Structures lab 21
 * 
 * Format of students.dat
 *         last name (including comma) followed by one space, first name
 *         followed by one space, middle name followed by one space and an ID
 *         (integer) followed by a new line.
 * @param <E>
 * 
 */


public class Student<E>
{
    protected String nameFirst;
	protected String nameMiddle;
    protected String nameLast;
    protected String id;
    
    protected Student<E>[] sArray;
    
    public Student (){
    	
    }// default constructor

    /**
     *  Initializes this Student object from a specified String object.
     *
     *  @param s - the String object used to initialize this Student object.
     *
     */     
    public Student (String s)  {
        Scanner sc = new Scanner(s);
        //sc.useDelimiter(",");
        
        nameLast = sc.next();
        nameFirst = sc.next();
        nameMiddle = sc.next();
        id = sc.next();
        
    } // constructor
    
     
//    /**   IN THE StudentComparator class
//     *  Compares this Student object to a specified object by name or ID.
//     *
//     *  @param obj - the specified object.
//     *
//     *  @return a negative integer, 0, or a positive integer, depending
//     *  on whether this Student's name(s) comes before or after next one
//     *  checks ID number if names (first, last & middle) are all equal
//     * 
//     *  @throws ClassCastException - if the run-time type of obj is not Student.
//     *
//      */                         
//    public int compareTo (Student student1) throws ClassCastException
//    {
//    	//initialize comparison value for last name
//    	int compValue = nameLast.compareTo(student1.nameLast);
//    	
//        if (compValue == 0){
//        	compValue = nameFirst.compareTo(student1.nameFirst);
//        	if (compValue == 0){
//        		compValue = nameMiddle.compareTo(student1.nameMiddle);
//        		if (compValue == 0){
//        			compValue = id.compareTo(student1.id);
//        			if (compValue == 1)
//        				return 1;
//        			else 
//        				return -1;
//        		}//lastly even if middle names match
//        	}//if first name match
//        } //if last last name is same
//        return compValue; //return value whether in front or behind
//        
//    } // method compareTo

    /**
     *  Returns a String representation of this Student object.
     *
     *  @return  a String representation of this Student object: name “ “ gpa
     *
     */
    public String toString() 
    {
        return nameLast + " "+ nameFirst + " "+ nameMiddle + " "+ id;
    } // method toString

    
    //-------------GETTERS & SETTERS--------------
    public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}
    public String getNameFirst() {
		return nameFirst;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getNameMiddle() {
		return nameMiddle;
	}

	public void setNameMiddle(String nameMiddle) {
		this.nameMiddle = nameMiddle;
	}


	public String getNameLast() {
		return nameLast;
	}


	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}


	public String getId() {
		return id;
	}


} // class Student
