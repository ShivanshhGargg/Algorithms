import java.util.*;

public class NQueens {

    static int solutions;

    public static void solve(int k, int[] x, int n) {
        if (k == n) {
            solutions++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(k, i, x)) {
                x[k] = i;
                solve(k + 1, x, n);
            }
        }
    }

    static boolean isSafe(int k, int i, int[] x) {
        for (int j = 0; j < k; j++) {
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }

    public static double time(int n) {
        int[] x = new int[n];
        solutions = 0;

        long t1 = System.nanoTime();
        solve(0, x, n);
        long t2 = System.nanoTime();

        return (t2 - t1) / 1_000_000.0;
    }

    public static void main(String[] args) {
        int[] sizes = {4, 5, 6, 7, 8, 9, 10};

        for (int n : sizes) {
            double avg = 0;

            for (int i = 0; i < 5; i++) {
                avg += time(n);
            }

            System.out.print(avg / 5 + ",");
        }
    }
}