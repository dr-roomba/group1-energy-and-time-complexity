import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class CountingSortTest {
    @Test
    public void testRandomData() {
        Random random = new Random();
        int[] A = new int[10];
        for (int i = 0; i < A.length; i++) {
            A[i] = random.nextInt(100);
        }
        int[] output = new int[A.length];
        CountingSort.CountingSort(A, output, 99);
        for (int i = 1; i < output.length; i++) {
            assertTrue(output[i] >= output[i-1], "Array is not sorted at index " + i);
        }
    }

    @Test
    public void testSortedData() {
        int[] A = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] output = new int[A.length];
        CountingSort.CountingSort(A, output, 9);
        for (int i = 1; i < output.length; i++) {
            assertTrue(output[i] >= output[i-1], "Array is not sorted at index " + i);
        }
    }

    @Test
    public void testPartiallySortedData() {
        int[] A = new int[] {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        int[] output = new int[A.length];
        CountingSort.CountingSort(A, output, 9);
        for (int i = 1; i < output.length; i++) {
            assertTrue(output[i] >= output[i-1], "Array is not sorted at index " + i);
        }
    }

    @Test
    public void testReversedData() {
        int[] A = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] output = new int[A.length];
        CountingSort.CountingSort(A, output, 9);
        for (int i = 1; i < output.length; i++) {
            assertTrue(output[i] >= output[i-1], "Array is not sorted at index " + i);
        }
    }
}
