

public class StackProblems {
   
   public static boolean balancedSymbols(String str) {
      if (str == null) {
         throw new IllegalArgumentException("input string must not be null.");
      }
      
      // empty input string
      if (str.length() == 0) {
         return true;
      }
      
      // odd length input string
      if (str.length() % 2 == 1) {
         return false;
      }
      
      char[] chars = str.toCharArray();
      Stack<Character> stack = new Stack<Character>();
      for (int i = 0; i < chars.length; i++) {
         char c = chars[i];
         if (c == '{' || c == '[' || c == '(') {
            stack.push(c);
         } else if (c == '}' || c == ']' || c == ')') {
            if (stack.isEmpty() || !matchingSymbols(c, stack.pop())) {
               return false;
            }
         }
      }
      
      return stack.isEmpty();
   }
   
   private static boolean matchingSymbols(char a, char b) {
      if (a == '}') {
         return b == '{';
      } else if (a == ']') {
         return b == '[';
      } else if (a == ')') {
         return b == '(';
      }
      return false;
   }
   
   public static void main(String[] args) {
      System.out.println(balancedSymbols("(([[{}]]))"));
   }
}