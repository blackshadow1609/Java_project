import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task3 {

    private static final String SOURCE = "photo.jpg";
    private static final String DESTINATION = "photo_copy.jpg";

    public static void main(String[] args) {
        File source = new File(SOURCE);
        File destination = new File(DESTINATION);

        if (!source.exists()) {
            System.out.println("Файл " + SOURCE + " не найден. Положите картинку в корень проекта.");
            return;
        }

        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Ошибка при копировании: " + e.getMessage());
            return;
        }

        System.out.println("Размер источника: " + source.length() + " байт");
        System.out.println("Размер копии:     " + destination.length() + " байт");

        if (source.length() == destination.length()) {
            System.out.println("Копия успешна");
        } else {
            System.out.println("Ошибка: размеры файлов не совпадают");
        }
    }
}