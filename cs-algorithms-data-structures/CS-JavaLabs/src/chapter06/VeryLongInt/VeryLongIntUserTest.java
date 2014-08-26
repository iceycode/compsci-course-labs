package chapter06.VeryLongInt;


import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;
import java.io.*;

public class VeryLongIntUserTest
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (VeryLongIntUserTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main
    
    protected VeryLongIntUser user;  
        
    protected String answer;
               
    @Before
    public void runBeforeEachTest()
    {
        user = new VeryLongIntUser();
    } // method runBeforeEachTest

 
    @Test
    public void testProcessConstructor() 
    {              
        answer = user.process ("VeryLongInt 100", new VeryLongInt("0")).toString();
        assertEquals (answer, "[1, 0, 0]");
    } // method testProcessConstructor


    @Test (expected = NoSuchElementException.class)    
    public void testProcessConstructorEmpty()
    {        
            user.process ("VeryLongInt", new VeryLongInt ("999"));              
    } // method testProcessConstructorEmpty


    @Test    
    public void testProcessAdd()
    {        
        VeryLongInt veryLong = user.process ("VeryLongInt 999", new VeryLongInt("0"));
        veryLong = user.process ("add 1234", veryLong);
        answer = user.process ("add 55555", veryLong).toString();
        assertEquals (answer, "[5, 7, 7, 8, 8]");
    } // method tesProcesstAdd

    
    @Test (expected = IllegalArgumentException.class)    
    public void testProcessBad()
    {        
        user.process ("subtract 100", new VeryLongInt ("500"));         
    } // method testProcessBad


    @Test (expected = IllegalArgumentException.class)        
    public void testProcessAddNoDigits()
    {        
        user.process ("add xyz", new VeryLongInt ("500"));         
    } // method testProcessAddNoDigits


    @Test (expected = NoSuchElementException.class)            
    public void testProcessAddEmpty()
    {        
        user.process ("add", new VeryLongInt ("123"));
    } // method testProcessAddEmpty       


    @Test (expected = NoSuchElementException.class)            
    public void testProcessLineEmpty()
    {        
        user.process ("", new VeryLongInt ("123"));
    } // method testProcessLineEmpty      

    
    @Test (expected = NullPointerException.class)            
    public void testProcessNullLine()
    {        
        user.process (null, new VeryLongInt ("123"));
    } // method testProcessNullLine    

    
    @Test (expected = NullPointerException.class)            
    public void testProcessAddNullVeryLongInt()
    {        
        user.process ("add 100", null);
    } // method testProcessAddNullVeryLongInt
    
} // class VeryLongIntUserTest
