package algorithms.sort.selection;

import java.util.Arrays;

public class SelectionSort {
   
   /* Repeatedly loop over the array, finding the
    * smallest element, and swapping it to the front
    * O(N^2) in all cases
    * Faster than bubble sort, makes n - 1 swaps
    */
   public static void selectionSort(int[] a) {
      for (int i = 0; i < a.length - 1; i++) {
         int min = i;
         for (int j = i+1; j < a.length; j++) {
            if (a[j] < a[min]) {
               min = j;
            }
         }
         swap(a, i, min);
      }
   }
   
   private static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }
   
   public static void main(String[] args) {
      int[] arr = { 1, 8, 7, 2, 4 };
      selectionSort(arr);
      System.out.println(Arrays.toString(arr));
   }
}