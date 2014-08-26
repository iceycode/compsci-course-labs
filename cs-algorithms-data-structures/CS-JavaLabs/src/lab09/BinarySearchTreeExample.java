package lab09;

import java.util.Random;

import lab09.BinarySearchTree.TreeIterator;

public class BinarySearchTreeExample
{
  public static void main (String[ ] args)
  {
    new BinarySearchTreeExample().run();
  } // method main
  
  public void run()
  {
   /* BinarySearchTree<String> tree1 = new BinarySearchTree<String>();
    
    tree1.add ("yes");
    tree1.add ("no");
    tree1.add ("maybe");
    tree1.add ("always");
    tree1.add ("no"); // not added: duplicate element
    if (tree1.remove ("often"))
      System.out.println ("How did that happen?");
    else
      System.out.println (tree1.remove ("maybe"));
    System.out.println (tree1);
    
    BinarySearchTree<String> tree2 = new BinarySearchTree<String> (tree1);
    System.out.println (tree2);
    
    BinarySearchTree<Student> tree3 = new BinarySearchTree<Student>();
    tree3.add (new Student ("Jones", 3.17));
    tree3.add (new Student ("Smith", 3.82));
    tree3.add (new Student ("Jones", 3.4));                 
    if (tree3.contains (new Student ("Jones", 10.0 - 6.6)))
     System.out.println ("The number of elements in tree3 is " + tree3.size());
    System.out.println (tree3);*/
	  
	randomTrials();
  } // method run
  
  /* 20 trials of size, n, random Double objects
   * - size = n
   * - compare average height of each BST in each trial to log2n
   * Random int to suggest how many double elements added
   * Random double for random double objects
   * n = 10 in this case
   */
  public void randomTrials(){
	  int n = 10;
	  double d = 0;
	  int total = 0; //totals of height
	  double average = 0; //average height 
	  double ratio = 0; //ratio of height to log2n
	  
	   //Math.log (n) / Math.log (2); - code for log2n
	  for (int i = 0; i < 20; i++){
		  
		  //new tree created
		  BinarySearchTree<Double> tree = new BinarySearchTree<Double>();
		  
		  for (int j = 0;j < n; j++){
			  
			  d = Math.random();
			  
			  if (!tree.contains(d)){  
				  tree.add(d);
			  }//adds if d hasn't been added
			  else{
				  n++; //increase n by 1, since have to make up for 1 not added
			  }
		  } //10 double elements added to tree
		  
		  int height = tree.height(); //get height
		  
		  total = total + height; //calcs total height
		  
	  }//20 trials
	  
	  average = ((double) total)/20 ; //average of heights
	  
	  ratio = average/(Math.log(n)/ Math.log (2));
	  
	  System.out.println("The ratio of average height of log, base 2, of n is: "+ ratio);
	  
  }//20 trials
	    
} // class BinarySearchTreeExample
