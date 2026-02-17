import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static int partition(int[] arr, int s, int e) {
        int m = s + (e - s) / 2;
        int pivot = arr[m];
        int index = s;
        for (int i = s; i <= e; i++) {
            if (arr[i] < pivot) index++;
        }
        swapIndex(arr, m, index);
        int l = s, h = e;
        while (l < index && h > index) {
            while (arr[l] < pivot) l++;
            while (arr[h] > pivot) h--;

            if (l < index && h > index) {
                swapIndex(arr, l, h);
                l++;
                h--;
            }
        }
        return index;
    }

    public static void qs(int[] arr,int s,int e){
        if (s<e){
            int j = partition(arr,s,e);
            qs(arr, s, j-1);
            qs(arr, j+1, e);
        }
    }

    private static void swapIndex(int[] arr, int l, int h) {
        int t = arr[l];
        arr[l] = arr[h];
        arr[h] = t;
    }
    public static double time(int[] arr){
        long t1 = System.nanoTime();

        qs(arr,0,arr.length-1);

        long t2 = System.nanoTime();

        return (t2-t1)/1_000_000.0;
    }

    public static void main(String[] args) {
        Random rd = new Random();
        int[] values = {10,100,1000,5000,10000,15000,20000,25000,30000,35000,40000,45000,50000};
        for (int n: values) {
            double avg = 0;
            int[] arr = new int[n];
            Arrays.sort(arr);
            for (int j = 0; j < n; j++) arr[j] = rd.nextInt();
            for (int i = 0; i < 1000; i++) {
                avg += time(arr);
            }
//            System.out.println("Time taken = " + avg / 1000 + " ms for n = " + n);
            System.out.print(avg/1000+",");
        }
    }
}
