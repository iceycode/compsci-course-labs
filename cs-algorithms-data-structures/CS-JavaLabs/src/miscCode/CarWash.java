package miscCode;

import java.util.*;

public class CarWash
{
     public final static String OVERFLOW = " (Overflow)\n";
     
     public final static String HEADING =
          "\n\nTime\tEvent\t\tWaiting Time\n";

     public final static int INFINITY = 10000; // indicates no car being washed

     public final static int MAX_SIZE = 5; // maximum cars allowed in carQueue

     public final static int WASH_TIME = 10; // minutes to wash one car

     protected Queue<Car> carQueue;  

     protected LinkedList<String> results;  // the sequence of events in the simulation

     protected int currentTime,
                    nextDepartureTime,    // when car being washed will finish
                    numberOfCars,
                    waitingTime,
                    sumOfWaitingTimes;

    /**
     *  Initializes this CarWash object.
     *
     */
     public CarWash()
     {
         carQueue = new LinkedList<Car>();
         results = new LinkedList<String>();
         results.add (HEADING);
         currentTime = 0;
         numberOfCars = 0;
         waitingTime = 0;
         sumOfWaitingTimes = 0;
         nextDepartureTime = INFINITY;   // no car being washed
     } // constructor

    /**
     *  Handles all events from the current time up through the specified 
     *  time for the next arrival.
     *
     *  @param nextArrivalTime - the specified time when the next arrival 
     *                           will occur.
     *
     *  @throws IllegalArgumentException - if nextArrivalTime is less than 
     *                                     the current time.
     *
     */
     public LinkedList<String> process (int nextArrivalTime)
     {
         final String BAD_TIME =
             "The time of the next arrival cannot be less than the current time.";

         if (nextArrivalTime < currentTime)
              throw new IllegalArgumentException (BAD_TIME);
         while (nextArrivalTime >= nextDepartureTime)
              processDeparture();
         return processArrival (nextArrivalTime);
     } // process


    /**
     *  Moves the just arrived car into the car wash (if there is room on 
     *  the car queue), or turns the car away (if there is no room on the 
     *  car queue).
     *
     *  @param nextArrivalTime - the arrival time of the just-arrived car.
     *
     */
     protected LinkedList<String> processArrival (int nextArrivalTime)
     {        
         final String ARRIVAL = "\tArrival";

         currentTime = nextArrivalTime;         
         if (carQueue.size() == MAX_SIZE)         
             results.add (Integer.toString (currentTime) + ARRIVAL + OVERFLOW);
         else
         {
              results.add (Integer.toString (currentTime) + ARRIVAL);
              numberOfCars++;
              if (nextDepartureTime == INFINITY)  // if no car is being washed
                  nextDepartureTime = currentTime + WASH_TIME;
              else
                  carQueue.add (new Car (nextArrivalTime));
              results.add ("\n");
         } // not an overflow
         return results;
     } // method processArrival


    /**
     *  Updates the simulation to reflect the fact that a car has finished 
     *  getting washed.
     *
     */
     protected LinkedList<String> processDeparture()
     {
         final String DEPARTURE = "\tDeparture\t\t";

         int arrivalTime;

         currentTime = nextDepartureTime;
         results.add (Integer.toString (currentTime) + DEPARTURE +
                         Integer.toString (waitingTime) + "\n");
         if (!carQueue.isEmpty())
         {
              Car car = carQueue.remove();
              arrivalTime = car.getArrivalTime();
              waitingTime = currentTime - arrivalTime;
              sumOfWaitingTimes += waitingTime;
              nextDepartureTime = currentTime + WASH_TIME;
         } // carQueue was not empty
         else
         {
              waitingTime = 0;
              nextDepartureTime = INFINITY;  // no car is being washed
         } // carQueue was empty
         return results;
     } // method processDeparture

    /**
     *  Washes all cars that are still unwashed after the final arrival.
     *
     */
     public LinkedList<String> finishUp()
     {
         while (nextDepartureTime < INFINITY)  // while there are unwashed cars
               processDeparture();
         return results;
     } // finishUp


    /**
     *  Returns the history of this CarWash object's arrivals and 
     *  departures, and the average waiting time.
     *
     *  @return the history of the simulation, including the average 
     *   waiting time.
     *
     */
     public LinkedList<String> getResults()
     {
         final String NO_CARS_MESSAGE = "There were no cars in the car wash.\n";

         final String AVERAGE_WAITING_TIME_MESSAGE =
             "\n\nThe average waiting time, in minutes, was ";

         if (numberOfCars == 0)
              results.add (NO_CARS_MESSAGE);
         else
              results.add (AVERAGE_WAITING_TIME_MESSAGE + Double.toString (
                          (double) sumOfWaitingTimes / numberOfCars));
         return results;
     } // method getResults

} // class CarWash
