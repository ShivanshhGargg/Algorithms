import java.util.*;

class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class ConvexHull {

    // Find orientation
    static double orientation(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) -
                (b.y - a.y) * (c.x - a.x);
    }

    // Distance squared
    static double distSq(Point a, Point b) {
        return (a.x - b.x)*(a.x - b.x) +
                (a.y - b.y)*(a.y - b.y);
    }

    public static List<Point> convexHull(List<Point> points) {
        int n = points.size();
        if (n < 3) return points;

        // Step 1: Find bottom-most point
        Point p0 = points.get(0);
        for (Point p : points) {
            if (p.y < p0.y || (p.y == p0.y && p.x < p0.x)) {
                p0 = p;
            }
        }

        Point finalP0 = p0;

        // Step 2: Sort by polar angle
        points.sort((a, b) -> {
            double o = orientation(finalP0, a, b);
            if (o == 0)
                return Double.compare(distSq(finalP0, a), distSq(finalP0, b));
            return (o > 0) ? -1 : 1;
        });

        // Step 3: Stack for hull
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

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(0, 3),
                new Point(2, 2),
                new Point(1, 1),
                new Point(2, 1),
                new Point(3, 0),
                new Point(0, 0),
                new Point(3, 3)
        );

        List<Point> hull = convexHull(points);

        System.out.println("Convex Hull:");
        for (Point p : hull) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
    }
}