import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] ints = {2, 6, 1, 8, 4, 3, 5, 10, 7, 9};
        int[] out = new int[10];

        CountingSort.CountingSort(ints, out, 10);
        System.out.println(Utils.arrToString(ints));
        System.out.println(Utils.arrToString(out));

        try {
            Utils.arrToFile(ints, "ints.txt");
        }catch (IOException e) {
            System.out.println("Error writng to file");
            e.printStackTrace();
        }

        int[] unsorted = Utils.fileToArray("ints.txt");
        int[] sorted = Arrays.copyOf(unsorted, unsorted.length);
        QuickSort.quickSort(sorted, 0, sorted.length - 1);
        System.out.println(Utils.arrToString(ints));
        System.out.println(Utils.arrToString(out));

    }


}