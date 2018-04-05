package algorithms.sort.merge;

import java.util.Arrays;

public class MergeSort {

    public MergeSort() {

    }
    
    public static void mergeSort(int[] arr) {
       if (arr.length >= 2) {
           int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
           int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
   
           mergeSort(left);
           mergeSort(right);
   
           int i1 = 0;
           int i2 = 0;
   
           for (int i = 0; i < arr.length; i++) {
               if (i2 >= right.length || (i1 < left.length && left[i1] < right[i2])) {
                   arr[i] = left[i1];
                   i1++;
               } else {
                   arr[i] = right[i2];
                   i2++;
               }
           }
       }
   }

    /**
     * Implements Merge Sort algorithm.
     * Recursively half the array, then
     * merge sorted arrays.
     * @param arr
     */
    public void sort(int[] arr) {
        recursiveSort(arr, 0, arr.length - 1);
    }

    // recursively split arr then call merge
    private void recursiveSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            recursiveSort(arr, left, mid);
            recursiveSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }

    }

    // Merge two subarrays of arr
    private void merge(int[] arr, int left, int mid, int right) {
        int length1 = mid - left + 1;
        int length2 = right - mid;

        // create temp arrays

        int[] leftArr = new int[length1];
        int[] rightArr = new int[length2];

        for (int i = 0; i < length1; i++)
            leftArr[i] = arr[left + i];

        for (int j = 0; j < length2; j++)
            rightArr[j] = arr[mid + 1 + j];

        // keep a pointer to each subarray and the overall array

        int i = 0, j = 0;
        int k = left;

        // set each element from temp arrays, into arr in sorted order

        while (i < length1 && j < length2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // copy remaining elements

        while (i < length1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < length2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
