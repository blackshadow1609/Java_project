import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Task1 {

    public static void main(String[] args) {
        Book book = new Book("Мастер и Маргарита", "Михаил Булгаков", 1967, 850.50);

        Gson gson = new Gson();
        String compact = gson.toJson(book);
        System.out.println("=== Обычный JSON ===");
        System.out.println(compact);

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        String pretty = prettyGson.toJson(book);
        System.out.println();
        System.out.println("=== Красивый JSON ===");
        System.out.println(pretty);
    }
}