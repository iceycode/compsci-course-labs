package hw1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/** Multiply square matrices of random values (real numbers)
 * - this program takes the input of square matrices of equal & multiplies them
 * - user determines size of the matrix, random numbers generated inside the matrix
 * - basic multiplication rule of matrices followed (row1 * column1 + row12 * column22 + ....)
 * - measures execution run time by checking times before & after program execution
 * - randomly generates integers in matrices & returns run time
 * 
 * @author Allen Jagoda CS402 HW1 problem 7
 *
 */

public class MatrixInt {

	public static void main(String[] args) throws InputMismatchException{
		
		System.out.println("Enter the size of both matrices to be multiplied: ");
		Scanner s = new Scanner(System.in); //scanner object
		int side = s.nextInt(); //user inputs integer which will be length of matrix
		
		long startTime = System.nanoTime(); //start time for int matrix
		
		//m1 & m2 are both matrices
		int m1[][] = new int[side][side];
		int m2[][] = new int[side][side];
		
		//get the random matrixes of user size
		m1 = arandMatrix(side);
		m2 = arandMatrix(side);

		int finalMatrix[][] = multiply(m1, m2, side);
		
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
	
	public static int[][] arandMatrix(int s){
		Random rand = new Random();; //random number
		int[][] randMatrix = new int[s][s]; //random matrix object
		
		for (int i = 0; i < s; i++){
			for (int j = 0; j < s; j++){
				int r = rand.nextInt(100); //random between 0 & 100
				randMatrix[i][j] = r; //assign rand value to that place
			}
		}
		return randMatrix;
	}//returns the matrix as an array form 
	
	public static int[][] multiply(int[][]m1, int[][]m2, int s){
		
		int total = 0; //total for each row x col value
		
		int[][] resultMatrix = new int[s][s];
		int i, j = 0; //i is row, j is column
		
		for (i = 0; i < s; i++){
			for (j = 0; j < s; j++){
				for (int k = 0; k < s; k++){
					total += m1[i][k] + m2[k][j]; 				
				}//multiply & sum up row/column values
				
				resultMatrix[i][j] = total;
				total = 0;
			}//columns of matrix
		}//rows of new matrix
		
		return resultMatrix;
	}//method that takes 2 matrices, their size & returns multiplied value
	
	
}

