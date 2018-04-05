package data.structures.array;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class LargeArrayN {

   public static void main(String[] args) {
      int n = 12;
      int[] arr = fillArray(n);
      
      System.out.println("Numbers in Array: " + Arrays.toString(arr));
      System.out.printf("Missing number: %d\n", findMissingNumber1(arr, n));
   }
   
   public static int findMissingNumber1(int[] a, int n) {
      int total = (n * (n + 1)) / 2;
      int sum = 0;
      for (int i = 0; i < a.length; i++) {
         sum += a[i];
      }
      return total - sum;
   }
   
   
   // assuming ints are sorted
   public static int findMissingNumber2(int[] a) {
      for (int i = 1; i < a.length; i++) {
         if (a[i] - a[i - 1] > 1) {
            return a[i] - 1;
         }
      }
      return 0;
   }
   
   public static int[] fillArray(int n) {
   
      // build and fill list
      ArrayList<Integer> list = new ArrayList<Integer>();
      for (int i = 0; i < n; i++) {
         list.add(i + 1);
      }
      
      // remove a random number
      Random rand = new Random();
      int randomNumber = rand.nextInt(n) + 1;
      list.remove(randomNumber - 1);
      
      int[] a = new int[list.size()];
      for (int i = 0; i < a.length; i++) {
         a[i] = list.get(i);
      }
      return a;
   }
}