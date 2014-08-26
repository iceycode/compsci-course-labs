package chapter06.VeryLongInt;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;

public class VeryLongIntTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (VeryLongIntTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main

    protected VeryLongInt very;  
        
    protected String answer;

    @Test (expected = NullPointerException.class)
    public void testConstructorNull() 
    {              
        new VeryLongInt (null);                    
    } // method testConstructorNull

    @Test    
    public void testToStringBoth()
    {        
            very = new VeryLongInt ("11w223344556677889900");
            answer = very.toString();               
            assertEquals ("[1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 0, 0]", answer);
    } // method testToStringBoth

    @Test (expected = IllegalArgumentException.class)    
    public void testToStringEmpty()
    {        
        very = new VeryLongInt ("");           
    } // method testToEmpty
    

    @Test (expected = IllegalArgumentException.class)    
    public void testToStringNoDigits()
    {        
            very = new VeryLongInt ("x t?.o");           
    } // method testToStringNoDigits

    @Test    
    public void testAdd()
    {        
        very = new VeryLongInt ("99");
        VeryLongInt other = new VeryLongInt ("123");
        very.add (other);
        answer = very.toString();               
        assertEquals ("[2, 2, 2]", answer);
    } // method testAdd

    @Test   
    public void testAdd0()
    {        
            very = new VeryLongInt ("99");
            VeryLongInt other = new VeryLongInt ("0");
            very.add (other);
            answer = very.toString();               
            assertEquals ("[9, 9]", answer);
    } // method testAdd0

    @Test (expected = NullPointerException.class)    
    public void testAddNull()
    {        
        very = new VeryLongInt ("99");            
        very.add (null);
    } // method testAddNull        
                
} // class VeryLongIntTest
