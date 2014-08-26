README - Lab 11
Comparison of Sorting Algorithms
- Eclipse IDE used to create/build/run
DCSorter.java contains 3 divide-and-conquer sorting algorithms
- Heapsort method sorts in ascending order (large to small) 
   - contains two methods: heapSort_1 & heapSort_2
- Mergesort & Quicksort both sort in descending order (small to larger)
TimeSorting.java implements sorting algorithms
TestDCSorter.java tests to see if array actually sorted
Student.java class instances used to store student info from students.dat
- uses comparison sorting Bubble sort, Insertion sort and Selection sort 
- input file of students.dat used as sorting target
- sorted in descending order starting with name, first name, middle name & if 
necessary student ID number (all names match)
- elapsed time is measured & output for each sorting algorithm

NOTE: output is based on seconds, which was requested in assignment description

OUTPUT:
Mergesort of data file takes 0.021 seconds
Heapsort of data file takes 0.009 seconds
Quicksort of data file takes 0.007 seconds
