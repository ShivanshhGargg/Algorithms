import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {
        int[][] M = {
                {60, 6},
                {50, 4},
                {20, 10},
                {40, 10},
                {50, 25}
        };

        double p = knapSack(M, 100);
        System.out.println(p);
    }

    private static double knapSack(int[][] m, int mw) {
        Arrays.sort(m, (a, b) ->
                Double.compare(
                        (double) b[0] / b[1],
                        (double) a[0] / a[1]
                )
        );

        double total = 0.0;

        for (int[] item : m) {

            int value = item[0];
            int weight = item[1];

            if (mw >= weight) {
                total += value;
                mw -= weight;
            } else {
                total += ((double) value / weight) * mw;
                break;
            }
        }

        return total;
    }
}
