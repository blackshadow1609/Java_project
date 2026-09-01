import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел Фибоначчи (n): ");
        int n = scanner.nextInt();

        System.out.println("Первые " + n + " чисел Фибоначчи:");

        long first = 0;
        long second = 1;

        for (int i = 1; i <= n; i++) {
            long current;

            if (i == 1) {
                current = first;
            } else if (i == 2) {
                current = second;
            } else {
                current = first + second;
                first = second;
                second = current;
            }

            if (current % 3 == 0 && current != 0) {
                System.out.print("Fizz ");
            } else {
                System.out.print(current + " ");
            }
        }

        scanner.close();
    }
}