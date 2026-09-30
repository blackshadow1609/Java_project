import java.util.List;

public class task2 {

    public static void main(String[] args) {
        List<String> names = List.of("иван", "Мария", "ПЁТР", "анна", "сергей", "ОЛЬГА");

        names.stream()
                .map(task2::capitalize)
                .sorted()
                .forEach(System.out::println);
    }

    public static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}