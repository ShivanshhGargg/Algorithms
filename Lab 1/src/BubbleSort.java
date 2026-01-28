import java.util.Random;

public class BubbleSort {
    public static void bb(int[] arr, int i){
        if (i == arr.length)return;
        for (int j = 1; j < arr.length-i+1; j++) {
            if (arr[j-1]>arr[j])swapIndex(arr,j,j-1);
        }
        bb(arr,i+1);
    }
    public static double time(int[] arr){
        long t1 = System.nanoTime();

        bb(arr,1);

        long t2 = System.nanoTime();

        return (t2-t1)/1_000_000.0;
    }

    public static void main(String[] args) {
        Random rd = new Random();
        double avg = 0;
        int n = 25000;
        int[] arr = new int[n];

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < n; j++) arr[j] = rd.nextInt();
            avg += time(arr);
        }

        System.out.println("Time taken = " + avg / 1000 + " ms for n = " + n);
    }

    private static void swapIndex(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
