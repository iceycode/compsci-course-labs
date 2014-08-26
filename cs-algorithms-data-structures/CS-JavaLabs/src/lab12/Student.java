package lab12;

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


public class Student<E> implements Comparable<E>{
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

	@Override
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		return 0;
	}


} // class Student
