import java.util.*;

public class MatrixChainMultiplication {

    static int[][] m;
    static int[][] s;

    public static void matrixChainOrder(int[] p) {
        int n = p.length - 1;
        m = new int[n + 1][n + 1];
        s = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];

                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public static void printOptimalParens(int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimalParens(i, s[i][j]);
            printOptimalParens(s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static double time(int[] p) {
        long t1 = System.nanoTime();
        matrixChainOrder(p);
        long t2 = System.nanoTime();

        return (t2 - t1) / 1_000_000.0; // ms
    }

    public static int[] generateDimensions(int n) {
        Random rd = new Random();
        int[] p = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            p[i] = rd.nextInt(50) + 1; // avoid 0
        }

        return p;
    }

    public static void main(String[] args) {
        int[] sizes = {5, 10, 15, 20, 25, 30, 35, 40};

        for (int n : sizes) {
            double avg = 0;

            for (int i = 0; i < 10; i++) {
                int[] p = generateDimensions(n);
                avg += time(p);
            }

            System.out.print((avg / 10) + ", ");
        }
    }
}