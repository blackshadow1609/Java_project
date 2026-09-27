import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        System.out.print("Сколько слов ввести? ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Слово " + (i + 1) + ": ");
            list.add(scanner.nextLine());
        }

        HashSet<String> set = new HashSet<>(list);

        System.out.println("Размер списка: " + list.size());
        System.out.println("Размер множества (уникальных): " + set.size());
        System.out.println("Повторов было: " + (list.size() - set.size()));
        System.out.println("Уникальные слова: " + set);
    }
}