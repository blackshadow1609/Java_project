import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Task1 {

    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) throws IOException {
        List<String> films = List.of("Матрица", "Начало", "Интерстеллар");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String film : films) {
                writer.write(film);
                writer.newLine();
            }
        }

        System.out.println("=== Содержимое файла после записи ===");
        printFileWithNumbers();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write("Побег из Шоушенка");
            writer.newLine();
        }

        System.out.println();
        System.out.println("=== Содержимое файла после дозаписи ===");
        printFileWithNumbers();
    }

    private static void printFileWithNumbers() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int number = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(number + ". " + line);
                number++;
            }
        }
    }
}