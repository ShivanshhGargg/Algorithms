import java.util.*;

public class BackwardMS {
    static List<Set<Integer>> s;
    static int INF = 10000000;
    public static void main(String[] args) {
        int[][] graph = {
                {0,   2,   1,   3, INF, INF, INF, INF, INF, INF, INF},
                {INF, 0, INF, INF,   2,   3, INF, INF, INF, INF, INF},
                {INF, INF, 0, INF,   2,   1,   4, INF, INF, INF, INF},
                {INF, INF, INF, 0, INF,   2,   3, INF, INF, INF, INF},
                {INF, INF, INF, INF, 0, INF, INF,   3,   2, INF, INF},
                {INF, INF, INF, INF, INF, 0, INF,   2,   3,   1, INF},
                {INF, INF, INF, INF, INF, INF, 0, INF,   2,   3, INF},
                {INF, INF, INF, INF, INF, INF, INF, 0, INF, INF,   2},
                {INF, INF, INF, INF, INF, INF, INF, INF, 0, INF,   1},
                {INF, INF, INF, INF, INF, INF, INF, INF, INF, 0,   3},
                {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0}};
        bGraph(graph);
    }

    private static void bGraph(int[][] graph) {
        findStage(graph);

        int n = graph.length;
        int stages = s.size();

        int[] cost = new int[n];
        int[] parent = new int[n];

        Arrays.fill(cost, INF);
        cost[0] = 0;

        for (int i = 0; i < stages - 1; i++) {
            List<Integer> curr = new ArrayList<>(s.get(i));
            List<Integer> next = new ArrayList<>(s.get(i + 1));

            for (int u : curr) {
                for (int v : next) {
                    if (graph[u][v] != INF) {
                        if (cost[v] > cost[u] + graph[u][v]) {
                            cost[v] = cost[u] + graph[u][v];
                            parent[v] = u;
                        }
                    }
                }
            }
        }

        int[] path = new int[stages];
        int idx = stages - 1;
        int curr = n - 1;

        while (idx >= 0) {
            path[idx--] = curr;
            curr = parent[curr];
        }

        System.out.println("Minimum cost: " + cost[n - 1]);
        System.out.print("Path: ");
        for (int i = 0; i < stages; i++) {
            System.out.print(path[i] + " ");
        }
    }

    private static void findStage(int[][] g) {
        s = new ArrayList<>();
        boolean[] visited = new boolean[g.length];

        Set<Integer> t = new HashSet<>();
        t.add(0);
        visited[0] = true;
        s.add(t);

        int i = 0;

        while (i < s.size()) {
            Set<Integer> st = new HashSet<>();
            for (int e : s.get(i)) {
                for (int j = 0; j < g.length; j++) {
                    if (g[e][j] != 0 && g[e][j] != INF && !visited[j]) {
                        st.add(j);
                        visited[j] = true;
                    }
                }
            }
            if (!st.isEmpty()) s.add(st);
            i++;
        }
    }
}
