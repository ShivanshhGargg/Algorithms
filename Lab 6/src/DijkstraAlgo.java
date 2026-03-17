import java.util.Arrays;
import java.util.PriorityQueue;

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

    public static void main(String[] args) {
        int[][] g = {
                    {0,50,45,10,INF,INF},
                    {INF,0,10,15,INF,INF},
                    {INF,INF,0,INF,30,INF},
                    {20,INF,INF,0,15,INF},
                    {INF,20,35,INF,0,INF},
                    {INF,INF,INF,INF,3,0}
                    };
        int[] d = new int[g.length];
        dijkstra(0,g,d,g.length);
        System.out.println(Arrays.toString(d));
    }
}
