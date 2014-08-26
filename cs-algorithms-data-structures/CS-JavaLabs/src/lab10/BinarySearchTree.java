package lab10;

import java.util.*;


/** Part of Programming project 10.2
 * - printing a BinarySearchTree Object
 * - method toTreeString added
 * - prints out a tree in a tabulated structure (tabs)
 *  ie   
 *  				55 [this is root] 
 *  
 *     12 [left child (p1)]						97 [right child (p2)]
 *     			30 [right child of p1]
 *     
 * NOTE about tabs
 * - amount of tabs based on height & number of tabs needed on each level
 * - lower levels means more tabs required
 * - logn number of tabs before/after each node except last (after root)
 * (also for first node on last node on last level not needing tab)
 * 
 * @author Allen Jagoda
 *
 * @param <E>
 */

public class BinarySearchTree<E> extends AbstractSet<E> 
{
    protected Entry<E> root;

    protected int size;        
    
    /**
     *  Initializes this BinarySearchTree object to be empty, to contain only elements
     *  of type E, to be ordered by the Comparable interface, and to contain no 
     *  duplicate elements.
     *
     */ 
    public BinarySearchTree()  {
        root = null;
        size = 0;  
    } // default constructor


    /**
     * Initializes this BinarySearchTree object to contain a shallow copy of
     * a specified BinarySearchTree object.
     * The worstTime(n) is O(n), where n is the number of elements in the
     * specified BinarySearchTree object.
     *
     * @param otherTree - the specified BinarySearchTree object that this
     *                BinarySearchTree object will be assigned a shallow copy of.
     *
     */
    public BinarySearchTree (BinarySearchTree<? extends E> otherTree) {
         root = copy (otherTree.root, null);
         size = otherTree.size;  
    } // copy constructor

    protected Entry<E> copy (Entry<? extends E> p, Entry<E> parent)
    {
        if (p != null)
        {
            Entry<E> q = new Entry<E> (p.element, parent);
            q.left = copy (p.left, q);
            q.right = copy (p.right, q);
            return q;
        } // if
        return null;
    } // method copy
        
    public boolean equals (Object obj) {
        if (!(obj instanceof BinarySearchTree))
            return false;
        return equals (root, ((BinarySearchTree<? extends E>)obj).root);
    } // method 1-parameter equals
    
    public boolean equals (Entry<E> p, Entry<? extends E> q)
    {
       if (p == null || q == null)
           return p == q;      
       if (!p.element.equals (q.element))
           return false;
       if (equals (p.left, q.left) && equals (p.right, q.right) )
           return true;            
       return false;     
    } // method 2-parameter equals
    
    /**
     *  Returns the size of this BinarySearchTree object.
     *
     * @return the size of this BinarySearchTree object.
     *
     */
    public int size( )
    {
        return size;
    } // method size()
  

    /**
     *  Returns an iterator positioned at the smallest element in this 
     *  BinarySearchTree object.
     *
     *  @return an iterator positioned at the smallest element in this
     *                BinarySearchTree object.
     *
     */
    public Iterator<E> iterator()
    {
         return new TreeIterator();
    } // method iterator

    /**
     *  Determines if there is at least one element in this BinarySearchTree object that
     *  equals a specified element.
     *  The worstTime(n) is O(n) and averageTime(n) is O(log n).  
     *
     *  @param obj - the element sought in this BinarySearchTree object.
     *
     *  @return true - if there is an element in this BinarySearchTree object that
     *                equals obj; otherwise, return false.
     *
     *  @throws ClassCastException - if obj cannot be compared to the 
     *           elements in this BinarySearchTree object. 
     *  @throws NullPointerException - if obj is null.
     *  
     */ 
    public boolean contains (Object obj) 
    {
        return getEntry (obj) != null;
    } // method contains

