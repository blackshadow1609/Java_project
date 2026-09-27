import java.util.HashSet;

PointRecord(int x, int y) {
}

public class PointRecord {
    public static void main(String[] args) {
        Point p1 = new Point(3, 5);
        Point p2 = new Point(3, 5);

        System.out.println("Сравнение через ==: " + (p1 == p2));
        System.out.println("Сравнение через equals(): " + p1.equals(p2));
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("toString: " + p1);

        HashSet<Point> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        System.out.println("Размер множества: " + set.size());

        // p1.x = 5; // не скомпилируется: поля record неявно final
    }
}