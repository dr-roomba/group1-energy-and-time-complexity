public class MergeSort {

    // Main function that sorts array[p..r] using merge()
    public static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            // Find the middle point
            int q = (p + r) / 2;

            // Sort first and second halves
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);

            // Merge the sorted halves
            merge(A, p, q, r);
        }
    }

    // Merges two subarrays of A[].
    // First subarray is A[p..q]
    // Second subarray is A[q+1..r]
    public static void merge(int[] A, int p, int q, int r) {
        // Find sizes of the two subarrays to be merged
        int n1 = q - p + 1;
        int n2 = r - q;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays L[] and R[]
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + 1 + j];
        }

        // Merge the temp arrays back into A[p..r]
        int i = 0; // Initial index of first subarray
        int j = 0; // Initial index of second subarray
        int k = p; // Initial index of merged subarray

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        int[] arr = Utils.fileToArray(args[0]);
        mergeSort(arr, 0, arr.length - 1);

    }

}