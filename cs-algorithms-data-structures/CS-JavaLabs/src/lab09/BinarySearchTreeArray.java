package lab09;

/** BinarySearchTreeArray
 * - uses same methods as BST data struct
 * - uses indexes to simulate parent, left & right links
 * - 
 * 
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

import lab09.BinarySearchTree.Entry;

public class BinarySearchTreeArray<E> {
    protected Entry<E>[] tree;
    protected Entry<E> entry = new Entry<E>();

    protected int root, size;        //root like index, size like length
    
    /**
     *  Initializes this BinarySearchTree object to be empty, to contain only elements
     *  of type E, to be ordered by the Comparable interface, and to contain no 
     *  duplicate elements.
     *
     */ 
    public BinarySearchTreeArray()  {
    	//tree[size] = new Entry<E>();
    	//E e = null;
    	tree = new Entry[10]; //<-----inializing FIXED PROBLEM with NullPointerException
        size = 0;
        root = -1;
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
    public BinarySearchTreeArray (Entry <E>[] otherTree)
    {
    	tree[root] = copy(otherTree[root], 0);
    	size = otherTree.length;
   
    } // copy constructor

    protected Entry<E> copy (Entry<? extends E> p, int parent)
    {
    	//Entry<E>[] tree2; //tree2 gets returned
    	
        if (p != null)
        {        	
        	
            Entry<E> q = new Entry<E>(tree[p.parent].element, parent);
            
            tree[q.left] = copy(tree[p.left], parent++);
            tree[q.right] = copy(tree[p.right] , parent++);
            
            /*
             *             
            q.left = copy (p.left, q);
            q.right = copy (p.right, q);s
             */
            
            return q;
        } // if        
        return null;
    } // method copy
        
    public boolean equals (Object obj)
    {
        if (!(obj instanceof BinarySearchTreeArray))
            return false;
        return equals (tree[root], ((BinarySearchTreeArray<? extends E>)obj).tree[root]);
    } // method 1-parameter equals
    
    public boolean equals (Entry<E> p, Entry<? extends E> q) {
       if (p == null || q == null)
           return p == q;      
       if (!p.element.equals (q.element))
           return false;
       if (equals(tree[p.left], tree[q.left]) && equals(tree[p.right], tree[q.right]))
           return true;            
       return false;     
    } // method 2-parameter equals
    
    /**
     *  Returns the size of this BinarySearchTreeArray object.
     *
     * @return the size of this BinarySearchTreeArray object.
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
    public <E> boolean add (E element)  
    {
        if (root == -1) 
        {
            if (element == null)
                throw new NullPointerException();
            size++;
            root++;
           // entry = new Entry(element, root);
            tree[root] = new Entry(element, -1);
            //right & left initially set to -1
            return true;
        } // empty tree
        else 
        {
            int comp;
        	int temp = 0;
        	Entry home = tree[temp]; //root entry
        	
            while (true) 
            {
                comp = ((Comparable)element).compareTo (tree[temp].element);
                
                if (comp == 0)
                    return false;
                if (comp < 0)
                    if (tree[temp].left != -1){
                         temp = tree[temp].left; //temp = temp.left; //aka entry temp = 
                         home = tree[temp];
                    }
                    else   {
                    	root++;
                    	home.left = root;
                    	tree[root] = new Entry (element, temp);
                        size++;                             
                        return true;
 
                    } // temp.left == null
                else if (tree[temp].right != -1){
                	temp = tree[temp].right; //point to were prev node is
                    home = tree[temp]; //set new parent node
                }// parent node cannot take any more right nodes
                else 
                {                    	
                        root++;
                        home.right = root;
                        tree[root] = new Entry (element, temp);
                        size++;
                        return true;
                        
                } // temp.right == null
            } // while
        } // root not null
    } // method add

	/**
	 * Returns the height of this BinarySearchTree object.
	 *
	 * @return an int containing the height of this BinarySearchTree object.
	 */
	public int height() {
		//BinarySearchTree t = new BinarySearchTree();
		if (size == 0)
			return 0;
		return h(tree[root])-1;
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
    	  return Math.max(h(tree[p.left]), h( tree[p.right])) +1;
      	
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
    	// BSTArray getEntry method code
    	int temp = 0, 
    			comp;
    	
    	while (temp != -1){
    		comp = ((Comparable)obj).compareTo(tree[temp].element);
    		if (comp == 0)
    			return tree[temp];
    		else if (comp < 0)
    			temp = tree[temp].left;
    		else
    			temp = tree[temp].right;
    	}
    	return null;
    } // method getEntry
    
  
     /**
      *  Deletes the element in a specified Entry object from this BinarySearchTreeArray.
      *  
      *  @param p - the Entry object whose element is to be deleted from this
      *                 BinarySearchTree object.
      *
      *  @return the Entry object that was actually deleted from this BinarySearchTree
      *                object. 
      *
      */
    protected Entry<E> deleteEntry (Entry<E> p) {
        size--;

        // If p has two children, replace p's element with p's successor's
        // element, then make p reference that successor.
        if (p.left != -1 && p.right != -1) 
        {
            Entry<E> s = successor (p);
            p.element = s.element;
            p = s;
        } // p had two children
        

        // At this point, p has either no children or one child.
        Entry<E> replacement;
         
        if (p.left != -1)
            replacement = tree[p.left];
        else
            replacement = tree[p.right];

        // If p has at least one child, link replacement to p.parent.
        if (replacement != null) {
            replacement.parent = tree[root].parent;
            if (p.parent == -1)
                tree[p.parent] = replacement;
            else if (p == tree[p.parent].element)
                tree[p.left] = replacement;
            else
                tree[p.right] = replacement;
        } // p has at least one child  
        else if (p.parent == -1)
            tree = null;
        else 
        {
            if (p == tree[p.left].element)
                p.left = -1;
            else
                p.right = -1;        
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
        if (e.element == null)
            return null;
        else if (e.right != -1) 
        {
            // successor is leftmost Entry in right subtree of e
            Entry<E> p = tree[e.right];
            while (p.left != -1)
                p = tree[p.left]; 
            return p;

        } // e has a right child
        else 
        {

            // go up the tree to the left as far as possible, then go up
            // to the right.
            Entry<E> p = tree[e.left];
            Entry<E> ch = e;
            while (p != null && ch == tree[p.right]) 
            {
                ch = p;
                p = tree[p.parent];
            } // while
            return p;
        } // e has no right child
    } // method successor
    
    protected class TreeIterator implements Iterator<E>
    {

        protected Entry<E> lastReturned = null;
		Entry<E> next;               

        /**
         *  Positions this TreeIterator to the smallest element, according to the Comparable
         *  interface, in the BinarySearchTree object.
         *  The worstTime(n) is O(n) and averageTime(n) is O(log n).
         *
         */
        protected TreeIterator() 
        {             
            next = tree[root];
            if (next != null)
                while (next != null)
                    next = tree[next.left];
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
 
            if (lastReturned.left != -1 && lastReturned.right != -1)
                next = lastReturned;
            deleteEntry(lastReturned);
            lastReturned = null; 
        } // method remove     

    } // class TreeIterator

    protected static class Entry<E>
    {
        protected E element;

        protected int left = -1,
                       right = -1,
                       parent;
 
        /**
         *  Initializes this Entry object.
         *
         *  This default constructor is defined for the sake of subclasses of
         *  the BinarySearchTree class. 
         */
        public Entry() { 
        	element = null;
        	parent = -1;
        }


        /**
         *  Initializes this Entry object from element and parent.
         *
         */ 
         public Entry (E e, int p) 
         {
             this.element = e;
             this.parent = p;
         } // constructor

    } // class Entry
}
