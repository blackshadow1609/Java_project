import java.util.List;
import java.util.stream.Collectors;

public class Task3 {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Иван", 3),
                new Student("Мария", 5),
                new Student("Пётр", 4),
                new Student("Анна", 2),
                new Student("Сергей", 5),
                new Student("Ольга", 4),
                new Student("Дмитрий", 3)
        );

        int threshold = 4;

        List<Student> best = students.stream()
                .filter(s -> s.getGrade() > threshold)
                .collect(Collectors.toList());

        System.out.println("Количество отобранных студентов: " + best.size());
        System.out.println("Имена:");
        best.stream()
                .map(Student::getName)
                .forEach(System.out::println);
    }
}