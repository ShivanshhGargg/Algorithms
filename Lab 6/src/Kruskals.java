import java.util.*;

public class Kruskals {
    public static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        if (parent[px] < parent[py]) {
            parent[px] += parent[py];
            parent[py] = px;
        } else {
            parent[py] += parent[px];
            parent[px] = py;
        }
    }

    public static void kruskal(List<Edge> edges, int n) {
        edges.sort((a, b) -> a.w - b.w);

        parent = new int[n];
        Arrays.fill(parent, -1);

        int cost = 0;
        int count = 0;

        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                cost += e.w;
                count++;
            }
        }

        if (count != n - 1) {
            System.out.println("Graph is not connected, MST not possible");
            return;
        }
    }

    public static double time(List<Edge> edges, int n) {
        long t1 = System.nanoTime();
        kruskal(edges, n);
        long t2 = System.nanoTime();

        return (t2 - t1) / 1_000_000.0;
    }

    public static List<Edge> generateGraph(int n) {
        Random rd = new Random();
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rd.nextDouble() < 0.3) {
                    int w = rd.nextInt(50) + 1;
                    edges.add(new Edge(i, j, w));
                }
            }
        }
        return edges;
    }

    public static void main(String[] args) {
        int[] sizes = {10, 20, 50, 100, 150, 200, 250, 300};

        for (int n : sizes) {
            double avg = 0;

            for (int i = 0; i < 10; i++) {
                List<Edge> edges = generateGraph(n);
                avg += time(edges, n);
            }

            System.out.print((avg / 10) + ", ");
        }
    }
}