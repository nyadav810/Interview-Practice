package other.recursion;

public class RecursionProblems {

   private static int[] fib = new int[100];

   public static int fibonacci(int n) {
      if (n == 0 || n == 1) {
         return n;
      }
      
      if (fib[n] != 0) {
         return fib[n];
      }
      
      fib[n] = fibonacci(n - 1) + fibonacci(n - 2);
      return fib[n];
   }

   public static int countUniqueWays(int N) {
       return fibonacci(N+1);
   }
   
   public static void main(String[] args) {
       System.out.println(countUniqueWays(13));
   }
}