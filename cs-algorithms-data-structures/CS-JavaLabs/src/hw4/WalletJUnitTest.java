package hw4;

/** WalletJUnitTest
 *  - automated JUnit tests for Wallet collection
 *  
 *  @author Allen Jagoda CS402 HW4
 */

import static org.junit.Assert.*;
import static org.junit.runner.JUnitCore.runClasses;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Result;

public class WalletJUnitTest extends Wallet<Coin>{


	public static void main(String[] args)
    {  
        Result result = runClasses (WalletJUnitTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main

    protected Wallet<Coin> wallet; 
    protected Coin c;
                       
    @Before    
    public void RunBeforeEachTest()
    {
    	String name = "";
    	String value = "";
    	
        wallet = new Wallet<Coin>();
        c = new Coin(name, value);
        
    } // method RunBeforeEachTest    
    
	@Test
	public void testSetup() throws Exception {
		
	}//before each test

	@Test
	public void testEmptyWallet() throws Exception {
		assertTrue(wallet.isEmpty());
	}//tests to see if wallet is empty

	@Test
	public void testNumCoins() {
		//adding coins to wallet
		c.setName("dime");
		c.setValue("10 cents");
		wallet.add(c);
		
		c.setName("penny");
		c.setValue("1 cent");
		wallet.add(c);
		
		c.setName("nickel");
		c.setValue("5 cents");
		wallet.add(c);
		
		assertEquals(3, wallet.getNumCoins());
	}//test to see whether 3 coins added properly
	
	@Test
	public void testWalletCoins(){
		//adding coin objects
		Coin c1 = c;
		c1.setName("dime");
		c1.setValue("10 cents");
		wallet.add(c1);
		
		Coin c2 = c;
		c2.setName("penny");
		c2.setValue("1 cent");
		wallet.add(c2);
		
		Coin c3 = c;
		c3.setName("nickel");
		c3.setValue("5 cents");
		wallet.add(c3);
		
		//testing whether values are what/where they are
		assertEquals(c3, wallet.tail.c);
		assertEquals(c2, wallet.head.next.c);
		assertEquals(c1, wallet.head.c);
	}

}
