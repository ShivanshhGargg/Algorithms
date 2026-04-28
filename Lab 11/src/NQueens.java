public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        int[] x = new int[n];

        solve(0, x, n);
    }

    static void solve(int k, int[] x, int n) {
        if (k == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(x[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(k, i, x)) {
                x[k] = i;
                solve(k + 1, x, n);
            }
        }
    }

    static boolean isSafe(int k, int i, int[] x) {
        for (int j = 0; j < k; j++) {
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }
}