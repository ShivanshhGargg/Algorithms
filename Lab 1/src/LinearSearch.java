import java.util.Random;

public class LinearSearch {
    public static int LS(int[] arr, int target,int i){
        if (i == arr.length)return -1;
        if (arr[i] == target)return i;
        else return LS(arr,target,i+1);
    }

    public static double time(int[] arr,int target){
        long t1 = System.nanoTime();

        int ans = LS(arr,arr[0], 0);

        long t2 = System.nanoTime();

        return (t2-t1)/1_000_000.0;
    }

    public static void main(String[] args) {
        Random rd = new Random();
        double avg = 0;
        int n = 25000;
        int[] arr = new int[n];

        int target = rd.nextInt();

        for (int i = 0; i < n; i++)arr[i] = rd.nextInt();

        for (int i = 0; i < 1000; i++) {
            avg += time(arr,target);
        }

        System.out.println("Time taken = "+ avg/1000 + " ms for n = " + n);
    }
}