	/**
	*	Returns a String representation of this BinarySearchTree object.
	*	The worstTime(n) is linear in n.
	*
	*	@return a String representation – that incorporates the structure–of this
	*	BinarySearchTree object.
	*
	*/
	public String toTreeString(){
		String treeString = "";

		for (int i = 0; i <= height() ; i++){
			String tabs = "\t"; //for adding spacing b/w nodes
			for (int j = i; j <= height(); j++){
				 tabs += tabs;
			}
			

			treeString +=  tabs + lvlString_r(root, i) +"\n";

		}
		//inorder_p(root);
		return treeString;
		
	}
	/** recursive String method 

	 * gets nodes on one level recursively
	 * also adds appropriate spaces on each level
	 * 
	 * @param e
	 * @param height() or level
	 * @return
	 */
	public String lvlString_r(Entry<E> e, int lvl){
		
		String tabs = "\t"; //for adding spacing b/w nodes
		
		String atab= "\t"; //adjust for right tree nodes
		
		for (int j = height(); j >= lvl; j--){
			 tabs += tabs;
		}
		
		if (e == null )	{
				return "";
		}
		if (lvl == 0){			
			if (e == root)
				return e.element.toString();
			else
				return e.element.toString() + atab;
		}//root level
		else if (lvl > 0){


			String left = lvlString_r(e.left, lvl-1);
			String right = lvlString_r(e.right, lvl-1);
			
			return left + tabs + right;
		}//above root level
		
		
		else
			return " \n";
		
		
	}
	
   /* -------------------------------------------------------------------
    * Recursively does an inorder traversal of the tree
    */
   public void inorder() { inorder_p(root); }


   private String inorder_p (Entry<E> e)  {
      /*
       * Note: eleft() gives you the entire left subtree and
       *       e.right() gives you the right tree.
       */
	   if (e == null) {
		   return "";
	   }
		   inorder_p(e.left); //traverse left 
		   String s = e.parent.toString(); //visit root
		   inorder_p(e.right); //traverse right
		   return s;
	   
	   
   }
	/*
	
	public String lvlString_r(Entry<E> e, int h){

		if (e == null )	{
				return "";
		}
		if (h == 0){
			String tab = "\t"; //for adding spacing b/w nodes
			
			if (e == root)
				return  e.element.toString();
			else
				return tab + e.element.toString();
		}//root level
		else if (h > 0){
			int i = 0;
			if (h%2==1 || h==1){
				String right = lvlString_r(e.right, h-1);
				return right;
			}//if right node (or odd number or 1)
			else{
				String left = lvlString_r(e.left, h-1);
				return left;
			}
		}//above root level
		else
			return " \n";
	}
 

    /**
     *  Ensures that this BinarySearchTree object contains a specified element.
     *  The worstTime(n) is O(n) and averageTime(n) is O(log n).
     *
     *  @param element - the element whose presence is ensured in this 
     *                 BinarySearchTree object.
     *
     *  @return true - if this BinarySearchTree object changed as a result of this
     *                method call (that is, if element was actually inserted); otherwise,
     *                return false.
     *
     *  @throws ClassCastException - if element cannot be compared to the 
     *                  elements already in this BinarySearchTree object.
     *  @throws NullPointerException - if element is null.
     *
     */
    public boolean add (E element)  
    {
        if (root == null) 
        {
            if (element == null)
                throw new NullPointerException();
            root = new Entry<E> (element, null);
            size++;             
            return true;
        } // empty tree
        else 
        {
            Entry<E> temp = root;

            int comp;

            while (true) 
            {
                comp =  ((Comparable)element).compareTo (temp.element);
                if (comp == 0)
                    return false;
                if (comp < 0){
                    if (temp.left != null)
                        temp = temp.left;
                    else 
                    {
                        temp.left = new Entry<E> (element, temp);
                        size++;                             
                        return true;
                    } // temp.left == null
                }
                else if (temp.right != null)
                        temp = temp.right;
                else 
                {
                        temp.right = new Entry<E> (element, temp);
                        size++;                           
                        return true;
                } // temp.right == null
            } // while
        } // root not null
    } // method add

