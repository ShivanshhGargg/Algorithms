import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void ss(int[] arr, int i){
        if (i==arr.length)return;
        int index = minIndex(arr,i);
        swapIndex(arr,index,i);
        ss(arr,i+1);
    }

    private static void swapIndex(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int minIndex(int[] arr, int i) {
        int min = i;
        for (int j = i; j < arr.length; j++) {
            if (arr[min]>arr[j])min = j;
        }
        return min;
    }
    public static double time(int[] arr){
        long t1 = System.nanoTime();

        ss(arr,0);

        long t2 = System.nanoTime();

        return (t2-t1)/1_000_000.0;
    }

    public static void main(String[] args) {
        Random rd = new Random();
        double avg = 0;
        int n = 2200;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = rd.nextInt();

        for (int i = 0; i < 1000; i++) {
            avg += time(arr);
        }

        System.out.println("Time taken = " + avg / 1000 + " ms for n = " + n);
    }
}
