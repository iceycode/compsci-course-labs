package lab05;

/** CircularLinkedList.java
 * - template from the code seen in class
 * - modified add() method in main class
 * - in inner class, modified methods (remove, next)
 * 
 */

import java.util.Iterator;

public class CircularLinkedList<E> implements CollectionInterface<E>,
		Iterable<E> {
	private LinkEntry<E> head; // points to start of list
	private LinkEntry<E> tail; // points to end of list
	//private LinkEntry<E> temp; //stores initial value placed in
	private int s = 1; // initial size of 1

	public CircularLinkedList() {
		head = tail = null;
	}

	// checks to see if head is empty
	public boolean is_empty() {
		if (head == null)
			return true;

		return false;
	}

	public boolean is_full() {
		return false;
	}

	public int size() {
		return size_r(head) - 1;
		/*
		 * Note that an iterative solution would be as follows:
		 * 
		 * LinkEntry<E> temp; int i = 0;
		 * 
		 * for (temp = head; temp != null; temp = temp.next) i++; return i;
		 */
	}

	public boolean add(int index, E e) {
		throw new UnsupportedOperationException();
	}

	// modified add method for circular linkedlist
	public boolean add(E e) {
		LinkEntry<E> ne = new LinkEntry<E>();// new element ref
		ne.element = e;
		
		LinkEntry<E> last = new LinkEntry<E>();// reference to last node

		if (head == null && tail == null) {
			head = tail = ne;
			
		} 
		else{
			last = head;
			//temp = ne;
			tail.next = ne;
            tail = ne;
		}

		return true;
	}// modified add for circular linked list

	public boolean add_sorted(E e) {
		LinkEntry<E> ne = new LinkEntry<E>();
		ne.element = e;

		if (head == null && tail == null) {
			head = tail = ne;
		} else {
			LinkEntry<E> prev = null;
			LinkEntry<E> temp;

			for (temp = head; temp != null; temp = temp.next) {
				int comp = ((Comparable) e).compareTo(temp.element);
				if (comp < 0) /* Element added is less than one on list. */
				{
					break;
				}
				prev = temp;
			}

			if (prev == null) /* Adding as new head */
			{
				ne.next = head;
				head = ne;
			} else if (temp == null) /* Adding as new tail */
			{
				tail.next = ne;
				tail = ne;
			} else /* Adding in the middle */
			{
				ne.next = prev.next; /* HAS TO BE IN THIS ORDER */
				prev.next = ne; /* HAS TO BE IN THIS ORDER */
			}
		}

		return true;
	}

	public E remove(int index) {
		throw new IndexOutOfBoundsException();
	}

	public E remove() {
		throw new UnsupportedOperationException();
	}

	public E get(int index) {
		throw new UnsupportedOperationException();
	}

	public boolean contains(E e) {
		throw new UnsupportedOperationException();
	}

	public Iterator<E> iterator() /* From Interface Iterable */
	{
		return new LinkedListIterator();
	}

	private int size_r(LinkEntry<E> head) /* Think about this recursive call! */
	{
		if (head != tail)
			s = s + size_r(head.next);
		return s;
	}

	/* ------------------------------------------------------------------- */
	/* Inner classes */
	protected class LinkEntry<E> {
		protected E element;
		protected LinkEntry<E> next;
	}

	/* ------------------------------------------------------------------- */
	protected class LinkedListIterator implements Iterator<E> {
		protected LinkEntry<E> current;
		protected LinkEntry<E> previous;

		protected LinkedListIterator() {
			current = head;
		} // iterator constructor

		public E next() {
			E e = current.element;
			
			previous = current;
			
			if (current == null){
				current = tail;
			}
			else
				current = current.next;
			
			return e;
		}

		public boolean hasNext() {
			if (current != null){
				return true;
			}
			else
				return false;
		}

		public void remove() {

			if (current == head) {
				head = current.next;
				tail.next = head;
			} else if (current == tail) {
				previous.next = head;
				tail = previous;
			} else {
				current = head.next;
			}
			head = current;
			//head = previous;
		}// remove method modified for circular linked list

	}
} // LinkedListIterator modified for circular linked list

