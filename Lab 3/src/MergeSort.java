import java.util.Random;

public class MergeSort {
    public static void ms(int[] arr, int s, int e){
        if (e-s<=1)return;
        int m = s + (e-s)/2;
        ms(arr, s, m);
        ms(arr, m, e);
        mergeS(arr,s,m,e);
    }

    private static void mergeS(int[] arr, int s, int m, int e) {
        int i =s,j=m,k=0;
        int[] mix = new int[e-s];
        while (i<m&&j<e){
            if (arr[i]<arr[j])mix[k++]=arr[i++];
            else mix[k++]=arr[j++];
        }
        while (i<m)mix[k++]=arr[i++];
        while (j<e)mix[k++]=arr[j++];

        for (int l = 0; l < mix.length; l++) {
            arr[s+l]=mix[l];
        }
    }
    public static double time(int[] arr){
        long t1 = System.nanoTime();

        ms(arr,0,arr.length);

        long t2 = System.nanoTime();

        return (t2-t1)/1_000_000.0;
    }

    public static void main(String[] args) {
        Random rd = new Random();
        int[] values = {10,100,1000,5000,10000,15000,20000,25000,30000,35000,40000,45000,50000};
        for (int n: values) {
            double avg = 0;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) arr[j] = rd.nextInt();
            for (int i = 0; i < 1000; i++) {
                avg += time(arr);
            }
//            System.out.println("Time taken = " + avg / 1000 + " ms for n = " + n);
            System.out.print(avg/1000+",");
        }
    }
}
