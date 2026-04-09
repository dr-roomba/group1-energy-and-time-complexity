public class Main {

    public static void main(String[] args) {

        int[] ints = {2, 6, 1, 8 ,4, 3, 5, 10, 7, 9};
        int[] out = new int[10];

        CountingSort.CountingSort(ints, out, 10);
        System.out.println(Utils.arrToString(ints));
        System.out.println(Utils.arrToString(out));

    }


}