import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Task3 {

    public static void main(String[] args) {
        User user = new User(
                "alina",
                "super_secret_123",
                new Address("Москва", "Тверская"),
                List.of("чтение", "программирование", "велосипед")
        );

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(user);
        System.out.println("=== JSON пользователя ===");
        System.out.println(json);

        User restored = gson.fromJson(json, User.class);

        System.out.println();
        System.out.println("=== Проверка после десериализации ===");
        System.out.println("login: " + restored.getLogin());
        System.out.println("password: " + restored.getPassword());
        System.out.println("address.city: " + restored.getAddress().getCity());
        System.out.println("hobbies: " + restored.getHobbies());

        if (restored.getPassword() == null) {
            System.out.println("password не попал в JSON и после десериализации равен null");
        } else {
            System.out.println("password восстановился: " + restored.getPassword());
        }
    }
}