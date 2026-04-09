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
    
}
