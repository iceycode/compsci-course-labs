package hw4;

import java.util.*;

/** Wallet.java
 * - a collection of coins
 * - has add() & printContent() method
 * prints in following format:
 * 		coinName(coinValue) : numberOfCoins
 * 
 * 
 * @author Allen Jagoda CS402 HW4
 *
 */

public class Wallet<Coin> extends LinkedList<Coin> implements Iterable<Coin> 
{

	protected LinkEntry<Coin> head;
	protected LinkEntry<Coin> tail;
	protected int size = 1;

	protected int numCoins = 0; // the number of coins currently stored

	public Wallet() { 
		head = tail = null;
	}//default constructor

	//getters
	public int getNumCoins() {
		return numCoins;
	}//getter method for number of coins
	
	public int getSize() {
		return size;
	}

	//setters
	public void setNumCoins(int numCoins) {
		this.numCoins = numCoins;
	}//setter method for num of coins
	
	public void setSize(int size) {
		this.size = size;
	}
	
   public boolean is_empty()
   {
      if (head == null) 
          return true;

      return false;
   }

   public boolean is_full() { 
	   return false; 
   }
	   
	//add method
	public boolean add(Coin c)
	{
		LinkEntry<Coin> ne = new LinkEntry<Coin>();
		ne.c = c;
	
		if (head == null && tail == null)
		{
			head = tail = ne;
		}
		else
		{
			tail.next = ne;
			tail = ne; 
		}
		numCoins++;
		return true;
	}

	/* ------------------------------------------------------------------- */
	/* Inner class	                                                       */
	protected class LinkEntry<Coin>
	{
		protected Coin c;
		protected LinkEntry<Coin> next;
	}



}
