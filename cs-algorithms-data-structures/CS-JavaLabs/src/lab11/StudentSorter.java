package lab11;

import java.util.Comparator;


/**  StudentSorter.java
 * ----contains sorting procedures: BubbleSort, InsertionSort & SelectionSort
 * - TestSortMethods.java is jUnit test for sorting methods
 * 	- tests to see that array actually sorted
 * @author Allen Jagoda
 *
 */


public class StudentSorter implements Comparator<Student>{
	
	
	private Student[] arr; //element of array	
	private int size;
		
	public StudentSorter(){
		int i = 0;
		
	}//constructor
	
	
	//-----------getter & setter methods---------
	public Student[] getArr() {
		return arr;
	}
	
	public int getSize(){
		return size;
	}


	public void setArr(Student[] arr) {
		this.arr = arr;
	}
	
	public void setSize(int size){
		this.size = size;
	}

	public Student[] sort(Student[] sArray){
		return bubbleSort(sArray);
		
	}
	//---------getter & setter methods---------
	
	//--------SORTING METHODS-----------
	
    /* .......BUBBLESORT....
     * PSEUDOCODE:
	   procedure bubbleSort( A : list of sortable items )
	   n = length(A)
	   repeat     
	     swapped = false
	     for i = 1 to  n-1 inclusive do
	       //if this pair is out of order //
	       if A[i-1] > A[i] then
	         // swap them and remember something changed //
	         swap( A[i-1], A[i] )
	         swapped = true
	       end if
	     end for
		   until not swapped
		end procedure
	 */
    @SuppressWarnings("rawtypes")
	public Student[] bubbleSort(Student[] arr){
    	int n = arr.length; //n is size of array
    	boolean swapped = true; //begins first pass
    	
    	while (swapped){
    		swapped = false; //set to false until swap occurs
	    	for (int i = 0; i < n-1; i++){
				if ( compare(arr[i], arr[i+1]) < 0){
					swap(arr, i, i+1); //swapping element at pos j with i
					swapped = true; //swap occured
				}//if less then, then swap
	    	}
    	} //while swapped is true
		return arr;
    }//returns sorted array in O(n^2) time
    
    /*.......SELECTION SORT.......
     * PSEUDOCODE:
         procedure selectionSort( A : list of sortable items )
	   	 n = length(A)
	     for i = 1 to  n-1 inclusive do
	       //get min value
	       iMin = i
	       for j = i+1 to n inclusive do
	       		if A[iMin] > A[j] then
	         	//set to new min of j
	         		iMin = j
	       		end if
	       end for
	       if (iMin != i)
	       		swap(a[i], a[iMin])
	       end if
	     end for
	  end procedure
     * iterates & compares elements through entire array
     *  till smallest value found
     */
    public Student[] selectionSort(Student[] arr){
    	int n = arr.length;
    	int iMin = 0;
    	
    	for (int i = 0; i < n-1; i++){
    		iMin = i;
    		for (int j = i+1; j < n; j++){
    			if (compare(arr[iMin], arr[j]) < 0)
    				iMin = j;
    		}//compare value at index i to others
    		if (iMin != i) {
    			arr = swap(arr, i, iMin); 
    		}//swap values at indices i & iMin
    	}//look at all values of array for comparisons
    	
    	return arr;
    }//returns sorted array in O(n^2) time
    
    /*.......INSERTION SORT.......
     * PSEUDOCODE:
     procedure insertionSort(A: list of sortable items)
     n = length(A)
     for i = 1 to n inclusive, do
     	j = i
     	while j > 0 and A[j-1] > A[j], do
     		swap(A[j], A[j-1]
     		j = j -1
     	end while j <= 0 and A[j-1] <= A[j]
     end for
     end procedure
     */
    @SuppressWarnings("rawtypes")
	public Student[] insertionSort(Student[] arr){
    	int n = arr.length;
    	
    	for (int i = 1; i < n; i++) {
    		Student temp = arr[i];
            int j = i;
            while (j > 0 && compare(temp,arr[j-1]) > 0) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    	return arr;
    }//returns sorted array - does not use swap method
    
    //-----------SWAP & COMPARE METHODS---------
    /*
     * implemented by sorting methods
     */
    public Student[] swap(Student[] arr, int i, int j){
		
    	Student temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    	return arr;
    }
    
	@Override	
	public int compare(Student s1, Student s2) {
		//initialize comparison value for last name
    	int compValue = s2.getNameLast().compareTo(s1.getNameLast());
    	
        if (compValue == 0){
        	compValue = s2.getNameFirst().compareTo(s1.getNameFirst());
        	if (compValue == 0){
        		compValue = s2.getNameMiddle().compareTo(s1.getNameMiddle());
        		if (compValue == 0){
        			Double d1 = new Double(s1.getId());//convert to double
        			Double d2 = new Double(s2.getId());
        			double idValue = d2.compareTo(d1);
        			if (idValue > 0)
        				return 1;
        			else 
        				return -1;
        		}//lastly even if middle names match
        		return compValue;
        	}//if first name match
        	return compValue;
        } //if last last name is same
        return compValue; //return value whether in front or behind
	}
    
    
	
}
