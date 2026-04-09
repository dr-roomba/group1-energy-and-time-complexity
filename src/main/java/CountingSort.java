public class CountingSort {
    public static void CountingSort(int[] input, int[] output, int k) {
        int[] temp = new int[k+1];
        for (int i = 0; i <= k; i++) {
            temp[i] = 0;
        }
        for (int i = 0; i < input.length; i++) {
            temp[input[i]]++;
        }
        for (int i = 1; i < k; i++) {
            temp[i] += temp[i - 1];
        }
        for (int i = input.length; i > 0; i--) {
            output[temp[input[i]]] = input[i];
            temp[input[i]]--;
        }
    }
}