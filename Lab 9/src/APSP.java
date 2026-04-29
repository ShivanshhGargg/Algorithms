import java.util.*;

public class APSP {

    static final int INF = 1_000_000;

    public static void APSP(int[][] cost, int[][] A, int n) {
        for (int i = 0; i < n; i++) System.arraycopy(cost[i], 0, A[i], 0, n);

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (A[i][j] > A[i][k] + A[k][j]) {
                        A[i][j] = A[i][k] + A[k][j];
                    }
                }
            }
        }
    }

    public static double time(int[][] graph) {
        int n = graph.length;
        int[][] A = new int[n][n];

        long t1 = System.nanoTime();
        APSP(graph, A, n);
        long t2 = System.nanoTime();

        return (t2 - t1) / 1_000_000.0;
    }

    public static int[][] generateGraph(int n) {
        Random rd = new Random();
        int[][] g = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) g[i][j] = 0;
                else {
                    if (rd.nextDouble() < 0.4)
                        g[i][j] = rd.nextInt(50) + 1;
                    else
                        g[i][j] = INF;
                }
            }
        }
        return g;
    }

    public static void main(String[] args) {
        int[] sizes = {5, 10, 20, 50, 100};

        for (int n : sizes) {
            double avg = 0;
            int[][] graph = generateGraph(n);

            for (int i = 0; i < 5; i++) {
                avg += time(graph);
            }

            System.out.print((avg / 5) + ", ");
        }
    }
}