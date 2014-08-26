package lab03;

/** Sequence.java class
 * - from programming exercise 4.1
 * 
 * @author Allen Jagoda CS401 Lab 03
 *
 * @param <E>
 */

public class Sequence<E> {
	
	final String IllegalArgumentException = "You entered a negative number!";

	protected E[] data; //data array
	
	protected int size; // the number of elements in the Sequence, not the
						// capacity of the data array

	/**
	 * Initializes this Sequence object to be empty, with an initial capacity of
	 * ten elements.
	 * 
	 */
	public Sequence() {
		data = (E[]) new Object[10]; //max capacity of 10
		size = 0; //capacity is initialized to 0
	}

	/**
	 * Initializes this Sequence object to be empty, with a specified initial
	 * capacity.
	 * 
	 * @param capacity 
	 *            Ð the initial capacity of this Sequence object.
	 * 
	 * @throw IllegalArgumentException Ð if capacity is non-positive.
	 * 
	 */
	public Sequence(int n) throws IllegalArgumentException{
		data = (E[]) new Object[n]; //capacity set to n
		size = 0; //size is 0; nothing stored in it
	}

	/**
	 * Returns the number of elements in this Sequence object.
	 * 
	 * @return the number of elements in this Sequence object.
	 * 
	 */
	public int size() {
		return data.length;
	}

	/**
	 * Appends a specified element to this Sequence object.
	 * 
	 * @param element
	 *            Ð the element to be inserted at the end of this Sequence
	 *            object.
	 * 
	 */
	public void append(E element) {

		if (size == data.length) {
			E[] temp = (E[]) new Object[2 * size]; // allow room for growth
			System.arraycopy(data, 0, temp, 0, size); //copies data array
			data = temp; 
		} //if all the room is taken up, doubles the size
		
		data[size++] = element; //adds element to end of new size
	}

	/**
	 * Returns the element at a specified index in this Sequence object. The
	 * worstTime(n) is constant, where n is the number of elements in this
	 * Sequence object.
	 * 
	 * @param k Ð the index of the element returned.
	 * 
	 * @return the element at index k in this Sequence object.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             Ð if k is either negative or greater than or equal to the
	 *             number of elements in this Sequence Sequence object.
	 * 
	 */
	public E get(int k) throws IndexOutOfBoundsException {
		E e = data[k]; //get element pointer points to
		return e; //return element
	}

	/**
	 * Changes the element at a specified index in this Sequence object. The
	 * worstTime(n) is constant, where n is the number of elements in this
	 * Sequence object.
	 * 
	 * @param k Ð the index of the element returned.
	 * 
	 * @param newElement Ð the element to replace the element at index k in this
	 *            Sequence object.
	 * 
	 * @throws IndexOutOfBoundsException  Ð if k is either negative or greater 
	 * 				than or equal to the number of elements in this Sequence object.
	 *             
	 * 
	 */
	public void set(int k, E newElement) throws IndexOutOfBoundsException{
		data[k] = newElement; //sets the specified index k to newElement 
		     
	}

}