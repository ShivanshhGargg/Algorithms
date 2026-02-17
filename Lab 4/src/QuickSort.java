import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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

    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) arr[i] = i;


        Deque<Pair> s = new ArrayDeque<>();
        qsi(arr,s);
        System.out.println(Arrays.toString(arr));
    }
}