    /** recursive add/insert method
     * 
     * @param element
     * @param atree
     * @return
     */
    public boolean add_r(E element, Entry<E> atree){
        Entry<E> temp = root;
    	if (atree == null){
    		atree = new Entry<E> (element, null);
    		return true;
    	}
    	else{
    		int comp = ((Comparable)element).compareTo (temp.element);
    		
    		if (comp == 0){
    			return false;
    		}//duplicate copy
    		else if (comp < 0){
    			add_r(element, atree.left);
    		}//set left node
    		else{
    			add_r(element,atree.right);
    		}//set right node
    		
    	}
		return true;
    }
    
	/**
	 * Returns the height of this BinarySearchTree object.
	 *
	 * @return an int containing the height of this BinarySearchTree object.
	 */
	public int height() {
		//BinarySearchTree t = new BinarySearchTree();
		if (size == 0)
			return 0;
		return h(root)-1;
	}
	
	/**
    * Returns the height of the subtree rooted at p.
    *
    * @param p -- an Entry that is the root of the subtree.
    *
    * @return the height of the subtree rooted at p.
    */
   protected int h (Entry<E> p) 
   {	   
      if (p != null)
    	  return Math.max(h(p.left), h( p.right)) +1;
      	
     // return    Math.max(h(successor(p.left)), h(successor(p.right))) +1;
      
      return 0;
   } // method h (recursive method)
	
    /**
     *  Ensures that this BinarySearchTree object does not contain a specified 
     *  element.
     *  The worstTime(n) is O(n) and averageTime(n) is O(log n).
     *
     *  @param obj - the object whose absence is ensured in this 
     *                 BinarySearchTree object.
     *
     *  @return true - if this BinarySearchTree object changed as a result of this
     *                method call (that is, if obj was actually removed); otherwise,
     *                return false.
     *
     *  @throws ClassCastException - if obj cannot be compared to the 
     *                  elements already in this BinarySearchTree object. 
     *  @throws NullPointerException - if obj is null.
     *
     */
    public boolean remove (Object obj)
    {
        Entry<E> e = getEntry (obj);
        if (e == null)
            return false;
        deleteEntry (e);       
        return true;
    } // method remove


    /**
     *  Finds the Entry object that houses a specified element, if there is such an Entry.
     *  The worstTime(n) is O(n), and averageTime(n) is O(log n).
     *
     *  @param obj - the element whose Entry is sought.
     *
     *  @return the Entry object that houses obj - if there is such an Entry;
     *                otherwise, return null.  
     *
     *  @throws ClassCastException - if obj is not comparable to the elements
     *                  already in this BinarySearchTree object.
     *  @throws NullPointerException - if obj is null.
     *
     */
    protected Entry<E> getEntry (Object obj) 
    {
        int comp;

        if (obj == null)
           throw new NullPointerException();
        Entry<E> e = root;
        while (e != null) 
        {
            comp = ((Comparable)obj).compareTo (e.element);
            if (comp == 0)
                return e;
            else if (comp < 0)
                e = e.left;
            else
                e = e.right;
        } // while
        return null;
    } // method getEntry
    
  

