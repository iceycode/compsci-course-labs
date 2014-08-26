package lab07;

import java.util.*;

public class InfixToPostfix
{
	public static void main (String[] args)
	{
		new InfixToPostfix().run();
	} // method main

	public void run()
	{
	  	final String SENTINEL = "***";

  		final String INPUT_PROMPT =
    			"\nPlease enter an infix expression (or " +
    			SENTINEL + " to quit): ";
    					
  		//Compiler.java changed to EvalExpression.java
  		EvalExpression compiler = new EvalExpression();

		Scanner sc = new Scanner (System.in);
    
		String line = new String();
    
		while (true)
		{
  			try
  			{
  			System.out.println(INPUT_PROMPT);
    			line = sc.nextLine();
    			if (line.equals (SENTINEL)) 
        				break;
    			compiler.convertOrReject (line);
    			System.out.println (compiler.returnPostfixOrError()); 
  			} // try
  			catch (Exception e)
  			{
    			System.out.println (e);
  			}//catch Exception
		}//while
  	} // method convert
  
} // class InfixToPostfix
