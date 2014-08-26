package lab07;

import java.util.Random;

public class Car 
{
     protected int arrivalTime;

     /**
      *  Initializes this Car object.
      *
      */
     public Car() { }   // for the sake of subclasses of Car


     /**
      *  Initializes this Car object from the specified time of the next arrival.
      *
      */
     public Car (int nextArrivalTime)
     {
         arrivalTime = nextArrivalTime;
     } // constructor with int parameter


     /**
      *  Determines the arrival time of this Car object.
      *
      *  @return the arrival time of this Car object.
      *
      */     
     public int getArrivalTime()
     {
         return arrivalTime;
     } // method getArrivalTime
     
     /** determine wash time of car
      * 
      * @return washtime
      */
     public int calcWashTime(int meanServiceTime)    	 
     {
    	 Random rand = new Random(100);
    	 double randomDouble = rand.nextDouble(); //get rand number between 0.0 & 1.0
	 
    	 int washTime = (int)Math.round(-meanServiceTime * Math.log(1-randomDouble));
    	 return washTime;
     }

} // class Car
