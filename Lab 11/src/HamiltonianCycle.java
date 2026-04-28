public class HamiltonianCycle {
    public static void main(String[] args) {
        int n = 5;

        int[][] graph = {
                {0,1,0,1,0},
                {1,0,1,1,1},
                {0,1,0,0,1},
                {1,1,0,0,1},
                {0,1,1,1,0}
        };

        int[] x = new int[n];
        x[0] = 0;

        hamiltonian(1, graph, x, n);
    }

    static void nextValue(int k, int[][] graph, int[] x, int n) {
        while (true) {
            x[k] = (x[k] + 1) % n;

            if (x[k] == 0) return;

            if (graph[x[k - 1]][x[k]] == 1) {
                int j;
                for (j = 0; j < k; j++) {
                    if (x[j] == x[k]) break;
                }

                if (j == k) {
                    if (k < n - 1 || (k == n - 1 && graph[x[k]][x[0]] == 1)) {
                        return;
                    }
                }
            }
        }
    }

    static void hamiltonian(int k, int[][] graph, int[] x, int n) {
        while (true) {
            nextValue(k, graph, x, n);

            if (x[k] == 0) return;

            if (k == n - 1) {
                for (int i = 0; i < n; i++) System.out.print(x[i] + " ");
                System.out.println(x[0]);
            } else {
                hamiltonian(k + 1, graph, x, n);
            }
        }
    }
}