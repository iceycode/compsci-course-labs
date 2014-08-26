/**
 * 
 */
package miscCode;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * LinkedList.java - a linked list for implementation with collection interface
 * interface
 * 
 * @author Allen Jagoda CS401 programming exercises 7.2 & 7.6
 * 
 */
public class LinkedList<E> implements CollectionInterface<E>, Iterable<E> {

	private Entry<E> head; // start of list
	private Entry<E> tail; // end of list
	private int s = 1;

	public LinkedList() {
		head = tail = null;
	} // constructor

	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator<E> listIterator() {
		return new listIterator();
	}

	public boolean is_full() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean is_empty() {
		// TODO Auto-generated method stub
		return false;
	}

	public int size() {
		Entry<E> temp;
		int i = 0;
		for (temp = head; temp !=null; temp = temp.next)
			i++;
		return i;
	}//iterative size() method

	public boolean add(int index, E e) {
		// TODO Auto-generated method stub
		return false;
	}
/*
	public boolean add(E e) {
		Entry<E> ne = new Entry<E>();
		ne.element = e;

		if (head == null && tail == null) {
			head = tail = ne;
		} else {
			tail.next = ne;
			tail = ne;
		}

		return true;
	}*/
	
	//***------------inner classes-------------------***
	protected class Entry<E> {
		protected E element;
		protected Entry<E> next;

	} // class Entry
	
	protected class listIterator implements ListIterator<E>{
		
		protected Entry<E> current;

		protected listIterator() {
			current = head;
		}//constructor
		
		public void add (E e){
			Entry<E> ne = new Entry<E>();
	      ne.element = e;

	      if (head == null && tail == null)
	      {
	          head = tail = ne;
	      }
	      else
	      {
	         tail.next = ne;
	         tail = ne; 
	      }
		}
		
		/**
		 * Returns the element this Iterator object was (before this call)
		 * positioned at, and advances this Iterator object.
		 * 
		 * @return - the element this Iterator object was positioned at.
		 * 
		 * @throws NoSuchElementException
		 *             ñ if this Iterator object was not postioned at an element
		 *             before this call.
		 */
		public E next() {
			 E e = current.element;
	         current = current.next;
	         return e;
		} // method next
		
		/**
		* Retreats this ListIterator object to the previous element, and returns that * element.
		*
		*
		* @return the element rettreated to in this ListIterator object
		*
		* @throws NoSuchElementException - if this ListIterator object has no previous element
		*
		*/
		public E previous(){
			E e = tail.element;
			current = current.next;
			return e;
		}
		
		
		/**
		* Determines whether this ListIterator object has more elements when traversing * in the reverse direction.
		*
		* @return true – if this ListIterator object has more elements when traversing * in the reverse direction; otherwise, false.
		*
		*/
		public boolean hasPrevious(){
			return tail !=null;
		}
		
		
		/**
		 * Determines if this Iterator object is positioned at an element in
		 * this Collection.
		 * 
		 * @return true - if this Iterator object is positioned at an element;
		 *         otherwise, false.
		 */
		public boolean hasNext() {
			return current != null;
		} // method hasNext

		/**
		 * Removes the element returned by the most recent call to next() or previous(). 
		 * This method can be called only once per call to next() or previous(), and can
		 * can be called only if this ListIterator’s add method has not been called
		 *  since the most recent call to next() or previous().
		 *  
		 * @throws IllegalStateException – if neither next() nor previous() has been 
		 *         called, or if either this ListIterator’s add or remove method has 
		 *         been called since the most recent call to next() or previous()
		 *         
		 */
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void set(E arg0) {
			// TODO Auto-generated method stub
			
		}

	
		
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}



/*
 */
}
