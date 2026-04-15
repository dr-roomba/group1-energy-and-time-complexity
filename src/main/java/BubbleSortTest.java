import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {
    @Test
    public void testRandomData() {
        Random random = new Random();
        int[] A = new int[10];
        for (int i = 0; i < A.length; i++) {
            A[i] = random.nextInt(100);
        }
        BubbleSort.BubbleSort(A);
        for (int i = 1; i < A.length; i++) {
            assertTrue(A[i] >= A[i-1], "Array is not sorted at index " + i);
        }
    }

    @Test
    public void testSortedData() {
        int[] A = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BubbleSort.BubbleSort(A);
        for (int i = 1; i < A.length; i++) {
            assertTrue(A[i] >= A[i-1], "Array is not sorted at index " + i);
        }
    }

    @Test
    public void testPartiallySortedData() {
        int[] A = new int[] {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        BubbleSort.BubbleSort(A);
        for (int i = 1; i < A.length; i++) {
            assertTrue(A[i] >= A[i-1], "Array is not sorted at index " + i);
        }
    }

    @Test
    public void testReversedData() {
        int[] A = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        BubbleSort.BubbleSort(A);
        for (int i = 1; i < A.length; i++) {
            assertTrue(A[i] >= A[i-1], "Array is not sorted at index " + i);
        }
    }
}
