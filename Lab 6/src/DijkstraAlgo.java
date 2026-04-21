import java.util.*;

public class DijkstraAlgo {
    private static final int INF = 1_000_000;

    static class Pair {
        int node, dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void dijkstra(int s, int[][] g, int[] d, int n) {
        boolean[] vis = new boolean[n];
        Arrays.fill(d, INF);

        d[s] = 0;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.dist - b.dist);

        pq.add(new Pair(s, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;

            if (vis[u]) continue;
            vis[u] = true;

            for (int j = 0; j < n; j++) {
                if (!vis[j] && g[u][j] != INF) {
                    if (d[j] > d[u] + g[u][j]) {
                        d[j] = d[u] + g[u][j];
                        pq.add(new Pair(j, d[j]));
                    }
                }
            }
        }
    }

    public static double time(int[][] g) {
        int n = g.length;
        int[] d = new int[n];

        long t1 = System.nanoTime();
        dijkstra(0, g, d, n);
        long t2 = System.nanoTime();

        return (t2 - t1) / 1_000_000.0; // ms
    }

    public static int[][] generateGraph(int n) {
        Random rd = new Random();
        int[][] g = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) g[i][j] = 0;
                else {
                    if (rd.nextDouble() < 0.3)
                        g[i][j] = rd.nextInt(50) + 1;
                    else
                        g[i][j] = INF;
                }
            }
        }
        return g;
    }

    public static void main(String[] args) {
        int[] sizes = {10, 20, 50, 100, 150, 200, 250, 300};

        for (int n : sizes) {
            double avg = 0;

            int[][] graph = generateGraph(n);

            for (int i = 0; i < 10; i++) {
                avg += time(graph);
            }

            System.out.print((avg / 10) + ", ");
        }

    }
}