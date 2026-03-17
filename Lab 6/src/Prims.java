import java.util.Arrays;
public class Prims {
    static final int INF = 1_000_000;

    public static int prims(int[][] cost, int n) {
        int[] near = new int[n];
        int[][] t = new int[n - 1][2];
        int mincost = 0;

        int min = INF, k = 0, l = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (cost[i][j] < min) {
                    min = cost[i][j];
                    k = i;
                    l = j;
                }
            }
        }

        t[0][0] = k;
        t[0][1] = l;
        mincost = cost[k][l];

        for (int i = 0; i < n; i++) {
            if (cost[i][l] < cost[i][k])
                near[i] = l;
            else
                near[i] = k;
        }

        near[k] = near[l] = 0;

        for (int i = 1; i < n - 1; i++) {
            int minVal = INF, j = -1;

            for (int v = 0; v < n; v++) {
                if (near[v] != 0 && cost[v][near[v]] < minVal) {
                    minVal = cost[v][near[v]];
                    j = v;
                }
            }

            if (j == -1) {
                System.out.println("Graph is disconnected");
                return -1;
            }

            t[i][0] = j;
            t[i][1] = near[j];
            mincost += cost[j][near[j]];

            near[j] = 0;

            for (int v = 0; v < n; v++) {
                if (near[v] != 0 && cost[v][near[v]] > cost[v][j]) {
                    near[v] = j;
                }
            }
        }

        System.out.println("Edges in MST:");
        for (int i = 0; i < n - 1; i++) {
            System.out.println(t[i][0] + " - " + t[i][1]);
        }

        return mincost;
    }

    public static void main(String[] args) {
        int[][] g = {
                {INF, 2, INF, 6, INF},
                {2, INF, 3, 8, 5},
                {INF, 3, INF, INF, 7},
                {6, 8, INF, INF, 9},
                {INF, 5, 7, 9, INF}
        };

        int cost = prims(g, g.length);
        System.out.println("MST Cost: " + cost);
    }
}