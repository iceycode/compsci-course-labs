package lab01;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * LAB 1 INSTRUCTIONS
 * 
 * Write a simple java program to measure fuel economy. You may choose how
   exactly you want to do this. Your program may calculate miles per gallon, kilometers per
   liter, gallons per hour or some other metric for evaluating fuel economy of your
   choosing.
 * INPUT: distance traveled (or time) & the fuel consumed
 	Example Output
    Miles traveled: 100
	Gallons of fuel consumed:3.2
	Average MPG: 31.25 
 * 
 * @author Allen Jagoda 
 * CS401 Lab 01, due 01/20/13
 * 
 */

public class MPGCalculator {
	
	
	public static void main(String[] args) {
		
		new MPGCalculator().run();
		
	} //main method
	
    public void run() {

    	//Prompts users to enter the distance traveled & fuel consumed
    	String PROMPT_1 = "Enter the distance traveled: ";
		String PROMPT_2 = "Enter the amount of fuel consumed in gallons: ";
		
		//outputs the string before data
		String OUTPUT_1 = "Miles driven: ";		
		String OUTPUT_2 = "Gallons of fuel consumed: ";
		String OUTPUT_3 = "Your Miles per Gallon: ";
		
		//scans for user keyboard input
		Scanner s = new Scanner (System.in);
		
		//user inputs distance
		System.out.println(PROMPT_1);	//prompt for user to input
		double distance = s.nextDouble(); // user inputs distance traveled
		
		//user inputs the fuel consumed
		System.out.println(PROMPT_2);	//prompt for user to input
		double fuelAmt = s.nextDouble(); //user input fuel amount consumed
				
		//outputs the relevant information-, fuel consumed & result, respectively
		System.out.println(OUTPUT_1 + distance);  //distance
		System.out.println(OUTPUT_2 + fuelAmt);   //fuel
		System.out.println(OUTPUT_3 + calcMPG(distance, fuelAmt));  //Miles per Gallon (MPG)

    } //run method
    
    public double roundMPG (double d){
    	//make use of DecimalFormat class
    	DecimalFormat df3 = new DecimalFormat("000.000");
    	
        return Double.valueOf(df3.format(d)); //returns double formated using valueOf
    } //class method roundMPG3 - rounds the miles per gallon to the 3rd decimal place
    
    public double calcMPG (double distance, double fuelAmt){
    	
    	double result = distance/fuelAmt; //returns 
    	
    	return roundMPG(result); //returns rounded MPG
    }//class method calculates & returns mpg, rounded to 3rd decimal place

}//MPGCalculator.java
