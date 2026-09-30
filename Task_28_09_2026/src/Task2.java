import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task2 {

    private static final String FILE_NAME = "data.bin";

    public static void main(String[] args) throws IOException {
        byte[] data = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        try (FileOutputStream out = new FileOutputStream(FILE_NAME)) {
            out.write(data);
        }

        System.out.println("Записано в файл " + FILE_NAME + ":");
        try (FileInputStream in = new FileInputStream(FILE_NAME)) {
            int b;
            while ((b = in.read()) != -1) {
                System.out.println(b);
            }
        }

        File file = new File(FILE_NAME);
        System.out.println("Размер файла: " + file.length() + " байт");
    }
}