     /**
      *  Deletes the element in a specified Entry object from this BinarySearchTree.
      *  
      *  @param p - the Entry object whose element is to be deleted from this
      *                 BinarySearchTree object.
      *
      *  @return the Entry object that was actually deleted from this BinarySearchTree
      *                object. 
      *
      */
    protected Entry<E> deleteEntry (Entry<E> p) 
    {
        size--;

        // If p has two children, replace p's element with p's successor's
        // element, then make p reference that successor.
        if (p.left != null && p.right != null) 
        {
            Entry<E> s = successor (p);
            p.element = s.element;
            p = s;
        } // p had two children


        // At this point, p has either no children or one child.

        Entry<E> replacement;
         
        if (p.left != null)
            replacement = p.left;
        else
            replacement = p.right;

        // If p has at least one child, link replacement to p.parent.
        if (replacement != null) 
        {
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p == p.parent.left)
                p.parent.left  = replacement;
            else
                p.parent.right = replacement;
        } // p has at least one child  
        else if (p.parent == null)
            root = null;
        else 
        {
            if (p == p.parent.left)
                p.parent.left = null;
            else
                p.parent.right = null;        
        } // p has a parent but no children
        return p;
    } // method deleteEntry

    
    /**
     *  Finds the successor of a specified Entry object in this BinarySearchTree.
     *  The worstTime(n) is O(n) and averageTime(n) is constant.
     *
     *  @param e - the Entry object whose successor is to be found.
     *
     *  @return the successor of e, if e has a successor; otherwise, return null.
     *
     */
    protected Entry<E> successor (Entry<E> e) 
    {
        if (e == null)
            return null;
        else if (e.right != null) 
        {
            // successor is leftmost Entry in right subtree of e
            Entry<E> p = e.right;
            while (p.left != null)
                p = p.left;
            return p;

        } // e has a right child
        else 
        {

            // go up the tree to the left as far as possible, then go up
            // to the right.
            Entry<E> p = e.parent;
            Entry<E> ch = e;
            while (p != null && ch == p.right) 
            {
                ch = p;
                p = p.parent;
            } // while
            return p;
        } // e has no right child
    } // method successor
    
    protected class TreeIterator implements Iterator<E> {

        protected Entry<E> lastReturned = null,
                           next;               

        /**
         *  Positions this TreeIterator to the smallest element, according to the Comparable
         *  interface, in the BinarySearchTree object.
         *  The worstTime(n) is O(n) and averageTime(n) is O(log n).
         *
         */
        protected TreeIterator() 
        {             
            next = root;
            if (next != null)
                while (next.left != null)
                    next = next.left;
        } // default constructor


        /**
         *  Determines if there are still some elements, in the BinarySearchTree object this
         *  TreeIterator object is iterating over, that have not been accessed by this
         *  TreeIterator object.
         *
         *  @return true - if there are still some elements that have not been accessed by
         *                this TreeIterator object; otherwise, return false.
         *
         */ 
        public boolean hasNext() 
        {
            return next != null;
        } // method hasNext


        /**
         *  Returns the element in the Entry this TreeIterator object was positioned at 
         *  before this call, and advances this TreeIterator object.
         *  The worstTime(n) is O(n) and averageTime(n) is constant.
         *
         *  @return the element this TreeIterator object was positioned at before this call.
         *
         *  @throws NoSuchElementException - if this TreeIterator object was not 
         *                 positioned at an Entry before this call.
         *
         */
        public E next() 
        {
            if (next == null)
                throw new NoSuchElementException();
            lastReturned = next;
            next = successor (next);             
            return lastReturned.element;
        } // method next

        /**
         *  Removes the element returned by the most recent call to this TreeIterator
         *  object's next() method.
         *  The worstTime(n) is O(n) and averageTime(n) is constant.
         *
         *  @throws IllegalStateException - if this TreeIterator's next() method was not
         *                called before this call, or if this TreeIterator's remove() method was
         *                called between the call to the next() method and this call.
         *
         */ 
        public void remove() 
        {
            if (lastReturned == null)
                throw new IllegalStateException();
 
            if (lastReturned.left != null && lastReturned.right != null)
                next = lastReturned;
            deleteEntry(lastReturned);
            lastReturned = null; 
        } // method remove     

    } // class TreeIterator

    protected static class Entry<E> 
    {
        protected E element;
        
        char balanceFactor = '='; 		//added for AVLTree
        
        protected Entry<E> left = null,
                           right = null,
                           parent;
 
        /**
         *  Initializes this Entry object.
         *
         *  This default constructor is defined for the sake of subclasses of
         *  the BinarySearchTree class. 
         */
        public Entry() { }


        /**
         *  Initializes this Entry object from element and parent.
         *
         */ 
         public Entry (E element, Entry<E> parent) 
         {
             this.element = element;
             this.parent = parent;
         } // constructor

    } // class Entry

    

} // class BinarySearchTree

