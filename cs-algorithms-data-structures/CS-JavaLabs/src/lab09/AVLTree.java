package lab09;

import java.util.*;

/** AVLTree
 * - either empty or height difference b/w left & right subtrees cannot be more then 1
 * - new method for adding, deleting
 * - also added fixAfterInsertion & fixAfterDeletion methods
 * - recursive addition method added
 * - rotateRight & rotateLeft methods added
 * 
 * @author Allen Jagoda CS401
 *
 * @param <E>
 */

public class AVLTree<E> extends BinarySearchTree<E>
{
    protected AVLEntry<E> root;

    protected int size;        
    
    /**
     *  Initializes this BinarySearchTree object to be empty, to contain only elements
     *  of type E, to be ordered by the Comparable interface, and to contain no 
     *  duplicate elements.
     *
     */ 
    public AVLTree()  {
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
    public AVLTree (AVLTree<? extends E> otherTree)
    {
         root = copy (otherTree.root, null);
         size = otherTree.size;  
    } // copy constructor

    protected AVLEntry<E> copy (AVLEntry<? extends E> p, AVLEntry<E> parent)
    {
        if (p != null)
        {
            AVLEntry<E> q = new AVLEntry<E> (p.element, parent);
            q.left = copy (p.left, q);
            q.right = copy (p.right, q);
            return q;
        } // if
        return null;
    } // method copy
        
    public boolean equals (Object obj) {
        if (!(obj instanceof BinarySearchTree))
            return false;
        return equals (root, ((AVLTree<? extends E>)obj).root);
    } // method 1-parameter equals
    
    public boolean equals (AVLEntry<E> p, AVLEntry<? extends E> q)
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
	    if (root == null) {
		    if (element == null)
		    	throw new NullPointerException();
		    root = new AVLEntry<E> (element, null);
		    size++;
		    return true;
	    } // empty tree
	    else
	    {
	    AVLEntry<E> temp = (AVLEntry<E>)root,
	    imbalanceAncestor = null; // nearest ancestor of
	    						// element with
	   							// balanceFactor not Ô=Õ
	    int comp;
		    while (true)
		    {
			    comp = ((Comparable)element).compareTo (temp.element);
			    if (comp == 0)
			    	return false;
			    if (comp < 0)
			    {
			    	if (temp.balanceFactor != '=')
			    		imbalanceAncestor = temp;
			    	if (temp.left != null)
			    		temp = (AVLEntry<E>)temp.left;
			    else
			    {
			    	temp.left = new AVLEntry<E> (element, temp);
			    	fixAfterInsertion ((AVLEntry<E>)temp.left,
			    						imbalanceAncestor);
			    	size++;
			    	return true;
			    } // temp.left == null
			    } // comp < 0
			    else
			    {
					if (temp.balanceFactor != '=')
						imbalanceAncestor = temp;
					if (temp.right != null)
						temp = (AVLEntry<E>)temp.right;
					else{
						temp.right = new AVLEntry<E>(element, temp);
						fixAfterInsertion ((AVLEntry<E>)temp.right, imbalanceAncestor);
						size++;
						return true;
					} // temp.right == null
				} // comp > 0
			} // while
	    } // root not null
    } // method add

    /** Fixes the balance of tree after insertion
     * 
     * @param left
     * @param imbalanceAncestor
     */
    private void fixAfterInsertion(AVLEntry<E> p,
	    AVLEntry<E> imbalanceAncestor) {
    	/* pseudocode
    	 * 
	    	 if (before)
	    	 	node = rotateLeft(node);
	    	 else 
	    	 	node = rotateRight(node);
	    	 return node;
    	 */
    	int comp = ((Comparable)p.element).compareTo (imbalanceAncestor.element);
    	
    	if (comp < 0 ){
    		rotateLeft(imbalanceAncestor);
    	}//rotate left
    	else
    		rotateRight(imbalanceAncestor); //rotate right
    	
	}

