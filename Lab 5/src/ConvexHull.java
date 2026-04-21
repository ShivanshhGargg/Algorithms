import java.util.*;

class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class ConvexHull {

    static double orientation(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) -
                (b.y - a.y) * (c.x - a.x);
    }

    static double distSq(Point a, Point b) {
        return (a.x - b.x)*(a.x - b.x) +
                (a.y - b.y)*(a.y - b.y);
    }

    public static List<Point> convexHull(List<Point> points) {
        int n = points.size();
        if (n < 3) return points;

        Point p0 = points.get(0);
        for (Point p : points) {
            if (p.y < p0.y || (p.y == p0.y && p.x < p0.x)) {
                p0 = p;
            }
        }

        Point finalP0 = p0;

        points.sort((a, b) -> {
            double o = orientation(finalP0, a, b);
            if (o == 0)
                return Double.compare(distSq(finalP0, a), distSq(finalP0, b));
            return (o > 0) ? -1 : 1;
        });

        Stack<Point> stack = new Stack<>();
        stack.push(points.get(0));
        stack.push(points.get(1));
        stack.push(points.get(2));

        for (int i = 3; i < n; i++) {
            while (stack.size() > 1 &&
                    orientation(nextToTop(stack), stack.peek(), points.get(i)) <= 0) {
                stack.pop();
            }
            stack.push(points.get(i));
        }

        return new ArrayList<>(stack);
    }

    static Point nextToTop(Stack<Point> stack) {
        Point top = stack.pop();
        Point res = stack.peek();
        stack.push(top);
        return res;
    }

    public static double time(List<Point> points) {
        long t1 = System.nanoTime();
        convexHull(points);
        long t2 = System.nanoTime();

        return (t2 - t1) / 1_000_000.0; // ms
    }

    public static List<Point> generatePoints(int n) {
        Random rd = new Random();
        List<Point> pts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pts.add(new Point(rd.nextDouble() * 1000, rd.nextDouble() * 1000));
        }
        return pts;
    }

    public static void main(String[] args) {
        int[] sizes = {10, 100, 500, 1000, 2000, 5000, 10000};

        for (int n : sizes) {
            double avg = 0;

            List<Point> pts = generatePoints(n);

            for (int i = 0; i < 10; i++) {
                List<Point> copy = new ArrayList<>(pts);
                avg += time(copy);
            }

            System.out.print((avg / 10) + ", ");
        }
    }
}