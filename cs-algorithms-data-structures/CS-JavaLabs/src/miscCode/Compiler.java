package miscCode;

import java.util.*;

public class Compiler 
{  
  protected Stack<Token> operatorStack = new Stack<Token>();

  protected Error error = new Error();

  protected Queue<Token> postfix = new LinkedList<Token>();

  protected ArrayList<String> symbolTable = new ArrayList<String>();
  

  /*
   * Initializes this Compiler object.
   */
  public Compiler() { } // default constructor

  
  /**
   * Generates the postfix form of the infix string, provided that 
   * string contains no errors.  Otherwise, generates an error message.
   * 
   * @param infix a String that is the entered infix line.
   */
  public void convertOrReject (String infix) 
  {  
    Token previousToken = new Token();
    
    int i = 0;
    
    error.setCategory (Error.NONE);
    previousToken.makeEmpty ();
    
    while ((error.categoryOf() == Error.NONE) && (i <= infix.length ())) 
    {
      Token infixToken = new Token();
      i = infixToken.getToken (symbolTable, i, infix, error);
      if (error.categoryOf() == Error.NONE) 
      {        
        error = infixToken.checkPrevious (previousToken);
        if (error.categoryOf() == Error.NONE) 
        {          
          applyTransMatrix (infixToken);
          previousToken = infixToken;          
        } // if no error after checking previous token        
      } // if no error from the token itself      
    } // while    
  } // method convertOrReject
  
  
  /**
   * Returns either postfix or an error message, which would be
   * based on the error.
   * 
   * @return a String containing either the postfix equivalent of the
   *         entered infix or an error message.
   */
  public String returnPostfixOrError() 
  {  
    final String ERROR_INTRO = "Error in position ";
    
    final String POSTFIX_INTRO = "\nPostfix: ";
    
    final char BLANK = ' ';
    
    String info = "";
    
    if (error.categoryOf() == Error.NONE) 
    {  
      info = POSTFIX_INTRO;
      while (!postfix.isEmpty()) 
      {
        Token token = postfix.remove();
        if (token.categoryOf() == Token.IDENTIFIER)
          info += symbolTable.get (token.addressOf());
        else
          info += token.operatorOf();
        info += BLANK;
      } // while     
    } // if
    else
      info += ERROR_INTRO + (error.positionOf()) +
      ": " + Error.ERROR_MESSAGE [error.category] + "\n";
    
    while (!operatorStack.isEmpty())
      operatorStack.pop();
    while (!postfix.isEmpty())
      postfix.remove();
    
    symbolTable.clear();
    return info;
  } // method returnPostfixOrError
  
  
  /**
   * Process the infixToken.
   * 
   * @param infixToken a Token that will be applied to transMatrix.
   */
  public void applyTransMatrix (Token infixToken) 
  {    
    final int ADD_TO_POSTFIX = 0;
    
    final int POP_OPSTACK = 1;
    
    final int UNMATCHED_LEFT = 2;
    
    final int UNMATCHED_RIGHT = 3;
    
    final int PUSH_ON_OPSTACK = 4;
    
    final int POP_TO_POSTFIX = 5;
    
    final int DONE = 6;
    
    int[][] transMatrix  = 
    {      
      { ADD_TO_POSTFIX,  ADD_TO_POSTFIX,  ADD_TO_POSTFIX,  ADD_TO_POSTFIX },
      { POP_OPSTACK,     POP_TO_POSTFIX,  POP_TO_POSTFIX,  UNMATCHED_RIGHT },
      { PUSH_ON_OPSTACK, PUSH_ON_OPSTACK, PUSH_ON_OPSTACK, PUSH_ON_OPSTACK },
      { PUSH_ON_OPSTACK, POP_TO_POSTFIX,  POP_TO_POSTFIX,  PUSH_ON_OPSTACK },
      { PUSH_ON_OPSTACK, PUSH_ON_OPSTACK, POP_TO_POSTFIX,  PUSH_ON_OPSTACK },
      { UNMATCHED_LEFT,  POP_TO_POSTFIX,  POP_TO_POSTFIX,  DONE }      
    }; // transMatrix              
    
    boolean processingComplete;  // the processing of the current
         // infix token has been completed
    Token stackToken;
    
    do 
    {      
      stackToken = new Token();
      
      processingComplete = true;
      
      // Get the top token on operatorStack:
      if (operatorStack.isEmpty())
          stackToken.makeEmpty();
      else
          stackToken = operatorStack.peek();
      
      // Apply the transition matrix:
      // the -2 is because the first two categories are skipped
      switch (transMatrix [infixToken.categoryOf()]
                [stackToken.categoryOf() - 2]) 
      {        
        case ADD_TO_POSTFIX:
          postfix.add (infixToken);
          break;
          
        case POP_OPSTACK:
          operatorStack.pop();
          break;
          
        case UNMATCHED_LEFT:
          error.setCategory (Error.NO_RIGHT);
          error.setPosition (stackToken.startPosOf());
          break;
          
        case UNMATCHED_RIGHT:
          error.setCategory (Error.NO_LEFT);
          error.setPosition (infixToken.startPosOf());
          break;
          
        case PUSH_ON_OPSTACK:
          operatorStack.push (infixToken);
          break;
          
        case POP_TO_POSTFIX:                    
          
          
          break;
          
        case DONE:
          break; // take no action
      } // switch      
    } // do
    while (!processingComplete);    
  }// method applyTransMatrix  
  
} // class Compiler
