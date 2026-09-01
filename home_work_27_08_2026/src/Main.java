import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите ваше имя: ");
    String name = scanner.nextLine();

    System.out.print("Введите ваш возраст: ");
    int age = scanner.nextInt();

    System.out.println("Привет, " + name + "! Тебе " + age + " лет.");

    scanner.close();
}