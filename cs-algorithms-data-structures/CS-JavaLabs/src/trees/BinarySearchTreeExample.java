package trees;

public class BinarySearchTreeExample
{
  public static void main (String[ ] args)
  {
    new BinarySearchTreeExample().run();
  } // method main
  
  public void run()
  {
    BinarySearchTree<String> tree1 = new BinarySearchTree<String>();
    
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
    System.out.println (tree3);
  } // method run
  
} // class BinarySearchTreeExample
