package data.structures.string;

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

    public static void main(String[] args) {
        System.out.println(reverseString("reverse"));
    }
}
