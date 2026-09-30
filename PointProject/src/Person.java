import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return this.age == other.age && Objects.equals(this.name, other.name);
    }


    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    public static void main(String[] args) {
        Person p1 = new Person("Алиса", 25);
        Person p2 = new Person("Алиса", 25);

        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("Хэш-коды совпадают? " + (p1.hashCode() == p2.hashCode()));

        Map<Person, String> map = new HashMap<>();
        map.put(p1, "первый");
        map.put(p2, "второй");

        System.out.println("Размер HashMap: " + map.size());
        System.out.println("Содержимое HashMap: " + map);
    }
}