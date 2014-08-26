package lab07;

/*See Lab 15 on converting infix to postfix, and Concept Exercise 8.8. 
 * 1) construct postfix queue CHECK
 * 2) create values ArrayList<Integer> CHECK
 * 3) create runTimeStack<E> for boolean & integer elements
 * 
 * 
 * After constructing the postfix queue,
create values, an ArrayList object with Integer elements. The values object corresponds to symbolTable,
the ArrayList of identifiers. Use a stack, runTimeStack, for pushing and popping Integer and Boolean
elements. Because runTimeStack contains both Integer and Boolean elements, it should not have a type
argument
 * 
 */

import java.util.*;
import java.util.Stack;

/** EvalExpression.java
 * - uses stacks & queues to evaluated an expression
 * - 
 * - user inputs a comparison expression with variables 
 * 		ie; b*a > a+c
 * - user then enters a value for those; 
 * 		Please enter value: 6 ...2...7 (b = 6, a=2, c=7)
 * - precedence of operators as follows (top to bottom):
	 	*, /, %
		+, - (that is, integer addition and subtraction)
		>, >=, <=, <
		==, !=
		&&
		|| <
 * 
 * postfix queue constructed from initial condition
 * after integers go in, stack used to insert
 * 
 * - Main outline of events to process:
 * 1) construct postfix queue from input
 * 2) create values within ArrayList<Integer> to evaluate order
 * 3) use a stack<E> for both Int and Bool inserts
 * 
 * @author Allen Jagoda 
 * @param <E>
 *
 */

public class EvalExpression<E> 
{  
  protected Stack<EvalToken> operatorStack = new Stack<EvalToken>(); //contains operators

  protected EvalError error = new EvalError();

  protected Queue<EvalToken> postfix = new LinkedList<EvalToken>(); //postfix expression queue

  //gets the 
  protected ArrayList<String> symbolTable = new ArrayList<String>(); //symbols for converting infix to postfix
  
  //************ values: ArrayList<Integer> correspond to symbolTable*****************
  protected ArrayList<Integer> values = new ArrayList<Integer>(); 
  
  //********runTimeStack<E> for int & bool elements***********
  protected Stack<E> runTimeStack = new Stack<E>();

