import java.util.HashMap;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложение:");
        String sentence = scanner.nextLine();

        String[] words = sentence.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        System.out.println("Частота слов:");
        for (String key : map.keySet()) {
            System.out.println(key + " — " + map.get(key));
        }
    }
}