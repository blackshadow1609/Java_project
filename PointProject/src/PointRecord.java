import java.util.HashSet;
import java.util.Set;

public record PointRecord(int x, int y) {

    public static void main(String[] args) {
        PointRecord p1 = new PointRecord(3, 5);
        PointRecord p2 = new PointRecord(3, 5);

        System.out.println("p1.equals(p2): " + p1.equals(p2));

        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("Хэш-коды совпадают? " + (p1.hashCode() == p2.hashCode()));

        System.out.println("p1.toString(): " + p1);

        Set<PointRecord> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        System.out.println("Размер HashSet: " + set.size());
        System.out.println("Содержимое HashSet: " + set);

        System.out.println("p1.x() = " + p1.x() + ", p1.y() = " + p1.y());
    }
}