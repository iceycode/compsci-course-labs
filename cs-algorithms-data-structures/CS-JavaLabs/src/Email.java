/*	HYPOTHESIS
 * 	- 
 * 
 */

import java.io.*;
import java.util.*;

public class Email
{      
   
    public static void main (String[] args) throws FileNotFoundException
    {
        new Email().run();        
    } // method main
    
    public void run() throws FileNotFoundException
    {
    	//string declaration
        final String IN_FILE_PROMPT = "Please enter the path for the input file: ";
        
        // Declare and initialize a scanner over input from keyboard:
        Scanner keyScanner = new Scanner(System.in);
        
        System.out.print (IN_FILE_PROMPT);
        
        // Read in the name of the input file:
        String filename = keyScanner.nextLine();		//reads the file name, nextLine skips whitespace
        Scanner fileScan = new Scanner (new File (filename));  
        
        /*CODE FOUND IN LAB*/
        System.out.println(filename); //filename is used to print the input file name
        
        // Declare and initialize a scanner over the input file:
        Scanner scanFile = new Scanner (new File (filename));
        
        // Declare, but do not initialize, a scanner over one line of text in the input file:
        Scanner line = null;
        
        /*CODE FOUND IN LAB*/
        Scanner lineScanner = null;
        
        
        /*CODE FOUND IN LAB*/
        String candidate = null;
        
        /*CODE FOUND IN LAB*/
        while (line.hasNextLine() == true)/* there are more lines left to scan in the input file
        .... returns a false if none....can be the same as lineScanner.hasNextline() */
        {
            // Initialize the line scanner to recognize an e-mail address (with the useDelimiter method): 
        	lineScanner.useDelimiter("[^@.]+*");   //delimiter method uses @ and . for occurences
        	
        	/*while (line.hasNext()) {
                if (line.hasNextDouble()) {
                    sum += line.nextDouble();
                } else {
                	line.next();
                }   
            }*/

            while (lineScanner.hasNext())   /* there are more candidates in the current line...
            ...returns a false if no tokens ahead */
            {
                // Get the next candidate from the line scanner:
            	
            	
            	/*CODE FOUND IN LAB*/
                int atSignPos = candidate.indexOf ("@");
                if (atSignPos==1) /* the candidate has exactly one "@" and at least one "." after the "@" */
                	
                    System.out.println (candidate);               
            } // while more candidates in current line
        } // while more lines left to scan
    } // method run
      
} // class EMail
