import java.util.Random;

public class KthSmallest {
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

    public static int qs(int[] arr,int k,int s,int e) throws Exception{
        if (k <= 0 || k > (e - s + 1)) throw new Exception("k out of bounds");
        if (s == e) return arr[s];

        int j = partition(arr, s, e);
        int count = j - s + 1;

        if (k == count) return arr[j];
        else if (k < count) return qs(arr, k, s, j - 1);
        else return qs(arr, k - count, j + 1, e);
    }

    private static void swapIndex(int[] arr, int l, int h) {
        int t = arr[l];
        arr[l] = arr[h];
        arr[h] = t;
    }

    public static double time(int[] arr,int k) throws Exception{
        long t1 = System.nanoTime();

        qs(arr,k,0,arr.length-1);

        long t2 = System.nanoTime();

        return (t2-t1)/1_000_000.0;
    }

    public static void main(String[] args) throws Exception{
        Random rd = new Random();
        int[] values = {10, 100, 1000, 5000, 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};
        for (int n: values) {
            double avg = 0;
            int[] str = new int[n];
            for (int j = 0; j < n; j++) str[j] = rd.nextInt();
            for (int i = 0; i < 10; i++) {
                int[] copy = str.clone();
                avg += time(copy,rd.nextInt(n));
            }
            System.out.print(avg/1000+",");
        }
    }
}
