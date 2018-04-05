package data.structures.string;

import java.util.Stack;

public class Problems {


    // reverse -> esrever
    public static String reverseString(String s) {
        char[] arr = s.toCharArray();

        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
            swap(arr, i, j);
        }

        return new String(arr);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static String lengthEncoding(String str) {
        if (str.length() < 1) {
            return str;
        }

        int count = 1;
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        char last = chars[0];

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == last) {
                count++;
            } else {
                sb.append(last);
                if (count > 1) {
                    sb.append(count);
                }
                last = chars[i];
                count = 1;
            }
        }
        sb.append(last);
        if (count > 1) {
            sb.append(count);
        }
        return sb.toString();
    }
    
    public static int longestWord(String str) {
        String[] words = str.split(" ");
        int longestWordLength = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            if (word.length() > longestWordLength) {
               longestWordLength = word.length();
            }
        }
        
        return longestWordLength;
    }
    
    public static void testLongestWord() {
        System.out.println(longestWord("A computer science portal for geeks"));
        
        System.out.println(longestWord("I am an intern at geeksforgeeks"));
    }
    
    public static String superReducedString(String str) {
        Stack<Character> stack = new Stack<Character>();
        char[] chars = str.toCharArray();
        
        for (int i = chars.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
               stack.push(chars[i]);
            } else {
               if (stack.peek() == chars[i]) {
                  stack.pop();
               } else {
                  stack.push(chars[i]);
               }
            }
        }
        
        if (stack.isEmpty()) {
            return "Empty String";
        }
        
        StringBuilder s = new StringBuilder();
        
        while (!stack.isEmpty()) {
            s.append(stack.pop());
        }
        
        return s.toString();
    }
    
    public static void testSuperReducedString() {
        System.out.println(superReducedString("baab"));
    }
    
    // Return the minimum number of characters to make the password strong
    public static int minimumNumber(int n, String password) {
            
    }
    
    public static void main(String[] args) {
        testSuperReducedString();
    }
}
