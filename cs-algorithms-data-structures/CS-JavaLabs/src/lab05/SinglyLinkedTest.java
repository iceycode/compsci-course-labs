package lab05;

import junit.framework.*;

import java.util.*;


public class SinglyLinkedTest extends TestCase 
{        
    protected SinglyLinkedList<String> list;  
    protected Iterator<String> itr = list.iterator();
    protected String answer;
               
    public static Test suite() 
    {  
        return new TestSuite(SinglyLinkedTest.class);
    } // method suite

 
    public void testNoConstructor() 
    {              
        try
        {            
            list.size();                    
            fail ();
        } // try
        catch (NullPointerException e)            
        {
        } // catch NullPointerException
        catch (Exception e)
        {
            fail ();
        } // catch any Exception other than NullPointerException
    } // method testNoConstructor
    
    public void testEmpty()
    {        
        try
        {
            list = new SinglyLinkedList<String>();
            assertEquals (0, list.size()); 
            assertEquals (true, list.isEmpty());    
            assertEquals (false, list.contains (null));                
        } // try
        catch (Exception e)
        {
            fail (e.toString());
        } // catch
    } // method testEmpty
    
    public void testAddToFront()
    {        
        try
        {
            list = new SinglyLinkedList<String>();
            list.addToFront ("serene");
            assertEquals (true, list.contains ("serene"));
            assertEquals (false, list.contains ("Serene"));
            assertEquals (1, list.size());
            assertEquals (false, list.isEmpty());           
        } // try        
        catch (Exception e)
        {
            fail ();
        } // catch Exception 
    } // method testAddToFront
    
    @SuppressWarnings("unchecked")
	public void testAdds()
    {   
        try
        {
            list = new SinglyLinkedList<String>();
            list.addToFront ("serene");
            list.addToFront ("halycon");
            list.addToFront ("mellow");
            list.addToFront ("halycon");
            assertEquals (true, list.contains ("halycon"));
            assertEquals (true, list.contains ("serene"));
            assertEquals (true, list.contains ("mellow"));
            assertEquals (false, list.contains (""));
            assertEquals (4, list.size());
            assertEquals (false, list.isEmpty());           
            
            //--------------------------addAll tests--------------------------------------------
            //Collection & list variables to test addAll with
            ArrayList<String> aList;
            SinglyLinkedList<String> aList2;
            
            aList = new ArrayList<String>();
            
            aList.add("something");
            aList.add("another thing");
            
            list.addAll(aList); //adds all element of aList to list
            
            //tests to see if addAll working
            assertEquals(true, list.contains("something"));
            assertEquals(true, list.contains("another thing"));
            
            //this tests to make sure last element added in aList is first
            Iterator<String> itr = list.iterator();
            assertEquals(itr.next(), "another thing");
            
            //testing to see if addAll method returns false if unchanged
            aList2 = new SinglyLinkedList<String>();
            assertEquals(false, list.addAll(aList2));
            //----------------------------------------------------------------------

        } // try        
        catch (Exception e)
        {
            fail ();
        } // catch Exception 
    } // method testAdds - tests addAll method
    
    public void testNull()
    {        
        try
        {            
            list = new SinglyLinkedList<String>(); 
            list.addToFront (null);
            assertEquals (true, list.contains (null));
        } // try        
        catch (Exception e)
        {
            fail ();
        } // catch Exception 
    } // method testNull
   
    public void testIterator()
    {        
        try
        {
            list = new SinglyLinkedList<String>();
            int frequency = 0;
            list.addToFront ("true");
            list.addToFront ("false");
            list.addToFront ("yes");
            list.addToFront ("true");
            list.addToFront ("even");
            list.addToFront ("halycon");
            Iterator<String> itr = list.iterator();
            while (itr.hasNext())
                if (itr.next().length() == 4)
                    frequency++;
            assertEquals (3, frequency);
        } // try
        catch (Exception e)
        {
            fail (e.toString());
        } // catch
    } // method testIterator       
        
    public void testHasNextTrue()
    {        
        try
        {
            list = new SinglyLinkedList<String>();                        
            list.addToFront ("yes");            
            list.addToFront ("even");
            list.addToFront ("halycon");
            Iterator<String> itr = list.iterator();
            if (itr.hasNext())
                ;
            else
                fail();            
        } // try
        catch (Exception e)
        {
            fail (e.toString());
        } // catch
    } // method testHasNextTrue
    
    public void testHasNextFalse()
    {        
        try
        {
            list = new SinglyLinkedList<String>();
            int frequency = 0;            
            list.addToFront ("yes");           
            list.addToFront ("even");
            list.addToFront ("halycon");
            Iterator<String> itr = list.iterator();
            itr.next();
            itr.next();
            itr.next();
            if (itr.hasNext())
                fail();            
        } // try
        catch (Exception e)
        {
            fail (e.toString());
        } // catch
    } // method testHasNextFalse
    
    public void testNextOK()
    {        
        try
        {
            list = new SinglyLinkedList<String>();
            int frequency = 0;            
            list.addToFront ("yes");           
            list.addToFront ("even");
            list.addToFront ("halycon");
            Iterator<String> itr = list.iterator();
            itr.next();
            itr.next();
            assertEquals ("yes", itr.next());                     
        } // try
        catch (Exception e)
        {
            fail (e.toString());
        } // catch
    } // method testNextOK
    
    public void testNoNext()
    {        
        try
        {
            list = new SinglyLinkedList<String>();
            int frequency = 0;            
            list.addToFront ("yes");           
            list.addToFront ("even");
            list.addToFront ("halycon");
            Iterator<String> itr = list.iterator();
            itr.next();
            itr.next();
            itr.next();
            itr.next();
            fail();
        } // try
        catch (NullPointerException e)
        {            
        } // catch NullPointerException
        catch (Exception e)
        {
            fail (e.toString());
        } // catch any exception other than NullPointerException
    } // method testNoNext
    
    
    public static void main (String[ ] args) {
        junit.textui.TestRunner.run(suite());
    } // method main

    
} // class SinglyLinkedTest
