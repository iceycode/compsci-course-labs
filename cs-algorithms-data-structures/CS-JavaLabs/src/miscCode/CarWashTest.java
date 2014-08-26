import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;

public class CarWashTest extends CarWash
{
    public static void main(String[ ] args)
    {
        Result result = runClasses (CarWashTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main
    
    protected CarWash carWash;  
    
    protected LinkedList<String> results;
                       
    @Before
    public void runBeforeEachTest()
    {
        carWash = new CarWash();
    } // method runBeforeEachTest
     
     @Test
    public void processOneArrivalTest()
    {       
        results = carWash.processArrival (5); 
        assertTrue (results.indexOf ("5\tArrival") != -1); 
    } // method firstProcessArrivalTest        
     
    @Test
    public void processTwoArrivalsTest()
    {
        carWash.processArrival (5);
        results = carWash.processArrival (7);
        assertTrue (results.indexOf ("5\tArrival") != -1);
        assertTrue (results.indexOf ("7\tArrival") > results.indexOf ("5\tArrival"));
    } // method twoProcessTwoArrivalsTest
       
    @Test (expected = IllegalArgumentException.class)
    public void priorArrivalTest()
    {
        carWash.process (5);
        results = carWash.process (3);        
    } // method priorArrivalTest
       
    @Test
    public void arrivalOverflowTest()
    {  
        carWash.processArrival (5);
        carWash.processArrival (7);
        carWash.processArrival (8);
        carWash.processArrival (12);
        carWash.processArrival (12);          
        assertTrue (carWash.processArrival (13).toString().
                    indexOf (CarWash.OVERFLOW) == -1); // no overflow for arrival at 13       
        assertTrue (carWash.processArrival (14).toString().
                    indexOf (CarWash.OVERFLOW) > 0);   // overflow for arrival at 14 
    } // method arrivalOverflowTest
    
    @Test
    public void overflowTest()
    {  
        carWash.process (5);
        carWash.process (7);
        carWash.process (8);
        carWash.process (12);
        carWash.process (12);          
        assertTrue (carWash.process (13).toString().
                    indexOf (CarWash.OVERFLOW) == -1); // no overflow for arrival at 13       
        assertTrue (carWash.process (14).toString().
                    indexOf (CarWash.OVERFLOW) > 0);   // overflow for arrival at 14 
    } // method overflowTest
    
    @Test
    public void departureTest()
    {   
        carWash.process (5);
        carWash.process (7);
        carWash.process (8);
        carWash.process (12);
        carWash.process (12);
        carWash.process (13);        
        results = carWash.process (15);  
        assertTrue (results.indexOf ("15\tDeparture\t\t0\n") != -1);
    } // method departureTest
            
} // class CarWashTest
