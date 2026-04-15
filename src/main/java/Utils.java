import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Utils {

    public static String arrToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int elem : arr) {
            sb.append(elem + ", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(']');
        return sb.toString();

    }

    public static void arrToFile(int[] arr, String filename) throws IOException{
        
        BufferedWriter out = new BufferedWriter(new FileWriter(filename));
        StringBuilder buffer = new StringBuilder();

        buffer.append(arr.length + ",");

        for (int i = 0; i < arr.length; i++) {
            buffer.append(arr[i] + ",");

            if (i + 1 == arr.length) {
                buffer.setLength(buffer.length() - 1);
            }
        }
        out.write(buffer.toString());
        out.close();

    }
    public static int[] fileToArray(String filePath) {
        // starts with value count, all values delimited by commas
        File file = new File(filePath);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.useDelimiter(",");
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
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
}
