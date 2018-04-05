package algorithms.sort.insertion;

import java.util.Arrays;

public class InsertionSort {
   
   /*
    * For increasing values of i, slide element i left
    * until it is sorted with respect to elements 0 .. i-1
    * O(N^2) average, O(N) if sorted
    * Faster than selection, especially on sorted data.
    */
   public static void insertionSort(int[] a) {
      for (int i = 1; i < a.length; i++) {
         int tmp = a[i];
         int j = i;
         while (j >= 1 && a[j - 1] > tmp) {
            a[j] = a[j - 1];
            j--;
         }
         a[j] = tmp;
      }
   }
   
   public static void main(String[] args) {
      int[] arr = { 9, 3, 4, 2, 1, 5, 6, 8, 7 };
      insertionSort(arr);
      System.out.println(Arrays.toString(arr));
   }
}