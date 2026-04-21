import java.util.Arrays;
import java.util.Random;

public class KnapSack {

    public static void main(String[] args) {
        int[] sizes = {10, 100, 500, 1000, 2000, 5000, 10000};

        for (int n : sizes) {
            double avg = 0;

            int[][] items = generateItems(n);

            for (int i = 0; i < 10; i++) {
                int[][] copy = deepCopy(items);
                avg += time(copy, 1000); // max weight
            }

            System.out.print((avg / 10) + ", ");
        }
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

    public static double time(int[][] arr, int mw) {
        long t1 = System.nanoTime();
        knapSack(arr, mw);
        long t2 = System.nanoTime();

        return (t2 - t1) / 1_000_000.0; // ms
    }

    private static int[][] generateItems(int n) {
        Random rd = new Random();
        int[][] items = new int[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = rd.nextInt(1000) + 1; // value
            items[i][1] = rd.nextInt(100) + 1;  // weight
        }

        return items;
    }

    private static int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            copy[i][0] = arr[i][0];
            copy[i][1] = arr[i][1];
        }
        return copy;
    }
}