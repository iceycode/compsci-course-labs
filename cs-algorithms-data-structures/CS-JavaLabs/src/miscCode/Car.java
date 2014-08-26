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

} // class Car
