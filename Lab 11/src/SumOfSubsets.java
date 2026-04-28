import java.util.*;

public class SumOfSubsets {

    static int count;

    public static void sumOfSubsets(int s, int k, int r, int[] w, int[] x, int n, int W) {
        if (k < n) {
            x[k] = 1;

            if (s + w[k] == W) {
                count++;
            }
            else if (k + 1 < n && s + w[k] + w[k + 1] <= W) {
                sumOfSubsets(s + w[k], k + 1, r - w[k], w, x, n, W);
            }

            if (k + 1 < n && s + r - w[k] >= W && s + w[k + 1] <= W) {
                x[k] = 0;
                sumOfSubsets(s, k + 1, r - w[k], w, x, n, W);
            }
        }
    }

    public static double time(int[] w, int W) {
        int n = w.length;
        int[] x = new int[n];
        count = 0;

        int r = 0;
        for (int val : w) r += val;

        long t1 = System.nanoTime();
        sumOfSubsets(0, 0, r, w, x, n, W);
        long t2 = System.nanoTime();

        return (t2 - t1) / 1_000_000.0;
    }

    public static int[] generateSet(int n) {
        Random rd = new Random();
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = rd.nextInt(10) + 1; // small weights
        }

        Arrays.sort(w);
        return w;
    }

    public static void main(String[] args) {
        int[] sizes = {4, 6, 8, 10, 12, 14};

        for (int n : sizes) {
            double avg = 0;

            for (int i = 0; i < 3; i++) time(generateSet(n), 20); // warm-up

            for (int i = 0; i < 5; i++) {
                int[] w = generateSet(n);
                avg += time(w, 20);
            }

            System.out.print((avg / 5) + ", ");
        }
    }
}