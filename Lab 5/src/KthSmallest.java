import java.util.Random;

public class KthSmallest {

    public static int partition(int[] arr, int s, int e) {
        int pivot = arr[e];
        int i = s - 1;

        for (int j = s; j < e; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, e);
        return i + 1;
    }

    public static int qs(int[] arr, int k, int s, int e) throws Exception {
        if (k <= 0 || k > (e - s + 1))
            throw new Exception("k out of bounds");

        if (s == e) return arr[s];

        // Random pivot to avoid worst case
        int pivotIndex = s + new Random().nextInt(e - s + 1);
        swap(arr, pivotIndex, e);

        int j = partition(arr, s, e);
        int count = j - s + 1;

        if (k == count)
            return arr[j];
        else if (k < count)
            return qs(arr, k, s, j - 1);
        else
            return qs(arr, k - count, j + 1, e);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static double time(int[] arr, int k) throws Exception {
        long t1 = System.nanoTime();
        qs(arr, k, 0, arr.length - 1);
        long t2 = System.nanoTime();
        return (t2 - t1) / 1_000_000.0; // ms
    }

    public static void main(String[] args) throws Exception {
        Random rd = new Random();
        int[] values = {10, 100, 1000, 5000, 10000, 20000, 30000, 50000};

        for (int n : values) {
            double avg = 0;
            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = rd.nextInt();

            for (int i = 0; i < 10; i++) {
                int[] copy = arr.clone();
                int k = rd.nextInt(n) + 1; // 1 to n
                avg += time(copy, k);
            }

            System.out.print((avg / 10) + ", ");
        }
    }
}