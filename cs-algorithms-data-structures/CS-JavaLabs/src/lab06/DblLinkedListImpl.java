package lab06;

import java.util.Iterator;

/**
 * Lab 06 DoubleLinkedList - methods filled in for doubly linked list - pointers
 * need to point forwards and backwards in list (prev & next)
 * 
 * @author Allen
 * 
 * @param <E>
 */

public class DblLinkedListImpl<E> implements CollectionInterface<E>,
		Iterable<E> {
	private LinkEntry<E> head;
	private LinkEntry<E> tail;
	private int s = 1;

	public DblLinkedListImpl() {
		head = tail = null;
	}

	public boolean is_empty() {
		if (head == null)
			return true;

		return false;
	}

	public boolean is_full() {
		return false;
	}

	public int size() {
		LinkEntry<E> temp;
		int i = 0;

		for (temp = head; temp != null; temp = temp.next) {
			i++;
		}// iterative solution traverses from front

		return i;
		// return size_r(head) - 1;
		/*
		 * Note that an iterative solution that traverses the list from the
		 * front would be as follows:
		 * 
		 * LinkEntry<E> temp; int i = 0;
		 * 
		 * for (temp = head; temp != null; temp = temp.next) i++; return i;
		 */
	}

	public boolean add(int index, E e) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Add e to the end of the doubly linked list. Returns true - if e was
	 * successfully added, false otherwise.
	 */
	public boolean add(E e) {
		LinkEntry<E> ne = new LinkEntry<E>(); // next element pointer
		ne.element = e;

		if (head == null && tail == null) {
			head = tail = ne; // there is nothing in list yet
		} else {
			tail.next = ne; // tail next pointing to new element
			ne.previous = tail; // ne previous points to tail
			ne.next = null; // ne next points to null
			tail = ne; // new element is now the tail
		}
		s++; // increment size by 1

		return true;
	}

	/*
	 * Remove the nth element in the list. The first element is element 1.
	 * Return the removed element to the caller.
	 */
	public E remove(int n) {
		LinkEntry<E> current = new LinkEntry<E>(); // current element pointer
		LinkEntry<E> temp = new LinkEntry<E>(); // temp holder
		E e = current.element; // element of current entry

		if (n < 0 || n > size()) {
			throw new IndexOutOfBoundsException();
		}// throws exception if index < 0

		if (n == 1) {
			e = head.element;
			current = head.next; // next element will be stored in current
			head = head.next; // set new head
			current.next.previous = head; // next element previous points to new
											// head
			head.next = current.next; // head next points to new next element
			head.previous = null; // set previous to null
		} // if n is head element
		else if (n == size()) {
			e = tail.element;
			current = tail.previous; // store previous in temp value current
			tail = tail.previous; // new tail
			current.previous.next = tail; // element that comes before tail
											// points to new tail
			tail.previous = current.previous; // new tail prev points to 2nd to
												// last element
			tail.next = null; // set tail to null
		} // if n is tail element
		else {
			current = head.next;
			// int i = 2; // incrementer for index
			for (int i = 2; i < size(); i++) {

				if (n == i) {

					e = current.element;
					// temp = current.next; //current set to next
					current = current.previous;

					// current.next.previous = current; //element after new
					// current points to new current
					current.next = current.next.next; // before element next
														// points to new current
					current.next.previous = current;

				}// if index found, remove element
				else {
					current = current.next; // move to next element
				}
				// i++;
			}// check all other elements
		}// other elements

		// s--; //decrement size
		return e;
	}

	/*
	 * Print the doubly linked list starting at the beginning.
	 */
	public void print_from_beginning() {
		LinkEntry<E> current = head; // set current to head

		while (current != null) {
			System.out.println(current.element);
			current = current.next; // increment by one
		} // using while loop to print
	}

	/*
	 * Print the doubly linked list starting the end.
	 */
	public void print_from_end() {
		LinkEntry<E> current = null; // set current to tail

		for (current = tail; current != null; current = current.previous) {
			System.out.println(current.element);
		} // using for loop to print from end
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

	private int size_r(LinkEntry<E> head) /* Think about this recursive call! */
	{
		if (head != null)
			s = s + size_r(head.next);
		return s;
	}

	/* ------------------------------------------------------------------- */
	/* Inner classes */
	protected class LinkEntry<E> {
		protected E element;
		protected LinkEntry<E> next;
		protected LinkEntry<E> previous;

		protected LinkEntry() {
			element = null;
			next = previous = null;
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
} /* CS401LinkedListImpl<E> */
