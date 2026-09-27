import java.util.HashSet;
import java.util.Objects;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class task1 {
    public static void main(String[] args) {
        Point p1 = new Point(3, 5);
        Point p2 = new Point(3, 5);

        System.out.println("Сравнение через ==: " + (p1 == p2));
        System.out.println("Сравнение через equals(): " + p1.equals(p2));

        HashSet<Point> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        System.out.println("Размер множества: " + set.size());
    }
}