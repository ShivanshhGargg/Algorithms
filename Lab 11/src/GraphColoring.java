public class GraphColoring {
    public static void main(String[] args) {
        int n = 4;
        int m = 3;

        int[][] graph = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        };

        int[] color = new int[n];

        solve(0, graph, color, n, m);
    }

    static boolean isSafe(int v, int c, int[][] graph, int[] color, int n) {
        for (int i = 0; i < n; i++) {
            if (graph[v][i] == 1 && color[i] == c) return false;
        }
        return true;
    }

    static void solve(int v, int[][] graph, int[] color, int n, int m) {
        if (v == n) {
            for (int i = 0; i < n; i++) System.out.print(color[i] + " ");
            System.out.println();
            return;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, c, graph, color, n)) {
                color[v] = c;
                solve(v + 1, graph, color, n, m);
                color[v] = 0;
            }
        }
    }
}