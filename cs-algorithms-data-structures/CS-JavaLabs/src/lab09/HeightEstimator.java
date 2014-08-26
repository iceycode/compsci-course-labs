package lab09;

import java.util.*;

public class HeightEstimator
{  
  public static void main (String[] args)
  {
    new HeightEstimator().run();
  } // method main 

  
   public void run() 
   {  
     final String PROMPT = "\nPlease enter the number of " + 
       "elements to be inserted for the first trial: ";
  
     final String SIZE_MESSAGE = "The tree size is ";
    
     final String RATIO_MESSAGE =
         "  The ratio of the average height to the log, " +
         "base 2, of the tree size is ";
    
     final int SIZES = 5;
    
     final int TRIALS_PER_SIZE = 20;
  
     BinarySearchTree<Double> myTree = new BinarySearchTree<Double>();

     Random rand = new Random();
    
     Scanner sc = new Scanner (System.in);
    
     int n,
         totalHeight;

     double averageHeight;
    
     while (true)
     {
       try
       {
          System.out.print (PROMPT);
          n = sc.nextInt();
    
          for (int i = 1; i <= SIZES; i++) 
          {  
              totalHeight = 0;
              for (int j = 0; j < TRIALS_PER_SIZE; j++) 
              {
            	//new tree created after trial
        		  BinarySearchTree<Double> tree = new BinarySearchTree<Double>();
        		  
        		  for (int k = 0; k < n; k++){
        			  
        			  Double d = Math.random();
        			  
        			  if (!tree.contains(d)){  
        				  tree.add(d);
        			  }//adds if d hasn't been added
        			  else{
        				  n++; //increase n by 1, since have to make up for 1 not added
        			  }
        		  } //10 double elements added to tree
        		  
        		  int height = tree.height(); //get height
        		  
        		  totalHeight = totalHeight + height; //calcs total height
              } // for each trial
              System.out.println (SIZE_MESSAGE + n);
              averageHeight = (double)totalHeight / TRIALS_PER_SIZE;
              
              double ratio = averageHeight/(Math.log(n)/ Math.log (2));
              
              System.out.println (RATIO_MESSAGE + ratio);  
              System.out.println("     The average height is " + averageHeight);
              n *= 2;
          } // for each size
          break;
       }//try
       catch (InputMismatchException e)
       {
          System.out.println (e);
          sc.nextLine();
       }//catch InputMismatchException       
     } // while
   } // method run
  
} // class HeightEstimator
