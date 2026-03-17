import java.util.*;

public class Kruskals {
    static class Edge {
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
        return parent[x] = find(parent[x]); // path compression
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        if (parent[px] < parent[py]) { // union by size
            parent[px] += parent[py];
            parent[py] = px;
        } else {
            parent[py] += parent[px];
            parent[px] = py;
        }
    }

    public static int kruskal(int n, List<Edge> edges) {
        Collections.sort(edges, (a, b) -> a.w - b.w);

        parent = new int[n];
        Arrays.fill(parent, -1);

        int mincost = 0, count = 0;

        for (Edge e : edges) {
            int u = e.u, v = e.v;

            if (find(u) != find(v)) {
                union(u, v);
                mincost += e.w;
                count++;

                System.out.println(u + " - " + v);

                if (count == n - 1) break;
            }
        }

        if (count != n - 1) {
            System.out.println("No Spanning Tree");
            return -1;
        }

        return mincost;
    }

    public static void main(String[] args) {
        int n = 5;

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0,1,2));
        edges.add(new Edge(0,3,6));
        edges.add(new Edge(1,2,3));
        edges.add(new Edge(1,3,8));
        edges.add(new Edge(1,4,5));
        edges.add(new Edge(2,4,7));
        edges.add(new Edge(3,4,9));

        int cost = kruskal(n, edges);
        System.out.println("MST Cost: " + cost);
    }
}