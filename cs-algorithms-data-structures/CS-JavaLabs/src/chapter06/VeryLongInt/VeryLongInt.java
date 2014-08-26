package chapter06.VeryLongInt;
import java.util.*;

public class VeryLongInt
{
    protected ArrayList<Integer> digits;
       
    /** 
     *  Initializes this VeryLongInt object from the digit characters in a given String object.  
     *  The worstTime(n) is O(n), where n represents the number of characters in s.  There
     *  are no leading zeroes, except for 0 itself, which has a single '0'.
     *
     *  @param s - the given String object.
     *
     *  @throws NullPointerException - if s is null.
     *  @throws IllegalArgumentException - if s contains no digit characters.
     *
     */  
    public VeryLongInt (String s) 
    {
        final char LOWEST_DIGIT_CHAR = '0';

        digits = new ArrayList<Integer> (s.length());

        char c;

        int digit;
        
        boolean atLeastOneDigit = false;

        for (int i = 0; i < s.length(); i++) 
        {
            c = s.charAt (i);
            if (Character.isDigit(c))
            {
                digit = c - LOWEST_DIGIT_CHAR;
                digits.add (digit);   // digit is boxed to an Integer object
                atLeastOneDigit = true;
            } //  if a digit
        } // for
        if (!atLeastOneDigit)
            throw new IllegalArgumentException();            
    } // constructor with string parameter


    /** Returns a String representation of this VeryLongInt object. The worstTime(n) is 
     *  O(n), where n represents the number of digits in this VeryLongInt object. 
     *
     *  @return a String representation of this VeryLongInt object in the form 
     *  [ followed by the digits, separated by commas and single spaces, followed
     *  by ].
     *
     */ 
    public String toString() 
    {
        return digits.toString();
    } // method toString
 

    /** 
     *  Increments this VeryLongInt object by a specified VeryLongInt object.
     *  The worstTime(n) is O(n), where n is the number of digits in the larger of this 
     *  VeryLongInt object (before the call) and the specified VeryLongInt object.
     *
     *  @param otherVeryLong - the specified VeryLongInt object to be added to
     *                         this VeryLongInt object.
     *
     *  @throws NullPointerException - if otherVeryLong is null.
     *
     */  
    public void add (VeryLongInt otherVeryLong) 
    {
        final int BASE = 10;

        int largerSize,
            partialSum,
            carry = 0;
  
        if (digits.size() > otherVeryLong.digits.size())
            largerSize = digits.size();
        else
            largerSize = otherVeryLong.digits.size();

        ArrayList<Integer> sumDigits = new ArrayList<Integer>(largerSize + 1);

        for (int i = 0; i < largerSize; i++) 
        {
            partialSum = least (i) + otherVeryLong.least (i) + carry;
            carry  = partialSum / BASE;
            sumDigits.add (partialSum % BASE);
        } // for

        if (carry == 1)
            sumDigits.add (carry);
        Collections.reverse (sumDigits);
        digits = sumDigits;        
 } // method add


    /** Returns the ith least significant digit in digits if i is a non-negative int less than
     *  digits.size().  Otherwise, returns 0.
     *
     *  @param i - the number of positions from the right-most digit in digits to the 
     *                 digit sought.
     *
     *  @return the ith least significant digit in digits, or 0 if there is no such digit.
     *
     *  @throws IndexOutOfBoundsException - if i is negative.
     * 
     */
    protected int least (int i) 
    {
        if (i >= digits.size())
            return 0;
        return digits.get (digits.size() - i - 1);
    } // least
            
} // class VeryLongInt
