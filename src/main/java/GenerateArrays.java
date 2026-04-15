import java.util.Random;

public class GenerateArrays {
    public static int[] generateRandom(int size) {
        Random random = new Random();
        int[] arr =  random.ints().limit(size).distinct().toArray();
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
        for (int i = 1; i <= size; i++) {
            arr[size - i] = i;
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

}