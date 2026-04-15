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

        out.write(arr.length + "\n");

        for (int i = 0; i < arr.length; i++) {
            buffer.append(i + ", ");

            if (buffer.length() >= 512) {
                out.write(buffer.toString());
                buffer.setLength(0);
            }
            if (i + 1 == arr.length) {
                buffer.setLength(buffer.length() - 2);
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
}
