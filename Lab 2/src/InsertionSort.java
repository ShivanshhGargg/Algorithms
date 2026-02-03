import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void IS(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int t = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j]>t){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = t;
        }
    }
    public static double time(int[] arr){
        long t1 = System.nanoTime();

        IS(arr);

        long t2 = System.nanoTime();

        return (t2-t1)/1_000_000.0;
    }

    public static void main(String[] args) {
        Random rd = new Random();
        double avg = 0;
        int n = 22500;
        int[] arr = new int[n];
        for (int j = 0; j < n; j++) arr[j] = rd.nextInt();
        time(arr);
        for (int i = 0; i < 1000; i++) {
            avg += time(arr);
        }

        System.out.println("Time taken = " + avg / 1000 + " ms for n = " + n);
    }
}
