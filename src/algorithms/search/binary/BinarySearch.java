package algorithms.search.binary;

public class BinarySearch {

    /**
     * Implements Binary Search Algorithm:
     * Search a sorted array by repeatedly halving
     * the search space. Runs in O(log n) worst case.
     * @param arr
     * @param target
     * @return index of target in arr, or -1 if not found
     */
    public static int binarySearch(int[] arr, int target) {
        int high = arr.length - 1;
        int low = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 10, 20, 30, 40, 60, 70, 80, 900, 10000 };

        int target = 9;
        int index = binarySearch(arr, target);
        System.out.printf("Index of %d: %d\n", target, index);
    }
}
