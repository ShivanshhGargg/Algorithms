import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    private static final int INF = 1_000_000;
    public static void dijkstra(int s,int[][] g,int[] d,int n){
        boolean[] vis = new boolean[n];
        Arrays.fill(d, INF);

        d[s] = 0;

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> d[a] - d[b]);

        pq.add(s);

        while (!pq.isEmpty()) {
            int u = pq.poll();

            if (vis[u]) continue;
            vis[u] = true;

            for (int j = 0; j < n; j++) {
                if (!vis[j] && g[u][j] != INF) {
                    if (d[j] > d[u] + g[u][j]) {
                        d[j] = d[u] + g[u][j];
                        pq.add(j);
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
