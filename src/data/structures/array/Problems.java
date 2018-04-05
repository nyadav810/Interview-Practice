package data.structures.array;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Problems {

   public static boolean isSorted(double[] arr) {
      if (arr.length == 1) {
         return true;
      }
      
      double last = arr[0];
      
      for (int i = 1; i < arr.length; i++) {
         if (arr[i] < last) {
            return false;
         }
         last = arr[i];
      }
      
      return true;
   }
   
   public static void testIsSorted() {
      double[] arr1 = { 16.1, 12.3, 22.2, 14.4 };
      double[] arr2 = { 1.5, 4.3, 7.0, 19.5, 25.1, 46.2 };
       
      System.out.println(isSorted(arr1));
      System.out.println(isSorted(arr2));
   }
   
   // pre-conditions:
   // 1. array has at least 1 element
   // 2. every value is between 0 and 100 inclusive
   // 3. break ties by choosing the lower value
   public static int mode(int[] arr) {
      // initialize an array of length 101, and increment countArray[integer]
      
      int[] countArray = new int[101];
      for (int i = 0; i < arr.length; i++) {
         countArray[arr[i]]++;
      }
      
      int mode = 0;
      for (int j = 1; j < countArray.length; j++) {
         if (countArray[j] > countArray[mode]) {
            mode = j;
         }
      }
      
      return mode;
   }
   
   public static void testMode() {
      int[] arr = { 27, 15, 15, 11, 27, 27 };
      System.out.println(mode(arr));
   }
   
   public static double stdev(int[] a) {
      double mean = 0;
      
      for (int i = 0; i < a.length; i++) {
         mean += a[i];
      }
      
      mean /= a.length;
      
      double sum = 0;
      for (int j = 0; j < a.length; j++) {
         sum += Math.pow((a[j] - mean), 2);
      }
      
      return Math.sqrt(sum / (a.length - 1));
   }
   
   public static void testStdev() {
      int[] a = { 1, -2, 4, 9, -6, 16, -8, 25, -10 };
      System.out.println(stdev(a));
   }
   
   public static int kthLargest(int[] a, int k) {
      Arrays.sort(a);
      return a[a.length - 1 - k];
   }

   public static void testKthLargest() {
      int[] a = { 74, 85, 102, 99, 101, 56, 84 };
      System.out.println(kthLargest(a, 0));
      System.out.println(kthLargest(a, 1));
      System.out.println(kthLargest(a, 2));
   }
   
   public static int median(int[] a) {
      Arrays.sort(a);
      return a[a.length / 2];
   }
   
   public static void testMedian() {
      int[] a = { 5, 2, 4, 17, 55, 4, 3, 26, 18, 2, 17 };
      System.out.println(median(a));
      
      int[] b = { 42, 37, 1, 97, 1, 2, 7, 42, 3, 25, 89, 15, 10, 29, 27 };
      System.out.println(median(b));
   }
   
   public static double percentEven(int[] a) {
      int evenCount = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] % 2 == 0) {
            evenCount++;
         }
      }
      
      return ((evenCount * 1.0) / a.length) * 100;
   }
   
   public static void testPercentEven() {
      int[] a = { 6, 2, 9, 11, 3 };
      System.out.println(percentEven(a));
   }
   
   public static boolean isUnique(int[] a) {
      Set<Integer> set = new HashSet<Integer>();
      
      for (int i = 0; i < a.length; i++) {
         if (!set.contains(a[i])) {
            set.add(a[i]);
         } else {
            return false;
         }
      }
      return true;
   }
   
   public static void testIsUnique() {
      int[] a = { 3, 8, 12, 2, 9, 17, 43, -8, 46 };
      System.out.println(isUnique(a));
      
      int[] b = { 4, 7, 3, 9, 12, -47, 3, 74 };
      System.out.println(isUnique(b));
   }
   
   public static int[] stutter(int[] arr) {
      int[] stutterArray = new int[arr.length * 2];
      int stutterIndex = 0;
      for (int i = 0; i < arr.length; i++) {
         stutterArray[stutterIndex++] = arr[i];
         stutterArray[stutterIndex++] = arr[i];
      }
      return stutterArray;
   }
   
   public static void testStutter() {
      int[] arr = {42,7,0,-3,15};
      System.out.println(Arrays.toString(stutter(arr)));
   }

   public static void main(String[] args) {
      testStutter();
   }
}