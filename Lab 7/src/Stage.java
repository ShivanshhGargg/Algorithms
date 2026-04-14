import java.util.*;

public class Stage {
    static List<Set<Integer>> s;
    static int INF = 10000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) g[i][j] = 0;
                else g[i][j] = INF;
            }
        }

        for (int k = 0; k < m; ) {
            System.out.print("Edge " + (k+1) + " (from to weight): ");
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                if (u < 1 || u > n || v < 1 || v > n) {
                    System.out.println("Vertex numbers must be between 1 and " + n + ". Try again.");
                    continue;
                }
                g[u-1][v-1] = w;
                k++;
        }

        findStage(g);
        for (Set<Integer> s : s){
            System.out.println(s);
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

        System.out.println("Number of stages = " + s.size());
    }
}