	/** recursive add/insert method
     * 
     * @param element
     * @param atree
     * @return
     */
    public boolean add_r(E element, AVLTree<E> atree){
        AVLEntry<E> temp = root;
    	if (atree == null){
    		atree = new AVLTree<E> ();
    		return true;
    	}
    	else{
    		int comp = ((Comparable)element).compareTo (temp.element);
    		
    		if (comp == 0){
    			return false;
    		}//duplicate copy
    		else if (comp < 0){
    			add_r(element, atree);
    		}//set left node
    		else{
    			add_r(element, atree);
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
   protected int h (AVLEntry<E> p) 
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
        AVLEntry<E> e = getAVLEntry (obj);
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
    protected AVLEntry<E> getAVLEntry (Object obj) 
    {
        int comp;

        if (obj == null)
           throw new NullPointerException();
        AVLEntry<E> e = root;
        
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
    protected AVLEntry<E> deleteEntry (AVLEntry<E> p) 
    {
        size--;

        // If p has two children, replace p's element with p's successor's
        // element, then make p reference that successor.
        if (p.left != null && p.right != null) 
        {
            AVLEntry<E> s = successor (p);
            p.element = s.element;
            p = s;
        } // p had two children


        // At this point, p has either no children or one child.

        AVLEntry<E> replacement;
         
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
	    fixAfterDeletion (p.element, (AVLEntry<E>)p.parent);

        return p;
    } // method deleteEntry

    /**
    *	Restores the AVL properties, if necessary, by rotations and balance-factor
    *	adjustments between the element actually deleted and a specified ancestor
    *	of the AVLEntry object actually deleted.
    *	The worstTime(n) is O(log n).
    *
    *	@param element Ð the element actually deleted from this AVLTree object.
    *	@param ancestor Ð the specified ancestor (initially, the parent) of the
    *	element actually deleted.
    *
    */
    protected void fixAfterDeletion (E element, AVLEntry<E> ancestor){
    	
    	//define AVLTree requirements
    	//**1) height between left & right subtrees must not differ by more than 1
    	//**2) root's left & right subtrees are AVLTrees
    	
    	while (!(h(ancestor.right) + 1 <= h(ancestor.left) 
    			&& h(ancestor.left)+1 <= h(ancestor.right))){
	    	if (ancestor.balanceFactor != '='){
	    		
	    		int comp = ((Comparable)element).compareTo(ancestor.element);
	    		if (comp < 0){
	    			rotateLeft(ancestor);
		    		ancestor = ancestor.parent; //replace with previous parent
	    		}//rotate left if removed element greater then ancestor
	    		else{
	    			rotateRight(ancestor);
		    		ancestor = ancestor.parent;//replace with previous parent
	    		}
	    		rotateLeft(ancestor);
	    	}
    	}//while AVLTree criteria not met, loop until it is
    }

    /**
     *  Finds the successor of a specified Entry object in this BinarySearchTree.
     *  The worstTime(n) is O(n) and averageTime(n) is constant.
     *
     *  @param e - the Entry object whose successor is to be found.
     *
     *  @return the successor of e, if e has a successor; otherwise, return null.
     *
     */
    protected AVLEntry<E> successor (AVLEntry<E> e) 
    {
        if (e == null)
            return null;
        else if (e.right != null) 
        {
            // successor is leftmost Entry in right subtree of e
            AVLEntry<E> p = e.right;
            while (p.left != null)
                p = p.left;
            return p;

        } // e has a right child
        else 
        {

            // go up the tree to the left as far as possible, then go up
            // to the right.
            AVLEntry<E> p = e.parent;
            AVLEntry<E> ch = e;
            while (p != null && ch == p.right) 
            {
                ch = p;
                p = p.parent;
            } // while
            return p;
        } // e has no right child
    } // method successor
    
    /**
    * Performs a left rotation in this BinarySearchTre object around a specified
    * Entry object.
    *
    * @param p Ð the Entry object around which the left rotation is performed
    *
    * @throws NullPointerException Ð if p is null or p.right is null.
    *
    * @see Cormen, 2002.
    * 
    */
    protected void rotateLeft (AVLEntry<E> p)
    {
	    AVLEntry<E> r = p.right;
		p.right = r.left;
		if (r.left != null)
			r.left.parent = p;
		r.parent = p.parent;
		if (p.parent == null)
			root = r;
		else if (p.parent.left == p)
			p.parent.left = r;
		else
			p.parent.right = r;
		r.left = p;
		p.parent = r;
	} // method rotateLeft
    
    /**
     * Performs a right rotation in this BinarySearchTre object around a specified
     * Entry object.
     *
     * @param p Ð the Entry object around which the left rotation is performed
     *
     * @throws NullPointerException Ð if p is null or p.right is null.
     *
     * @see Cormen, 2002.
     * 
     */
     protected void rotateRight (AVLEntry<E> p)
     {
 	    AVLEntry<E> l = p.left;
 		p.left = l.right;
 		if (l.right != null)
 			l.right.parent = p;
 		l.parent = p.parent;
 		if (p.parent == null)
 			root = l;
 		else if (p.parent.right == p)
 			p.parent.right = l;
 		else
 			p.parent.left = l;
 		l.right = p;
 		p.parent = l;
 	} // method rotateRight
    
    protected class TreeIterator implements Iterator<E> {

        protected AVLEntry<E> lastReturned = null,
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

    protected static class AVLEntry<E> 
    {
        protected E element;
        
        char balanceFactor = '='; 		//added for AVLTree
        
        protected AVLEntry<E> left = null,
                           right = null,
                           parent;
 
        /**
         *  Initializes this Entry object.
         *
         *  This default constructor is defined for the sake of subclasses of
         *  the BinarySearchTree class. 
         */
        public AVLEntry() { }


        /**
         *  Initializes this Entry object from element and parent.
         *
         */ 
         public AVLEntry (E element, AVLEntry<E> parent) 
         {
             this.element = element;
             this.parent = parent;
         } // constructor

    } // class Entry

} // class BinarySearchTree


