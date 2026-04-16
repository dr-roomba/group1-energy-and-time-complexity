import java.io.IOException;
import java.util.Random;

public class GenerateArrays {
    public static int[] generateRandom(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    public static int[] generateSorted(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateReverse(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[size - i - 1] = i;
        }
        return arr;
    }

    public static int[] generatePartiallySorted(int size) {

        int[] arr = generateRandom(size);
        int offset = arr.length/5;

        for (int i = offset; i < arr.length; i += 2*offset) {
            QuickSort.quickSort(arr, i - offset, i);
        }
        return arr;

    }

    public static int[] generateQuickSortBest(int size) {
        int[] arr = generateRandom(size);
        quickHelper(arr, 0, size - 1);
        return arr;
    }

    // public static void quickbesthelper(int[] arr, int start, int end) {
    //     if (end <= start) {
    //         return;
    //     }

    //     quickbesthelper(arr, start, idx - 1);
    //     quickbesthelper(arr, idx + 1, end);
    // }


    public static void quickHelper(int[] arr, int start, int end) {
        if (end <= start) {
            return;
        }

        int idx = QuickSort.partion(arr, start, end);
        int temp = arr[start];
        arr[start] = arr[idx];
        arr[idx] = temp;

        int j = QuickSort.partion(arr, start, end);
        quickHelper(arr, start, j-1);
        quickHelper(arr, j + 1, end);

    }

    /**
     * Generates a worst-case array for Merge Sort of a given size.
     */
    public static int[] generateMergeSortWorstCase(int n) {
        // Step 1: Start with a naturally sorted array
        int[] sortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            sortedArray[i] = i + 1;
        }

        // Step 2: Recursively un-merge to create the alternating pattern
        return unmerge(sortedArray);
    }

    /**
     * Recursively pulls the array apart to force maximum comparisons.
     */
    private static int[] unmerge(int[] arr) {
        // Base case: arrays of 1 or 0 elements cannot be split further
        if (arr.length <= 1) {
            return arr;
        }

        // Determine the sizes of the left and right halves
        int mid = (arr.length + 1) / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Distribute elements alternately into left and right
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                left[i / 2] = arr[i];
            } else {
                right[i / 2] = arr[i];
            }
        }

        // Recursively un-merge both halves
        left = unmerge(left);
        right = unmerge(right);

        // Recombine them: left half followed by the right half
        int[] result = new int[arr.length];
        System.arraycopy(left, 0, result, 0, left.length);
        System.arraycopy(right, 0, result, left.length, right.length);

        return result;
    }

    public static void main(String[] args) throws IOException{
        
        String dir = "arrays/";

        int size = 25_000;
        while (size <= 1_000_000) {
            
            System.out.println(size);

            // int[] rand = GenerateArrays.generateRandom(size);
            // Utils.arrToFile(rand, dir + "rand_" + size);
            
            // int[] sortd = GenerateArrays.generateSorted(size);
            // Utils.arrToFile(sortd, dir + "sortd_" + size);

            // int[] rev = GenerateArrays.generateReverse(size);
            // Utils.arrToFile(rev, dir + "rev_" + size);

            // int[] part = GenerateArrays.generatePartiallySorted(size);
            // Utils.arrToFile(part, dir + "part_" + size);

            // int[] alt = GenerateArrays.generateMergeSortWorstCase(size);
            // Utils.arrToFile(alt, dir + "alt_" + size);

            int[] quickbest = GenerateArrays.generateQuickSortBest(size);
            Utils.arrToFile(quickbest, dir + "qb_" + size);

            if (size < 100_000) {
                size += 25_000;
            }else {
                size += 100_000;
            }

        }
    }

}