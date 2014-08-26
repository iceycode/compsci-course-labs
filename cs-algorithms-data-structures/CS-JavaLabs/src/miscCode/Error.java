package miscCode;

public class Error 
{
  public static final int NONE = 0;
  public static final int BAD_CHAR = 1;
  public static final int OP_FIRST = 2;
  public static final int OP_LAST = 3;
  public static final int IDENT_IDENT = 4;
  public static final int RIGHT_IDENT = 5;
  public static final int OP_OP = 6;
  public static final int OP_RIGHT = 7;
  public static final int IDENT_LEFT = 8;
  public static final int LEFT_RIGHT = 9;
  public static final int LEFT_OP = 10;
  public static final int RIGHT_LEFT = 11;
  public static final int NO_RIGHT = 12;
  public static final int NO_LEFT = 13;
  
  
  public final static int[][] ERROR_MATRIX = 
  {  
    { IDENT_IDENT, NONE,      IDENT_LEFT, NONE,    NONE,    NONE },
    { RIGHT_IDENT, NONE,      RIGHT_LEFT, NONE,    NONE,    NONE },
    { NONE,       LEFT_RIGHT, NONE,      LEFT_OP,  LEFT_OP,  NO_RIGHT },
    { NONE,       OP_RIGHT,   NONE,      OP_OP,    OP_OP,    OP_LAST },
    { NONE,       OP_RIGHT,   NONE,      OP_OP,    OP_OP,    OP_LAST },
    { NONE,       NO_LEFT,    NONE,      OP_FIRST, OP_FIRST, NONE } 
  }; //  ERROR_MATRIX
  
  
  public final static String[] ERROR_MESSAGE = 
  {  
    "",
    "Illegal character",
    "First character an operator",
    "last character an operator",
    "Identifier preceded by an identifier",
    "Identifier preceded by a right parenthesis",
    "Operator preceded by an operator",
    "Right parenthesis preceded by an operator",
    "Left parenthesis preceded by an identifier",
    "Right parenthesis preceded by a left parenthesis",
    "Operator preceded by a left parenthesis",
    "Left parenthesis preceded by a right parenthesis",
    "Unmatched left parenthesis",
    "Unmatched right parenthesis"  
  }; // ERROR_MESSAGE
  
  
  protected int category,
                position;
  
  public int categoryOf() 
  {  
    return category; 
  } // method categoryOf
  
  
  public void setCategory (int newCategory) 
  {  
    category = newCategory; 
  } // method setCategory
  
  
  public int positionOf() 
  {  
    return position; 
  } // method positionOf
  
  
  public void setPosition (int newPosition) 
  {  
    position = newPosition; 
  } // method setPosition
   
} // Error