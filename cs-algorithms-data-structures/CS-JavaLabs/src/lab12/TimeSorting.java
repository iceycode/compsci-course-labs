package lab12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;

/** TimeSorting.java
 * 
 * - times and tests sorting of students.dat according to 3 algorithms
 *  -- Bubble sort, Insertion sort & Selection sort
 * - 
 * 
 * @author Allen Jagoda Lab 12
 * @param <E>
 * @param <E>
 *
 */

public class TimeSorting<E>  {

	public final String SECONDS = " seconds";
	public final String TIME_MERGE = "Mergesort of data file takes " ;
	public final String TIME_HEAP = "Heapsort of data file takes ";
	public final String TIME_QUICK = "Quicksort of data file takes ";
	public final String SORTED = "\n----ARRAY SORTED-----\n" ;

	public static void main (String[ ] args)
	{
		try {
			new TimeSorting().run();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	} // method main

	public void run() throws FileNotFoundException{

		for (int i = 0; i < 3; i++){
			Student[] tempArr = makeArr();
			if (i == 0)
				System.out.println(TIME_MERGE + new DecimalFormat("#.###").format(timer(tempArr, i))
						+ SECONDS);
			else if (i == 1)
				System.out.println(TIME_HEAP + new DecimalFormat("#.###").format(timer(tempArr, i)) 
						+ SECONDS); //added extra places for seconds
			else
				System.out.println(TIME_QUICK + new DecimalFormat("#.###").format(timer(tempArr, i)) 
						+ SECONDS);
		}//prints time to 3 sig figs		
	}
	
	public Student[] makeArr() throws FileNotFoundException{
		//file location on my comp /Users/Allen/Google Drive/ajagoda@u.rochester.edu/workspace/CS401 Labs/src/lab11/students.dat

		String fileLocation = "/Users/Allen/Google Drive/ajagoda@u.rochester.edu/workspace/CS401 Labs/src/lab12/students.dat";
		FileReader file = new FileReader(fileLocation);

		Scanner sc = new Scanner(file);

		//StudentSorter b = new StudentSorter(); //to sort sArray using StudentSorter
		//		Comparator<Student> comp = new StudentComparator();
		//		PriorityQueue<Student> pq = new PriorityQueue<Student>(3780, comp);

		Student[] sArray = new Student[3380];
		int index = 0;

		while (sc.hasNextLine()){
			Student s1 = new Student(sc.nextLine());
			//pq.add(s1);
			sArray[index] = s1; 
			index++;
		}
		return sArray;
	}//create new array out of students.dat

	public double timer(Student[] tempArr, int i){
		double startTime, finishTime = 0; 
		if (i == 0){
			startTime = System.nanoTime();//------START TIME-----
			DCSorter ms = new DCSorter();   //sort sArray
			Student[] sortedSArray = (Student[]) ms.mergeSort(tempArr);
			finishTime = System.nanoTime();  //-------END TIME--------
		}
		else if (i == 1){
			startTime = System.nanoTime();//------START TIME-----
			DCSorter hs = new DCSorter();   //sort sArray
			Student[] sortedSArray = (Student[])hs.heapSort_1((Comparable[]) tempArr);
			finishTime = System.nanoTime();  //-------END TIME--------
			//printArray(sortedSArray); //for testing purposes
		}
		else{
			startTime = System.nanoTime();//------START TIME-----
			DCSorter qs = new DCSorter();   //sort sArray
			Student[] sortedSArray = (Student[])qs.quickSort(tempArr);
			finishTime = System.nanoTime();  //-------END TIME--------
			//printArray(sortedSArray); //for testing purposes
		}

		//calculating elapsed time for bubbleSort
		double elapsedTime = finishTime - startTime;
		return ((double)elapsedTime/1000000000);
	}


	public void printArray(Student[] sArray){
		for (int i = 0; i < sArray.length; i++){
			System.out.println(sArray[i].toString());
		}
	}//method for printing array
}
