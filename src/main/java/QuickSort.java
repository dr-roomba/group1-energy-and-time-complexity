public class QuickSort {

    // Main QuickSort function
    public static void quickSort(int[] A, int p, int r) {
        if (p <= r) {
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

    public static void mquickSort(int[] data) {
        shuffle(data);
        quickHelper(data, 0, data.length - 1);
    }

    public static void shuffle(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int index = (int) (Math.random() * (a.length - i));
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
    }

    public static void quickHelper(int[] data, int start, int end) {
        if (end <= start) {
            return;
        }

        int j = partion(data, start, end);
        quickHelper(data, start, j-1);
        quickHelper(data, j + 1, end);

    }

    public static int partion(int[] data, int start, int end) {

        int i = start;
        int j = end + 1;
        while (true) {
            while(data[++i] < data[start]) {
                if (i == end) {
                    break;
                }
            }
            while(data[--j] > data[start]) {
                if (j == start) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        int temp = data[start];
        data[start] = data[j];
        data[j] = temp;
        return j;

    }


    public static void main(String[] args) {

        int[] arr = Utils.fileToArray(args[0]);
        mquickSort(arr);

    }

}