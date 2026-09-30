import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        String json = """
                [
                  {"name": "Аня", "age": 19, "grade": 4.5},
                  {"name": "Борис", "age": 21, "grade": 3.8},
                  {"name": "Вера", "age": 20, "grade": 4.9}
                ]
                """;

        Gson gson = new Gson();

        Type listType = new TypeToken<List<Student>>() {}.getType();
        List<Student> students = gson.fromJson(json, listType);

        System.out.println("Все студенты:");
        students.forEach(System.out::println);

        System.out.println();
        System.out.println("С оценкой выше 4.0:");
        students.stream()
                .filter(s -> s.getGrade() > 4.0)
                .map(Student::getName)
                .forEach(System.out::println);

        double average = students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0);

        System.out.printf("%nСредний балл группы: %.2f%n", average);
    }
}