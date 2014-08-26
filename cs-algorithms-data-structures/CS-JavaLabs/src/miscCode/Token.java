package miscCode;

import java.util.*;

public class Token 
{
  static final int IDENTIFIER = 0;
  static final int RIGHT_PAR = 1;
  static final int LEFT_PAR = 2;
  static final int ADD_OP = 3;
  static final int MULT_OP = 4;
  static final int EMPTY = 5;
  
  protected String theOperator = new String();
  public int category;
  protected int address;
  protected int startPos;
  
  
  /**
   * Initializes this Token object to be empty.
   */
  public void makeEmpty () 
  {  
    category = EMPTY; 
  } // method makeEmpty
  
   
  /**
   * Determines, based on i's position in infix, this Token's value (or error), and 
   * returns the index in infix of the first character beyond this Token. 
   * 
   * @param symbolTable an ArrayList containing the symbols needed 
   *                    for the conversion from infix to postfix.
   * @param i an int that represents the position in the infix.
   * @param infix a String that is the entered infix line.
   * @param error an Error that reports an error.
   * 
   * @return an int that represents the infix index beyond this Token.
   */
  public int getToken (ArrayList<String> symbolTable, int i,
                       String infix, Error error) 
  {  
    final char BLANK = ' ';

    final char DOLLAR = '$';

    final char UNDER_SCORE = '_';
    
    final String referent;
    
    if (i == infix.length ())
      category = EMPTY;
    else 
    {  
      while (infix.charAt (i) == BLANK)
        i++;
      startPos = i;
      if (Character.isLetter (infix.charAt (i))) 
      {        
        category = IDENTIFIER;
        while (i < infix.length () &&
               (Character.isLetter (infix.charAt (i))))                        
            i++;        
        i--;
        referent = infix.substring (startPos, i+1);
        address = symbolTable.indexOf (referent);
        if (address == -1) 
        {          
          symbolTable.add (referent);
          address = symbolTable.size() - 1;          
        } // if referent not in symbolTable        
      } // IDENTIFIER
      else
      {
        
        theOperator = new String();
        switch (infix.charAt (i)) 
        {          
          case '+': ;
          case '-':
            category = ADD_OP;
            theOperator += infix.charAt (i);
            break;
            
          case '*': ;
          case '/':
            category = MULT_OP;
            theOperator += infix.charAt (i);
            break;
            
          case '(':
            category = LEFT_PAR;
            theOperator += infix.charAt (i);
            break;
            
          case ')':
            category = RIGHT_PAR;
            theOperator += infix.charAt (i);
            break;
            
          default:
            error.setCategory (Error.BAD_CHAR);
            error.setPosition (i);            
        } // switch        
      } // inner else      
    } // outer else
    i++;
    return i;    
  } // method getToken
  
  
  /**
   * Returns the appropriate error if the calling token is incompatible 
   * with the previous token.
   * 
   * @param previousToken a Token which will be compared with the
   *                      previous Token.
   * 
   * @return an Error that describes which, if any, error has occured.
   */
  public Error checkPrevious (Token previousToken) 
  {    
    Error error = new Error();
    error.setCategory (Error.ERROR_MATRIX [previousToken.category]
                         [category]);
    if (error.categoryOf() == Error.OP_LAST)
      error.setPosition (previousToken.startPosOf());
    else
      error.setPosition (startPosOf());
    return error;
  } // checkPrevious
  
  
  /**
   * Returns the category of the calling token's.
   * 
   * @return an int that indicates what catagory the Token is in.
   */
  public int categoryOf() 
  {    
    return category;    
  } // method categoryOf
  

  /**
   * Returns the calling token's address in symbolTable.
   * 
   * @return an int representing the Tokens address.
   */
  public int addressOf() 
  {    
    return address;    
  } // method addressOf
  
  
  /**
   * Returns the calling token's operator.
   * 
   * @return a String representing the Token's operator.
   */
  public String operatorOf() 
  {    
    return theOperator;    
  } // method operatorOf
  
  
  /**
   * Returns the calling token's starting position in the infix string.
   * 
   * @return an int representing the token's starting position.
   */
  public int startPosOf() 
  {    
    return startPos;    
  } // method startPosOf  
  
} // class Token
