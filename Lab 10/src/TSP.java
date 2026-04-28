import java.util.Arrays;

public class TSP {
    static class Backtracking {
        public int tsp(int[][] cost) {
            int n = cost.length;
            boolean[] city = new boolean[n];
            city[0] = true;
            return DFS(city, cost, 0, 1);
        }

        public int DFS(boolean[] vis, int[][] cost, int start, int count) {
            int n = cost.length;
            if (n == count) return cost[start][0];
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                if (!vis[i]) {
                    vis[i] = true;
                    min = Math.min(min, cost[start][i] + DFS(vis, cost, i, count + 1));
                    vis[i] = false;
                }
            }
            return min;
        }

        public static void main(String[] args) {

        }
    }

    static class DP {
        static final int INF = Integer.MAX_VALUE;

        public static int tsp(int n, int[][] cost) {
            int VISITED_ALL = 1 << n;
            int[][] dp = new int[VISITED_ALL][n];

            for (int[] row : dp) {
                Arrays.fill(row, INF);
            }

            dp[1][0] = 0;

            for (int i = 1; i < VISITED_ALL; i++) {
                for (int j = 0; j < n; j++) {

                    if ((i & (1 << j)) == 0) continue;

                    for (int k = 0; k < n; k++) {

                        if ((i & (1 << k)) != 0) continue;

                        int newMask = i | (1 << k);

                        dp[newMask][k] = Math.min(
                                dp[newMask][k],
                                dp[i][j] + cost[j][k]
                        );
                    }
                }
            }

            int ans = INF;

            for (int i = 0; i < n; i++) {
                ans = Math.min(ans, dp[VISITED_ALL - 1][i] + cost[i][0]);
            }

            return ans;
        }

        public static void main(String[] args) {
            int n = 4;

            int[][] cost = {
                    {0, 10, 15, 20},
                    {10, 0, 35, 25},
                    {15, 35, 0, 30},
                    {20, 25, 30, 0}
            };

            System.out.println("Minimum cost: " + tsp(n, cost));
        }
    }
}
