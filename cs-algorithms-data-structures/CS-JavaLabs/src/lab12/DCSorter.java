package lab12;

import java.util.Comparator;
import java.util.PriorityQueue;

/** DCSorter
 * 
 * - contains the divide-and-conquer (DC) methods:
 *    Heapsort, Mergesort & Quicksort
 * 
 * @author Allen Jagoda Lab 12
 * @param <E>
 *
 */

public class DCSorter<E> implements Comparator<E>{

	
	//------------HEAPSORT (& related methods)-------------
	
	
	
	/** PSEUDOCODE
	 * procedure heapsort : arr
	 * 	heapify (arr) //largest val at root
	 *  end = count - 1
	 *  while end > 0 do
	 *     swap(arr[end], a[0]
	 *     end = end - 1
	 *     siftDown(a,0, end) //since swap ruined heap property
	 * 
	 * procedure siftDown : a, start, end //see method in priority queue
	 */
	public E[] heapSort_1(E[] sArr){
		sArr = maxHeapify(sArr);
		
		for (int heapsize = sArr.length; heapsize > 0; ){
			swap(sArr, 0, --heapsize);
			int index = 0; //index of element that goes into sorted arr
			
			while (true){
				int left = (index*2) + 1; //left child of parent
				if (left >= heapsize)
					break; //left node does not exist
				int right = left + 1; 
				if (right >=heapsize){
					if (compare(sArr[left], sArr[index])>0)
						swap(sArr, left, index);
					break;
				}//has left but no right child
				if (compare(sArr[left], sArr[index])>0){
					if (compare(sArr[left], sArr[right])>0){
						swap(sArr, left, index);
						index = left;
						continue;
					} //left > right && (left > index)
					else {
						swap(sArr, right, index);
						index = right;
						continue;
					} //right >left> index
				}//if left child greater then index
				else{
					if (compare(sArr[right], sArr[index])>0){
						swap(sArr,right, index);
						index = right;
						continue;
					}//right > n > left
					else{
						break;
					}//index > left && index > right
				}//left less then index
			}//remove head of heap into sorted array
		}
		
		return sArr;  //return sorted array
		
	}//heapSort method
	
	/** heapify method
	 * procedure heapify: arr 
	 *    start = floor((arr.length-2/2) //assigned index of a to last parent node
	 *    while (start >= 0) do 
	 *        siftDown(a, start, count-1)
	 *        start = start - 1
	 *        
	 * @param sArr
	 * @param count
	 * @return 
	 */
	public E[] maxHeapify(E[] sArr){
		int arrSize = sArr.length;
		
		for (int i = 0; i < arrSize; i++){
			int n = i; //index of inserted element
			while (n > 0) {
				int parent = (n-1)/2; //index of parent of n
				if (compare(sArr[n], sArr[parent]) > 0){
					swap(sArr, n, parent); //swap child w/ parent
					n = parent; //inserted element is now parent
				}
				else
					break; //heap property met
			}//loop until root of heap
		}//add to heap
		return sArr;
	}
	
	//A second implementation of heapsort method using PriorityQueue 
	public <E extends Comparable<? super E>> E[] heapSort_2(E[] sArr) {
		//Comparator<? super E> comparator = (Comparator<? super E>) new StudentComparator();
	    //java's PriorityQueue class functions as a max heap
	    PriorityQueue<E> heap = new PriorityQueue<E>(sArr.length);
	    
	    //add element to an array with heap property
	    for (E e : sArr){
	    	heap.add(e);
	    }
	 
	    // Elements come off the heap in descending order
	    for (int i = 0; i <= sArr.length-1; i++){
	    	E element = heap.remove();
	    	sArr[i] = element;
	    }
	    
		return sArr;
	    	 
	}
	


	
//------------MERGESORT (& related methods)-------------
	
