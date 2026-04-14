import java.util.Random;

public class Permutation {
    static int c = 0;
    public static void perm(char[] arr, int i) {
        if (i == arr.length) {
            c++;
            return;
        }

        for (int j = i; j < arr.length; j++) {
            swapChar(i, j, arr);
            perm(arr, i + 1);
            swapChar(i, j, arr);
        }
    }

    private static void swapChar(int i, int j, char[] arr) {
        char a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }

    public static double time(char[] str){
        long t1 = System.nanoTime();

        perm(str,0);

        long t2 = System.nanoTime();

        return (t2-t1)/1_000_000.0;
    }

    public static void main(String[] args) {
        Random rd = new Random();
        int[] values = {3,4,5,6,7,8,9};
        for (int n: values) {
            double avg = 0;
            char[] str = new char[n];
            for (int j = 0; j < n; j++) str[j] = (char) ('a'+ rd.nextInt(26));
            for (int i = 0; i < 10; i++) {
                char[] copy = str.clone();
                avg += time(copy);
            }
            System.out.print(avg/1000+",");
        }
    }
}