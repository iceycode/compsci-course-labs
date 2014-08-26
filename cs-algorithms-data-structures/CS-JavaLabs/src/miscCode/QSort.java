package miscCode;

public class QSort
{
   public static void main(String args[])
   {
      Integer a[] = {10, 89, 0, 88, 76, 56, 20, 22, 100, 56, 44, 30, 32, 23 };

      System.out.println("Unsorted array: ");
      for (int i = 0; i < a.length; i++)
         System.out.print(a[i] + " ");
      System.out.println();

      quicksort(a, 0, a.length-1);

      System.out.println("---");
      System.out.println("Sorted array: ");

      for (int i = 0; i < a.length; i++)
         System.out.print(a[i] + " ");
      System.out.println();

      return;
   }

   public static void quicksort(Integer a[], int left, int right)
   {
      if (left < right)
      {
          int pi = (left+right)/2;
          int newPivotIndex = partition(a, left, right, pi);
          quicksort(a, left, newPivotIndex-1);
          quicksort(a, newPivotIndex+1, right);
      }
   }

   public static int partition(Integer a[], int left, int right, int pivotIndex)
   {
      int pivot;
      int tmp, i, storeIndex;

      pivot = a[pivotIndex];

      tmp = a[pivotIndex];       /* Swap a[pivotIndex] and a[right] */
      a[pivotIndex] = a[right];
      a[right] = tmp;

     storeIndex = left;
     for (i = left; i < right; i++)
     {
        if (a[i] < pivot)
        {
           tmp = a[storeIndex];       /* Swap a[i] and a[storeIndex] */
           a[storeIndex] = a[i];
           a[i] = tmp;
    
           storeIndex++;
        }
     }

     tmp = a[right];                /* Swap a[storeIndex] and a[right] */
     a[right] = a[storeIndex];      /* Moves pivot to its final place */
     a[storeIndex] = tmp;

     return storeIndex;
   }
}
