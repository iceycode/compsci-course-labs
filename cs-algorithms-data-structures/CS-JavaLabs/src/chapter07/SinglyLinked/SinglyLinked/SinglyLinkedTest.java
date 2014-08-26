package chapter07.SinglyLinked.SinglyLinked;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;

import java.util.*;

public class SinglyLinkedTest 
{
    public static void main(String[ ] args)
    {  
        Result result = runClasses (SinglyLinkedTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main

    protected SinglyLinkedList<String> list; 
    
    @Before
    public void runBeforeEachTest()
    {
       list = new SinglyLinkedList<String>();
    } // method runBeforeEachTest
               
    @Test
    public void testSize1()
    {                                
       assertEquals (0, list.size());                                   
    } // method testSize1
    
    
    @Test
    public void testAdd()
    {        
        list.addToFront ("Greg");
        list.addToFront ("Brian");
        list.addToFront ("Berkin");        
        assertEquals ("[Berkin, Brian, Greg]", list.toString());
    } // testAdd
    
     @Test
    public void testSize2()
    {        
        list.addToFront ("Greg");
        list.addToFront ("Brian");
        list.addToFront ("Berkin");        
        assertEquals (3, list.size());
    } // testSize2
     
     @Test
    public void testContains1()
    {        
        list.addToFront ("Greg");
        list.addToFront ("Brian");
        list.addToFront ("Berkin");        
        assertEquals (true, list.contains("Brian"));
    } // testContains1
     
    @Test
    public void testContains2()
    {        
        list.addToFront ("Greg");
        list.addToFront ("Brian");
        list.addToFront ("Berkin");        
        assertEquals (false, list.contains("Jack"));
    } // testContains2
    
    @Test
    public void testContains3()
    {        
        list.addToFront ("Greg");
        list.addToFront ("Brian");
        list.addToFront ("Berkin");        
        assertEquals (false, list.contains(7));
    } // testContains2
           
} // class SinglyLinkedTest
