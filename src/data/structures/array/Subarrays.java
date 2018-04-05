package data.structures.array;

import java.util.List;
import java.util.ArrayList;

public class Subarrays {

   public static List<ArrayList<Integer>> findAllSubarrays(int[] a) {
      List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i < a.length; i++) {
         for (int j = i; j < a.length; j++) {
            ArrayList<Integer> newList = new ArrayList<Integer>();
            for (int k = i; k <= j; k++) {
               newList.add(a[k]);
            }
            list.add(newList);
         }
      }
      return list;
   }
   
   public static int findAllSubarrays(int[] a) {
      int negativeSum = 0;
      
      for (int i = 0; i < a.length; i++) {
         for (int j = i; j < a.length; j++) {
            int currentSum = 0;
            for (int k = i; k <= j; k++) {
               currentSum += a[k];
            }
            if (currentSum < 0) {
               negativeSum++;
            }
         }
      }
      return negativeSum;
   }
   
   public static void main(String[] args) {
      int[] a = { 1, 2, 3, 4 };
      System.out.println(findAllSubarrays(a).toString());
   }
}