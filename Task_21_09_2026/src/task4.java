import java.util.ArrayList;
import java.util.Iterator;

public class task4 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println("Исходный список: " + numbers);

        try {
            for (Integer number : numbers) {
                if (number % 2 == 0) {
                    numbers.remove(number);
                }
            }
        } catch (Exception e) {
            System.out.println("Поймали ошибку: " + e.getClass().getSimpleName());
        }

        System.out.println("После неудачной попытки: " + numbers);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println("После удаления через Iterator: " + numbers);
    }
}