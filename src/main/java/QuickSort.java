public class QuickSort {

    // Main QuickSort function
    public static void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    // Partition function
    public static int partition(int[] A, int p, int r) {
        int pivot = A[r];
        int i = p - 1;

        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= pivot) {
                i = i + 1;
                // Swap A[i] with A[j]
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        // Swap A[i + 1] with A[r]
        int temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;

        return i + 1;
    }
}