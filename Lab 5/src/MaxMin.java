import java.util.Random;

public class MaxMin {

    static class Pair {
        int min, max;
        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private static Pair max_min(int[] arr, int s, int e) {
        if (s == e) {
            return new Pair(arr[s], arr[s]);
        }
        else if (e == s + 1) {
            if (arr[s] < arr[e])
                return new Pair(arr[s], arr[e]);
            else
                return new Pair(arr[e], arr[s]);
        }

        int mid = s + (e - s) / 2;

        Pair left = max_min(arr, s, mid);
        Pair right = max_min(arr, mid + 1, e);

        int min = Math.min(left.min, right.min);
        int max = Math.max(left.max, right.max);

        return new Pair(min, max);
    }

    public static double time(int[] arr) {
        long t1 = System.nanoTime();
        max_min(arr, 0, arr.length - 1);
        long t2 = System.nanoTime();

        return (t2 - t1) / 1_000_000.0; // ms
    }

    public static void main(String[] args) {
        Random rd = new Random();
        int[] sizes = {10, 100, 500, 1000, 2000, 5000, 10000, 20000};

        for (int n : sizes) {
            double avg = 0;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = rd.nextInt();

            for (int i = 0; i < 1000; i++) {
                int[] copy = arr.clone();
                avg += time(copy);
            }

            System.out.print((avg / 1000) + ", ");
        }
    }
}