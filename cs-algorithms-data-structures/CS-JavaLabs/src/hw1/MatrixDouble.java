package hw1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/** Multiply square matrices of random values (real numbers & multiplies them
 * - user determines size of the matrix, random numbers generated inside the matrix
 * - basic multiplication rule of matrices followed (row * column values + row * columns)
 * - measures execution run time by checking times before & after program execution
 * - randomly generates integers in matrices & returns run time
 * 
 * @author Allen Jagoda CS402 HW1 problem 7
 *
 */

public class MatrixDouble {

	public static void main(String[] args) throws InputMismatchException{
		
		System.out.println("Enter the size of both matrices to be multiplied: ");
		Scanner s = new Scanner(System.in); //scanner object
		int side = s.nextInt(); //user inputs integer which will be length of matrix
		
		long startTime = System.nanoTime(); //start time for int matrix
		
		//m1 & m2 are both matrices
		double m1[][] = new double[side][side];
		double m2[][] = new double[side][side];
		
		//get the random matrixes of user size
		m1 = arandMatrix(side);
		m2 = arandMatrix(side);

		double finalMatrix[][] = multiply(m1, m2, side);
		
		//display end product of matrices
		for (int i = 0; i < side; i++){
			for (int j = 0; j < side; j++){
				System.out.print(finalMatrix[i][j] + "  ");
			} //prints out column value of matrix
			System.out.println(); //to next row
		}
		
		long endTime   = System.nanoTime(); //end time
		
		long totalTime = endTime - startTime; //total time
		System.out.println("Run time is " + totalTime); //print total time

	}//main method
	
	public static double[][] arandMatrix(int s){
		Random rand = new Random();; //random number
		double[][] randMatrix = new double[s][s]; //random matrix object
		
		for (int i = 0; i < s; i++){
			for (int j = 0; j < s; j++){
				double r = rand.nextDouble()*100; //random between 0 & 1 times 100
				randMatrix[i][j] = r; //assign rand value to that place
			}
		}
		return randMatrix;
	}//returns the matrix as an array form 
	
	public static double[][] multiply(double[][]m1, double[][]m2, int s){
		
		double total = 0; //total for each row x col value
		
		double[][] resultMatrix = new double[s][s];
		int i, j = 0; //i is row, j is column
		
		for (i = 0; i < s; i++){
			for (j = 0; j < s; j++){
				for (int k = 0; k < s; k++){
					total += m1[i][k] + m2[k][j]; 				
				}//multiply & sum up row/column values
				
				resultMatrix[i][j] = total;
				total = 0; //reset total to 0
			}//columns of matrix
		}//rows of new matrix
		
		return resultMatrix;
	}//method that takes 2 matrices, their size & returns multiplied value
	
	
}