	/** Mergesort
	 * - splits unsorted array in half, sorts arrays 
	 * 
	 * @return sArr
	 * 
	 */
	public Object[] mergeSort(Object[] sArr){
		if (sArr.length > 1){
			Object[] aLeft = left(sArr);
			Object[] aRight = right(sArr);
			mergeSort(aLeft);
	        mergeSort(aRight);
	        
	        merge(sArr, aLeft, aRight);
		}//as long as array contains more then 1 element
		return sArr;
	}//mergesort method
	
	public Object[] merge(Object[] sArr, Object[] sLeft, Object[] sRight){
		int i1 = 0;   // index into left array
        int i2 = 0;   // index into right array
        
        for (int i = 0; i < sArr.length; i++) {
            if (i2 >= sRight.length || (i1 < sLeft.length && 
            		compare(sLeft[i1], sRight[i2])>0)) {
                sArr[i] = sLeft[i1];    // take from left
                i1++;
            } else {
                sArr[i] = sRight[i2];   // take from right
                i2++;
            }
        }
		return sArr;
	}//merge & return arr
	
	public Object[] left(Object[] arr){
		int sLeft = arr.length/2;
		Object[] left = new Object[sLeft];
		for (int i = 0; i < sLeft; i++)
			left[i] = arr[i];
		
		return left;
	}//get left half of arr
	
	public Object[] right(Object[] arr){
		int sRight = arr.length - (arr.length/2);
		Object[] right = new Object[sRight];
		for (int i = 0; i < sRight; i++)
			right[i] = arr[i + arr.length/2];
		
		return right;
	}//get left half of arr
	
//------------QUICKSORT (& related methods)-------------
	
	public E[] quickSort(E[] sArr){
		return quicksort_r(sArr, 0, sArr.length-1); 
	}
	
	/** quicksort_r
	 * - recursive quicksort 
	 * 
	 * @param sArr - the array being sorted
	 * @param left - left index
	 * @param right - right index
	 * @return an element array
	 */
	public E[] quicksort_r(E[] sArr, int left, int right)
	{
      if (left < right)
      {
          int pi = (left+right)/2;
          int newPivotIndex = partition(sArr, left, right, pi);
          quicksort_r(sArr, left, newPivotIndex-1);
          quicksort_r(sArr, newPivotIndex+1, right);
      }
		return sArr;
	}

	/** partition - splits array based on index
	 * 
	 * @param sArr
	 * @param left
	 * @param right
	 * @param pivotIndex
	 * @return
	 */
   public int partition(E[] sArr, int left, int right, int pivotIndex)
   {
      E pivot, temp;
      int i, storeIndex;

      pivot = sArr[pivotIndex];

      temp = sArr[pivotIndex];       // Swap a[pivotIndex] and a[right] 
      sArr[pivotIndex] = sArr[right];
      sArr[right] = temp;

     storeIndex = left;
     for (i = left; i < right; i++)
     {
        if (compare(sArr[i], pivot)> 0)
        {
           temp = sArr[storeIndex];       //Swap a[i] and a[storeIndex] 
           sArr[storeIndex] = sArr[i];
           sArr[i] = temp;
    
           storeIndex++;
        }
     }
     
     temp = sArr[right];                //Swap a[storeIndex] and a[right]
     sArr[right] = sArr[storeIndex];      /* Moves pivot to its final place */
     sArr[storeIndex] = temp;

     return storeIndex;
   }

	
//-----------------compare method for student----------------------//
	@Override
	public int compare(Object s1, Object s2) {
		//initialize comparison value for last name
    	int compValue = ((Student) s2).getNameLast().compareTo(((Student) s1).getNameLast());
    	
        if (compValue == 0){
        	compValue = ((Student) s2).getNameFirst().compareTo(((Student) s1).getNameFirst());
        	if (compValue == 0){
        		compValue = ((Student) s2).getNameMiddle().compareTo(((Student) s1).getNameMiddle());
        		if (compValue == 0){
        			double dValue = ((Student) s2).getId().compareTo(((Student) s1).getId());
        			if (dValue < 0)
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
	

	
//-----------------swap method for sorting----------------------//
    /*
     * implemented by sorting methods
     */
    public E[] swap(E[] arr, int i, int j){
		
    	E temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    	return arr;
    }

}
