import java.util.*;

public class LCS {

    static int[][] c;
    static char[][] p;

    static void lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        c = new int[m + 1][n + 1];
        p = new char[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            c[i][0] = 0;
        }
        for (int j = 1; j <= n; j++) {
            c[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    c[i][j] = 1 + c[i - 1][j - 1];
                    p[i][j] = 'D';
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    p[i][j] = 'U';
                } else {
                    c[i][j] = c[i][j - 1];
                    p[i][j] = 'L';
                }
            }
        }
    }

    static void printLCS(String X, int i, int j) {
        if (i == 0 || j == 0)
            return;

        if (p[i][j] == 'D') {
            printLCS(X, i - 1, j - 1);
            System.out.print(X.charAt(i - 1));
        } else if (p[i][j] == 'U') {
            printLCS(X, i - 1, j);
        } else {
            printLCS(X, i, j - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String X = sc.next();

        System.out.print("Enter second string: ");
        String Y = sc.next();

        lcs(X, Y);

        System.out.println("\nLength of LCS: " + c[X.length()][Y.length()]);

        System.out.print("LCS: ");
        printLCS(X, X.length(), Y.length());
    }
}