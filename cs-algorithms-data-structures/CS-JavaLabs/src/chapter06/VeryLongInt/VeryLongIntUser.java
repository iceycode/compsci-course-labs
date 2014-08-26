package chapter06.VeryLongInt;

import java.util.*;

public class VeryLongIntUser
{
    public static void main (String[] args)
    {
        new VeryLongIntUser().run();
    } // method main
    
    public void run()
    {
        final String SENTINEL = "***";
        
        final String INPUT_PROMPT = "On the line, please enter a method identifier " +
            "and, if needed, an argument (or enter " + SENTINEL + " to quit): ";
         
        final String STRING_CONSTRUCTOR = "VeryLongInt";

        final String TO_STRING = "toString";

        final String ADD = "add";

        final String VERY_LONG_MESSAGE = "Here is the VeryLongInt: ";

        final String BAD_METHOD =
                    "The line entered does not represent a legal method.";
        
        Scanner sc = new Scanner (System.in),
                lineScanner;

        String line,               
               method,
               argument;
         
        VeryLongInt veryLong = null,
                    otherVeryLong;
  
         while (true)
         {
             try
             {   
                 System.out.println (INPUT_PROMPT);
                 line = sc.nextLine(); 
                 if (line.equals (SENTINEL))
                     break;
                 veryLong = process (line, veryLong);                 
                 System.out.println (VERY_LONG_MESSAGE + veryLong + "\n\n");
             } // try
             catch (Exception e)
             {
                  System.out.println (e + "\n\n");
             } // catch Exception              
          } // while
    } // method run
    
    /**
     *  Parses the given line and calls the method specified in the line.
     * 
     *  @param line - the given line
     *  @param veryLong - the VeryLongInt object that calls the method specified.
     * 
     *  @return the VeryLongInt object resulting from the method call.
     * 
     *  @throws IllegalArgumentException - if the method is not legal or if the
     *          method's argument has no digit characters
     *  @throws NoSuchElementException - if the line is a string with fewer
     *          than two tokens 
     *  @throws NullPointerException - if line is null or if veryLong is null
     *          and the add method is called with a legal argument
     */
    public VeryLongInt process (String line, VeryLongInt veryLong)
    {
        final String STRING_CONSTRUCTOR = "VeryLongInt";

        final String TO_STRING = "toString";

        final String ADD = "add";
        
        final String BAD_METHOD =
            "The line entered does not represent a legal method.";
        
        VeryLongInt otherVeryLong;
        
        String method,
               argument;
        
        Scanner lineScanner = new Scanner (line);                 
               
        method = lineScanner.next();                 
        if (method.equals (STRING_CONSTRUCTOR))
        {
            argument = lineScanner.next();                 
            veryLong = new VeryLongInt (argument);
        } // string constructor
        else if (method.equals (TO_STRING))
        {
        } // toString method        
        else if (method.equals (ADD))
        {
            argument = lineScanner.next();
            otherVeryLong = new VeryLongInt (argument);
            veryLong.add (otherVeryLong);                     
        } // add method        
        else
            throw new IllegalArgumentException (BAD_METHOD);     
        return veryLong;
    } // method process
    
} // class VeryLongIntUser
