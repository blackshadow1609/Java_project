import java.util.ArrayList;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> shoppingList = new ArrayList<>();

        System.out.println("Вводите товары (для остановки введите 'стоп'):");
        while (true) {
            String item = scanner.nextLine();
            if (item.equals("стоп")) {
                break;
            }
            shoppingList.add(item);
        }

        System.out.println("Список покупок: " + shoppingList);

        System.out.print("Введите товар для удаления: ");
        String toRemove = scanner.nextLine();

        if (shoppingList.remove(toRemove)) {
            System.out.println("Товар удалён.");
        } else {
            System.out.println("Товар не найден");
        }

        System.out.println("Итоговый список: " + shoppingList);
        System.out.println("Размер списка: " + shoppingList.size());
    }
}