  /*
   * Initializes this EvalExpression object.
   */
  public EvalExpression() { } // default constructor

  
  /**
   * Generates the postfix form of the infix string, provided that 
   * string contains no errors.  Otherwise, generates an error message.
   * 
   * @param infix - a String that is the entered infix line.
   */
  public void convertOrReject (String infix) 
  {  
    EvalToken previousEvalToken = new EvalToken();
    
    int i = 0;
    
    previousEvalToken.makeEmpty ();
    
    while (i <= infix.length ()) 
    {
      EvalToken infixEvalToken = new EvalToken();
      i = infixEvalToken.getToken(symbolTable, i, infix, error);
      /*if (error.categoryOf() == EvalError.NONE) 
      { */       
	    //error = infixEvalToken.checkPrevious (previousEvalToken);
	    //if (error.categoryOf() == EvalError.NONE) {          
	      applyTransMatrix (infixEvalToken);
	      previousEvalToken = infixEvalToken;
        //} // if no error after checking previous EvalToken        
      //} // if no error from the EvalToken itself      
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
    
      info = POSTFIX_INTRO;
      while (!postfix.isEmpty()) 
      {
        EvalToken EvalToken = postfix.remove();
        if (EvalToken.categoryOf() == EvalToken.IDENTIFIER)
          info += symbolTable.get(EvalToken.addressOf());
        else
          info += EvalToken.operatorOf();
        info += BLANK;
      } // while     

    while (!operatorStack.isEmpty())
      operatorStack.pop();
    while (!postfix.isEmpty())
      postfix.remove();
    
    symbolTable.clear();
    return info;
  } // method returnPostfixOrError
  
  
  /**
   * Process the infixEvalToken.
   * 
   * @param infixEvalToken a EvalToken that will be applied to transMatrix.
   */
  public void applyTransMatrix (EvalToken infixEvalToken) 
  {    
    final int ADD_TO_POSTFIX = 0;
    
    final int POP_OPSTACK = 1;
    
    final int UNMATCHED_LEFT = 2;
    final int UNMATCHED_RIGHT = 3; 
    
    final int PUSH_ON_OPSTACK = 4;
    
    final int POP_TO_POSTFIX = 5;
    
    final int DONE = 6;
    
    ArrayList<ArrayList<Integer>> transCollection = new ArrayList<ArrayList<Integer>>(Arrays.asList(
    	new ArrayList<Integer>(Arrays.asList(ADD_TO_POSTFIX, POP_OPSTACK, PUSH_ON_OPSTACK, POP_TO_POSTFIX, DONE)),
    		new ArrayList<Integer>(Arrays.asList(ADD_TO_POSTFIX, POP_OPSTACK, PUSH_ON_OPSTACK, POP_TO_POSTFIX))));
    
    //two ArrayLists to get values from transCollection
    ArrayList<Integer> list1 = new ArrayList<Integer>();
    ArrayList<Integer> list2 = new ArrayList<Integer>();

    
    int catInfix = list1.get(infixEvalToken.categoryOf()); //get category of infix
    
    
    int[][] transMatrix  = {      
      { ADD_TO_POSTFIX,  ADD_TO_POSTFIX,  ADD_TO_POSTFIX,  ADD_TO_POSTFIX },    //0
      { POP_OPSTACK,     POP_TO_POSTFIX,  POP_TO_POSTFIX,  UNMATCHED_RIGHT },   //1
      { PUSH_ON_OPSTACK, PUSH_ON_OPSTACK, PUSH_ON_OPSTACK, PUSH_ON_OPSTACK },   //2
      { PUSH_ON_OPSTACK, POP_TO_POSTFIX,  POP_TO_POSTFIX,  PUSH_ON_OPSTACK },   //3
      { PUSH_ON_OPSTACK, PUSH_ON_OPSTACK, POP_TO_POSTFIX,  PUSH_ON_OPSTACK },   //4
      { UNMATCHED_LEFT,  POP_TO_POSTFIX,  POP_TO_POSTFIX,  DONE }      			//5  -- DONE
    }; // transMatrix       */       
    
    boolean processingComplete;  // the processing of the current
         						// infix EvalToken has been completed
    EvalToken stackEvalToken;
    
    do 
    {      
      stackEvalToken = new EvalToken();
      EvalToken prevEvalToken = new EvalToken();
      prevEvalToken = infixEvalToken;
      
      processingComplete = true;
      
      // Get the top EvalToken on operatorStack:
      if (operatorStack.isEmpty())
          stackEvalToken.makeEmpty();
      else	
          stackEvalToken = operatorStack.peek();
      
      int catStack = list2.get(stackEvalToken.categoryOf()); //get category of previous operatorStack element
      
      if (catInfix == 0){
    	  postfix.add(infixEvalToken);
      } //add identifier to postfix
      else if ((catInfix >=3 && catInfix <= 8) && operatorStack.isEmpty()){
    	  operatorStack.pop();
      }
      else if ((catInfix >=3 && catInfix <= 8) && !operatorStack.isEmpty() && !postfix.contains('(')){
    	  postfix.add(operatorStack.pop()); //pops 1st op off stack
          operatorStack.push (infixEvalToken); //pushes next op onto operatorStack
          break;
      }
      
      // Apply the transition matrix:
      // the -2 is because the first two categories are skipped
     //original switch case: transMatrix [infixEvalToken.categoryOf()][stackEvalToken.categoryOf()-2]
      /*switch ()  
          {        
            case ADD_TO_POSTFIX:
              postfix.add (infixEvalToken);
              break;
              
            case POP_OPSTACK: //for within parenthesis
              operatorStack.pop();
              break;

            case PUSH_ON_OPSTACK:
              operatorStack.push (infixEvalToken);
              break;
             
            //*******************pops what is in opstack into queue postfix **********
            case POP_TO_POSTFIX:
              postfix.add(operatorStack.pop()); //pops 1st op off stack
              operatorStack.push (infixEvalToken); //pushes next op onto operatorStack
              break;
              
            case DONE:
              //postfix.add(operatorStack.pop());
              break; // take no action
          } // switch      */
      
      
    	}// do 
     	while (!processingComplete);
    }  // method applyTransMatrix  
  
  public void addValues(int i){
	  values.add(i);
  }
  
 /* 
  public boolean evalPostfix(EvalToken exprInfix){
	  
	  boolean bool = false;
	  
	  String prevID = ""; //holds string ID that isLetter
	  int num = 0; //values obtained from values ArrayList
	  	  
	  for (int i = 0; i < values.size(); i++){
		  String currentID = symbolTable.remove(i);
		  
		  
		  //if (symbolTable.get(i)){
		  
		  if (currentID != prevID)
			  runTimeStack.push((E)values.get(i));
		  
		  //convertOrReject (currentID); 
		  
		  prevID = currentID; //assigning current to previousID
		  
		  
	  }//put input into runTimeStack
	  
	  return bool;
  }*/
  
} // class EvalExpression
