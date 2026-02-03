import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static int BS(int[] arr,int t, int s,int e){
        if (e<s)return -1;
        int m = s + (e-s)/2;
        if (arr[m] == t)return m;
        else if (arr[m]<t)return BS(arr,t,m+1,e);
        else return BS(arr,t,s,m-1);
    }

    public static double time(int[] arr, int t){
        long t1 = System.nanoTime();

        BS(arr,t, 0, arr.length-1);

        long t2 = System.nanoTime();

        return (t2-t1)/1_000_000.0;
    }

    public static void main(String[] args) {
        Random rd = new Random();
        int[] values = {10,100,1000,10000,100000,1000000,10000000};
        for (int n: values) {
            double avg = 0;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) arr[j] = rd.nextInt();
            Arrays.sort(arr);
            for (int i = 0; i < 1000; i++) {
                avg += time(arr, rd.nextInt());
            }
//            System.out.println("Time taken = " + avg / 1000 + " ms for n = " + n);
            System.out.print(avg/1000+",");
        }
    }
}
