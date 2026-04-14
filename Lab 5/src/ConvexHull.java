import java.util.*;

public class ConvexHull {
    public static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int orientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);
    }

    public static List<Point> convexHull(List<Point> points) {
        int n = points.size();
        if (n <= 1) return points;

        points.sort((a, b) -> {
            if (a.x == b.x) return a.y - b.y;
            return a.x - b.x;
        });

        List<Point> lower = new ArrayList<>();
        for (Point p : points) {
            while (lower.size() >= 2 &&
                    orientation(lower.get(lower.size()-2),
                            lower.get(lower.size()-1), p) >= 0) {
                lower.remove(lower.size()-1);
            }
            lower.add(p);
        }

        List<Point> upper = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            Point p = points.get(i);
            while (upper.size() >= 2 &&
                    orientation(upper.get(upper.size()-2),
                            upper.get(upper.size()-1), p) >= 0) {
                upper.remove(upper.size()-1);
            }
            upper.add(p);
        }

        lower.remove(lower.size() - 1);
        upper.remove(upper.size() - 1);

        lower.addAll(upper);
        return lower;
    }

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(0,3), new Point(2,2),
                new Point(1,1), new Point(2,1),
                new Point(3,0), new Point(0,0),
                new Point(3,3)
        );

        List<Point> hull = convexHull(points);

        System.out.println("Convex Hull:");
        for (Point p : hull) {
            System.out.println(p.x + " " + p.y);
        }
    }
}