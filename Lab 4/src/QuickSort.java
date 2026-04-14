import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

public class QuickSort {
    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void qsi(int[] arr, Deque<Pair> s){
        s.push(new Pair(0, arr.length));
        while (!s.isEmpty()){
            Pair p = s.pop();
            int i = p.first;
            int j = p.second;
            if (i >= j) continue;
            int pivot = arr[i];
            do {
                do {
                    i++;
                } while (i < arr.length && arr[i] < pivot);
                do {
                    j--;
                } while (j > -1 && arr[j] > pivot);
                if (i<j)swap(arr, i, j);
                else swap(arr,p.first,j);
            } while (i<j);
            if (j - p.first + 1 > p.second - (j+1)){
                s.push(new Pair(p.first,j));
                s.push(new Pair(j+1,p.second));
            }
            else {
                s.push(new Pair(j+1,p.second));
                s.push(new Pair(p.first,j-1));
            }
        }
    }

    private static void swap(int[] arr,int l,int h){
        int t = arr[l];
        arr[l] = arr[h];
        arr[h] = t;
    }

    public static double time(int[] arr,Deque<Pair> s){
        long t1 = System.nanoTime();

        qsi(arr,s);

        long t2 = System.nanoTime();

        return (t2-t1)/1_000_000.0;
    }

    public static void main(String[] args) {
        Random rd = new Random();
        int[] values = {10, 100, 1000, 5000, 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};
        Deque<Pair> s = new ArrayDeque<>();
        for (int n : values) {
            double avg = 0;
            int[] arr = new int[n];
            Arrays.sort(arr);
            for (int j = 0; j < n; j++) arr[j] = j;
            for (int i = 0; i < 1000; i++) {
                int[] copy = arr.clone();
                avg += time(copy,s);
            }
            System.out.print(avg / 1000 + ",");
        }
    }
}
