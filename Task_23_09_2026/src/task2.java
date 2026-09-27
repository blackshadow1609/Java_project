import java.util.HashMap;
import java.util.Objects;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
        return this.age == other.age && Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class task2 {
    public static void main(String[] args) {
        Person p1 = new Person("Иван", 25);
        Person p2 = new Person("Иван", 25);

        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());

        HashMap<Person, String> map = new HashMap<>();
        map.put(p1, "Первый");
        map.put(p2, "Второй");

        System.out.println("Размер HashMap: " + map.size());
        System.out.println("Значение по p1: " + map.get(p1));
        System.out.println("Значение по p2: " + map.get(p2));
    }
}