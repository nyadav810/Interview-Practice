package algorithms;

import java.util.Map;
import java.util.HashMap;

public class USCurrency {

   static Map<Double, String> currency; 
   
   static {
      currency = new HashMap<Double, String>();
      
      // Paper Bills
      currency.put(100.00, "hundred-dollar bill");
      currency.put(50.00, "fifty-dollar bill");
      currency.put(20.00, "twenty-dollar bill");
      currency.put(10.00, "ten-dollar bill");
      currency.put(5.00, "five-dollar bill");
      currency.put(1.00, "one-dollar bill");
      
      // Coins
      currency.put(0.25, "quarter");
      currency.put(0.10, "dime");
      currency.put(0.05, "nickel");
      currency.put(0.01, "penny");
   }
   
   // Accept an amount of change represented as a
   // double, and print out the denominations of
   // change that should be given using a greedy
   // approach: large denominations first
   public static void makeChange(double amount) {
      Map<String, Integer> denominations = new HashMap<String, Integer>();
   
      while (amount > 0.00) {
         double amountToRemove = 0.00;
         if (amount >= 100.00) {
            amountToRemove = 100.00;
         } else if (amount >= 50.00) {
            amountToRemove = 50.00;
         } else if (amount >= 20.00) {
            amountToRemove = 20.00;
         } else if (amount >= 10.00) {
            amountToRemove = 10.00;
         } else if (amount >= 5.00) {
            amountToRemove = 5.00;
         } else if (amount >= 1.00) {
            amountToRemove = 1.00;
         } else if (amount >= 0.25) {
            amountToRemove = 0.25;
         } else if (amount >= 0.10) {
            amountToRemove = 0.10;
         } else if (amount >= 0.05) {
            amountToRemove = 0.05;
         } else if (amount >= 0.01) {
            amountToRemove = 0.01;
         } else {
            break;
            //throw new IllegalArgumentException("Improperly formatted input.");
         }
         
         String denomination = currency.get(amountToRemove);
         amount -= amountToRemove;
         
         if (denominations.containsKey(denomination)) {
            int count = denominations.get(denomination);
            denominations.put(denomination, count+1);
         } else {
            denominations.put(denomination, 1);
         }
      }
      
      for (String s : denominations.keySet()) {
         int count = denominations.get(s);
         String denom = s;
         if (count > 1) {
            denom += 's';
         }
         System.out.printf("%d %s\n", count, denom);
      }
   }
   
   public static void main(String[] args) {
      makeChange(100.69);
   }
}