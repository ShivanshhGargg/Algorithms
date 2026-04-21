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

        for (int l = 2; l <= n; l++) { // chain length
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

    public static void main(String[] args) {
        int[] p = {30, 35, 15, 5, 10, 20, 25};

        matrixChainOrder(p);

        System.out.println("Number of multiplications: " + m[1][p.length - 1]);
        System.out.print("Optimal Parenthesization: ");
        printOptimalParens(1, p.length - 1);
    }
}