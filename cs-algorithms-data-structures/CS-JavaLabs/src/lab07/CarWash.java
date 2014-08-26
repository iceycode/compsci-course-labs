package lab07;

/** CarWash.java
 * overflow means that over 5 cars in the queue
 * 
 * Calculating random arrival times from mean arrival times
 *  --> based on Poisson distribution probability 
 *  --> need to find the timeTillNext variable b/w arrival times
 *  --> Probability P(timeTillNext) = exp(-timeTillNext/meanArrivalTime)
 *  --> 0 <= Prob <= 1.0 <==> 1 - randDouble //randDouble gives value b/w 0.0 & 1.0
 *  --> set 1-randDouble = exp(-timeTillNext/meanArrivalTime) 
 *   -->take log--> multiply by -meanArrivalTime
 *   --> timeTillNext = -meanArrivalTime * log(1-randDouble)
 *   -NOTE: set seed for random number generator to 100 --> new Random(100)
 *   
 * Calculating average queue length:
 * --> meanQueueLength = sumOfWaitingTimes/totalTime
 */


import java.util.*;

public class CarWash
{
     public final static String OVERFLOW = " (Overflow)\n";
     
     public final static String HEADING =
          "\n\nTime\tEvent\t\tWaiting Time\n";

     public final static int INFINITY = 10000; // indicates no car being washed

     public final static int MAX_SIZE = 5; // maximum cars allowed in carQueue
     
     
          
     protected Queue<Car> carQueue;  

     protected LinkedList<String> results;  // the sequence of events in the simulation

     protected double randomDouble;   //randomDouble used to obtain nextArrivalTime
     
     protected int  currentTime,
     				maxArrivalTime, //maxArrivalTime
     				washTime,			//wash time now varies
                    nextDepartureTime,    // when car being washed will finish
                    numberOfCars,
                    overflowCount, //keeps track of overflows
                    waitingTime,
                    sumOfWaitingTimes, //used to calculate meanWaitingTime
                    meanServiceTime, //mean service time
     				totalTime;		//total time of simulation
     
     protected int nextArrivalTime;
     
     protected Random rand = new Random(100); //set seed to 100
     
     
     protected double randDouble = rand.nextDouble(); //rand num used with timeTillNext

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
         totalTime = 0;
         numberOfCars = 0;
         overflowCount = 0;
         waitingTime = 0;
         meanServiceTime = 0;
         sumOfWaitingTimes = 0;
         nextDepartureTime = INFINITY;   // no car being washed
     } // constructor

    /**
     *  Handles all events from the current time up through the specified 
     *  time for the next arrival.
     *
     *  @param meanArrivalTime - the mean arrival time
     *  
     *  @param maxArrival - the maximum arrival time
     *
     *  @throws IllegalArgumentException - if nextArrivalTime is less than 
     *                                     the current time.
     *
     */
     public LinkedList<String> process (int meanArrivalTime, int meanServiceTime)
     {
         //call calcNexArrivalTime
    	// calcNextArrivalTime(meanArrivalTime);
    	 //call calcServiceTime
    	 //calcWashTime(meanServiceTime);
         
         while (nextArrivalTime >= nextDepartureTime)
              processDeparture();
         
         return processArrival (nextArrivalTime);
     } // process

     /*****************************ADDED METHOD FOR CALCULATING washTime from meanServiceTime******** 
      * Gets the service time for car
      * - similar to method as nextArrivalTime
      * @param meanServiceTime
      */
     void calcWashTime(int meanServiceTime) {
    	 
    	 if (carQueue.isEmpty()){
	    	 Random rand = new Random(100);
	    	 double randomDouble = rand.nextDouble(); //get rand number between 0.0 & 1.0
	    	 
	    	 washTime = (int)Math.round(-meanServiceTime * Math.log(1-randomDouble));
    	 }
    	 else
    		 washTime = carQueue.peek().calcWashTime(meanServiceTime);
	 }

	/*****************************ADDED METHOD FOR CALCULATING nextArrivalTime from meanArrivalTime********
      * Gets nextArrivalTime from meanArrivalTime
      * 
      * @param meanArrivalTime
      * @param maxArrival
      * 
      * @return
      */
     void calcNextArrivalTime (int meanArrivalTime){
    	 double randomDouble = rand.nextDouble(); //get rand number between 0.0 & 1.0
    	 
    	 int timeTillNext = (int)Math.round(-meanArrivalTime * Math.log(1-randomDouble));
    	 nextArrivalTime = timeTillNext + nextArrivalTime;

     }//calc nextArrivalTime from meanArrivalTime
          
     /** gets nextArrivalTime
      * 
      */
     public int getNextArrivalTime(){
    	 return nextArrivalTime;
     }
     
     //gets currentTime
     public int getCurrentTime(){
    	 return currentTime;
     }
     
     void processMaxArrival(int maxArrivalTime){
    	 this.maxArrivalTime = maxArrivalTime;
     }
     
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
         if (carQueue.size() == MAX_SIZE){         
             results.add (Integer.toString (currentTime) + ARRIVAL + OVERFLOW);
             overflowCount++;
         }
         else
         {
              results.add (Integer.toString (currentTime) + ARRIVAL);
              numberOfCars++;
              if (nextDepartureTime == INFINITY)  // if no car is being washed
                  nextDepartureTime = currentTime + washTime;
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
              nextDepartureTime = currentTime + washTime;
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
     *  departures, and the average waiting time & average queue length
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
         
         final String AVERAGE_QUEUE = "\n\nThe average queue length, in cars per minute, was ";
         
         final String OVERFLOWS = "\n\nThe number of overflows was ";
         
         double meanWaitingTime = (double) sumOfWaitingTimes/numberOfCars;
         double meanQueueLength = (double) meanWaitingTime/nextArrivalTime;
         
         if (numberOfCars == 0)
              results.add (NO_CARS_MESSAGE);
         else {
              results.add (AVERAGE_WAITING_TIME_MESSAGE + Double.toString (
            		  Math.round(meanWaitingTime*10)/10.0) + 
            		  AVERAGE_QUEUE + Double.toString(Math.round(meanQueueLength*10)/10.0)+
            		  OVERFLOWS + overflowCount);
         }
         return results;
     } // method getResults

} // class CarWash
