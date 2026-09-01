import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число n: ");
        int n = scanner.nextInt();

        System.out.println("Простые числа от 2 до " + n + ":");
        System.out.println("-----------------------------------");

        int primeCount = 0;

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primeCount++;
                int temp = i;
                int digitSum = 0;
                while (temp > 0) {
                    digitSum += temp % 10;
                    temp /= 10;
                }

                System.out.println("Число: " + i + ", Сумма цифр: " + digitSum);
            }
        }

        System.out.println("-----------------------------------");
        System.out.println("Общее количество простых чисел: " + primeCount);

        scanner.close();
    }
}