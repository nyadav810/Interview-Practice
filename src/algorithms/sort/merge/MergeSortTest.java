package algorithms.sort.merge;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

    MergeSort mergeSort;

    int[] unsorted;

    int[] sorted;

    @Before
    public void setupTestData() {
        mergeSort = new MergeSort();
        unsorted = new int[] { 10, 2, 9, 1, 6, 4, 7, 5, 8, 3 };
        sorted = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    }

    @Test
    public void testMergeSort() {
        mergeSort.sort(unsorted);

        assertArrayEquals(unsorted, sorted);
    }
}
