import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Название товара: ");
    String productName = scanner.nextLine();

    System.out.print("Цена за штуку (руб.): ");
    int price = scanner.nextInt();

    System.out.print("Количество: ");
    int quantity = scanner.nextInt();

    int total = price * quantity;

    System.out.println("\n========== ЧЕК ==========");
    System.out.println("Товар: " + productName);
    System.out.println("Цена: " + price + " руб.");
    System.out.println("Кол-во: " + quantity + " шт.");
    System.out.println("---------------------------");
    System.out.println("ИТОГО: " + total + " руб.");
    System.out.println("===========================");

    scanner.close();
}