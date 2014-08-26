package lab03;

import java.util.PriorityQueue;
import java.util.Random;

/** Numbers.java class instance
 * - class object which contains the winning numbers
 * - also used to store to user clicked numbers
 * - 
 * 
 * @author Allen
 *
 */

public class Numbers extends PriorityQueue<Numbers> implements Comparable<Numbers>{

	private static final long serialVersionUID = -490178980506376293L;
	
	private final String HIT = "HIT"; //guessed correct
	
	private final String MISS = "MISS"; //did not guess correct
	
	//user can only choose up to 6 numbers
	private static final int MAX_USER_NUMBERS = 6; 
	
	private int winningNum; //array to store winning numbers
	private int userNum; //array to store user clicked numbers
	
	
	
	//PriorityQueue for numbers chosen by user
	private PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	
	public Numbers(){ }//default constructor
	
	public Numbers(int userNum){
		this.setUserNums(userNum);
		pq.add(userNum);
	}
	
	public void winningNums(){
		Random r = new Random();
		setWinningNum(r.nextInt(47)+1);
	}//returns a winning number

	public void checkWinner(){
		
	}//compares user int to that of winning one
	
	//***********-------GETTER & SETTER METHOS--------**************//
	/**
	 * @return the winningNum
	 */
	public int getWinningNum() {
		return winningNum;
	}

	/**
	 * @param winningNum the winningNum to set
	 */
	public void setWinningNum(int winningNum) {
		this.winningNum = winningNum;
	}

	/**
	 * @return the userNums
	 */
	public int getUserNums() {
		return userNum;
	}

	/**
	 * @param userNums the userNums to set
	 */
	public void setUserNums(int aNum) {
		this.userNum = aNum;
	}

	/**
	 * @return the maxUserNumbers
	 */
	public static int getMaxUserNumbers() {
		return MAX_USER_NUMBERS;
	}

	@Override
	public int compareTo(Numbers n) {
		if (n.getUserNums() > userNum)
			return 1;
		else if (n.getUserNums() < userNum)
			return -1;
		else
			return 0;
	}
	
}
