package algorithms.sort.bubble;

import java.util.Arrays;

public class BubbleSort {
   
   /*
    * Repeatedly loop over the array, swapping neighboring
    * elements if they are out of relative order.
    * O(N^2) average, O(N) if input is sorted.
    * Slow, performs lots of loops and swaps
    */
   public static void bubbleSort(int[] a) {
      for (int i = 0; i < a.length - 1; i++) {
         for (int j = i+1; j < a.length; j++) {
            if (a[j] < a[i]) {
               swap(a, i, j);
            }
         }
      }
   }
   
   private static void swap(int[] a, int i, int j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
   
   public static void main(String[] args) {
      int[] a = { 8, 9, 2, 1, 4, 7, 6, 5, 3 };
      bubbleSort(a);
      System.out.println(Arrays.toString(a));
   }
}