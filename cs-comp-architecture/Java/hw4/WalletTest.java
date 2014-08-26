package hw4;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/** WalletTest.java
 * - uses linkedlist as a collection
 * 1 constructs empty wallet object
 * 2 asks user for name of coin
 * 3 asks user for value of coin
 * 4 adds coin to wallet
 * 5 prints content of wallet
 * 6 repeat from 2 thru 6
 * 
 * OUTPUT format:
 * coinName (coinValue): numberOfCoins
 * 
 * @author Allen Jagoda 
 * CS402 HW4
 *
 */

public class WalletTest {

	public static void main(String[] args) {
		Wallet<Coin> wallet = new Wallet<Coin>(); //wallet construct
		
		//user prompts
		final String NAME_P = "Please enter the name of a coin or Q to quit (ie. dime, nickel)";
		final String VALUE_P = "Please enter the value of that coin (ie. 10 cents, 1 cents, 100 eurocents)";
		final String OUTPUT_P = "coin name (coin value) : number of coins in wallet";
		String all = "";
		
		Scanner s = new Scanner(System.in); //scanner object
		
		String name = "a coin"; //coin var
		String value = "n cents"; //value of coin var

		while(!name.equals("Q")){
			System.out.println(NAME_P);
			name = s.nextLine(); //input string name
			
			if (name.equals("Q")){
				System.out.println("Finished adding to wallet.");
				System.out.println(all);
			}
			else{
				System.out.println(VALUE_P);
				value = s.nextLine(); //input int value
			
				//create coin & set name/value
				Coin c1 = new Coin(name, value);
							
				//add coin to wallet, then print
				wallet.add(c1);		
				
				//print message
				String m = c1.getName() + " (" + c1.getValue() + "): "+ wallet.getNumCoins();
				all = all.concat(m +" \n");
				System.out.println(OUTPUT_P);
				System.out.println(all);
			}
		}
	}//main method


	public void end(){
		
	}
}
