package lab09;

import org.junit.*;

import static org.junit.Assert.*;

import org.junit.runner.Result;

import static org.junit.runner.JUnitCore.runClasses;

import java.util.*;

public class BinarySearchTreeTest extends BinarySearchTree
{
    public static void main(String[ ] args)
    {  
        Result result = runClasses (BinarySearchTreeTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main

    protected BinarySearchTree<String> tree;  
    protected BinarySearchTreeArray<String> atree ;
                       
    @Before    
    public void RunBeforeEachTest()
    {
        tree = new BinarySearchTree<String>();    
        atree = new BinarySearchTreeArray<String>();
    } // method RunBeforeEachTest     
                 
    @Test
    public void testDefaultConstructor() 
    {                                                      
        assertEquals (0, tree.size()); 
        assertEquals ("[]", tree.toString());       
    } // method testDefaultConstructor
    
    @Test
    public void testCopyConstructor1() 
    {                                                              
        tree.add ("b"); 
        tree.add ("a");
        tree.add ("c");
        BinarySearchTree<String> newTree = new BinarySearchTree<String> (tree);            
        assertEquals (tree, newTree);         
    } // method testCopyConstructor1        
        
    @Test
    public void testEqualsNull()
    {
        assertEquals (false, tree.equals (null));
    } // method testEqualsNull
    
    @Test
    public void testEquals1()                               
    {
       tree.add ("b");
       tree.add ("a");
       tree.add ("c");
       BinarySearchTree<String> newTree = new BinarySearchTree<String>();
       newTree.add ("b");
       newTree.add ("c");
       newTree.add ("a");       
       assertEquals (true, tree.equals (newTree));
    } // method testEquals1
    
    @Test
    public void testEquals2()                               
    {
       tree.add ("b");
       tree.add ("a");
       tree.add ("c");
       BinarySearchTree<String> newTree = new BinarySearchTree<String>();
       newTree.add ("a");
       newTree.add ("c");
       newTree.add ("b");       
       assertEquals (false, tree.equals (newTree));
    } // method testEquals2
       
    @Test (expected = ClassCastException.class)
    public void testAddMismatch()
    {        
            Object obj = new Integer (7); 
            tree.add ((String)obj);              
    } // method testAddMismatch  
    
    @Test (expected = NullPointerException.class)
    public void testAddNull()
    {                      
            tree.add (null);              
    } // method testAddNull  
     
    @Test
    public void testAdd()
    {                      
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            tree.add ("e");
            tree.add ("c");
            tree.add ("d");           
            assertEquals ("[a, b, c, d, e]", tree.toString());        
    } // method testAdd    
    
    @Test (expected = NullPointerException.class)
    public void testContainsNull()
    {                   
            tree.contains (null);                
    } // method testContainsNull
    
    @Test (expected = ClassCastException.class)
    public void testContainsMismatch()
    {        
            Object obj = new Integer (7); 
            tree.contains ((String)obj);              
    } // method testContainsMismatch  
    
    @Test
    public void testContains()
    {                         
            tree.add ("a");
            tree.add ("b"); 
            tree.add ("c"); 
            assertEquals (true, tree.contains ("a")); 
            assertEquals (true, tree.contains ("b")); 
            assertEquals (true, tree.contains ("c")); 
            assertEquals (false, tree.contains ("x"));
            assertEquals (false, tree.contains (""));                
    } // method testContains        
    
    @Test (expected = NullPointerException.class)
    public void testRemoveNull()
    {                                     
            tree.remove (null);                
    } // method testRemoveNull
    
    @Test (expected = ClassCastException.class)
    public void testRemoveMismatch()
    {        
            Object obj = new Integer (7); 
            tree.remove ((String)obj);              
    } // method testAddRemoveMismatch  
    
    @Test
    public void testRemove()
    {                            
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            assertEquals (true, tree.remove ("b"));
            assertEquals (2, tree.size());
            assertEquals (false, tree.remove ("b"));
            assertEquals (2, tree.size());                             
    } // method testRemove
    
    @Test
    public void testIteratorConstructor()
    {       
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            Iterator<String> itr = tree.iterator();
            assertEquals ("a", itr.next());           
    } // method testIteratorConstructor
    
    @Test
    public void testIteratorHasNext()
    {        
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            Iterator<String> itr = tree.iterator();
            assertEquals ("a", itr.next());
            assertEquals ("b", itr.next());
            assertEquals (true, itr.hasNext());
            assertEquals ("c", itr.next());
            assertEquals (false, itr.hasNext());            
    } // method testIteratorHasNext
    
    @Test (expected = NoSuchElementException.class)
    public void testIteratorNextFail()
    {       
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            Iterator<String> itr = tree.iterator();
            assertEquals ("a", itr.next());
            assertEquals ("b", itr.next());
            assertEquals (true, itr.hasNext());
            assertEquals ("c", itr.next());
            assertEquals (false, itr.hasNext());
            itr.next();                  
    } // method testIteratorNextFail            
    
    //*********Lab 15, Hypothesis Q1*********
    //height() method tests 
    @Test
    public void testHeightOnlyRoot(){
    	//check instances where height will be 0
    	assertEquals(tree.height(), 0);
    	tree.add("a"); //adding to root (height still 0)
    	assertEquals(tree.height(), 0 );
    	
    }
    
    @Test
    public void testHeightAddNodesLeft(){
    	tree.add("a");
    	tree.add("b"); //adding as child of 'a'
    	tree.add("c"); //add as child of 'b'
    	assertEquals(tree.height(), 2); //height is now 2
    	
    	//testing height of 3
    	tree.add("d"); //add as child of 'c'
    	assertEquals(tree.height(), 3); //height now 3
    	
    	//testing height will equal 2 after adding 3 more entries to left
    	tree.add("e"); 
    	tree.add("f");
    	tree.add("g");
    	assertEquals(tree.height(),6); //last
    	
    	tree.add("h");
    	assertEquals(tree.height(),7);
    	

    }//test height adding nodes
    
    @Test
    public void testHeightAddNodesRight(){
    	tree.add("g");
    	tree.add("f");
    	tree.add("e");
    	assertEquals(tree.height(),2);
    	
    	//testing height of 3
    	tree.add("d"); //height now 3, d is right
    	assertEquals(tree.height(), 3);
    	
    	tree.add("c");
    	tree.add("b");  
    	tree.add("a");  
    	assertEquals(tree.height(),6); //last
    }//test adding notes only to right
    
    @Test
    public void testHeightFullTree(){
    	
    	BinarySearchTree<Integer> treeInt = new BinarySearchTree<Integer>();
    	
    	treeInt.add(31);
    	treeInt.add(5);
    	treeInt.add(44);
    	
    	assertEquals(treeInt.height(), 1);
    	
    	tree.add("deer");
    	tree.add("bar"); //adding as child to left
    	tree.add("jar"); //add as child to right 
    	assertEquals(tree.height(), 1); //height is now 1
    } //tests height of full tree
    
    @Test
    public void testHeightCompleteTree(){
    	tree.add("deer");
    	tree.add("bar"); //adding as child to left
    	tree.add("jar"); //add as child to right 
    	tree.add("apple"); //adding to right side of right node
    	assertEquals(tree.height(), 2); 
    }//tests complete tree (not all parents have 2 children)

    /******************TESTS FOR AVLTree.java class*****************
     * - tests recursive add & balancing of trees
     */
    
} // class BinarySearchTreeTest
