import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел (n): ");
        int n = scanner.nextInt();
        scanner.nextLine();

        int simpleCount = 0;

        for (int i = 2; i <= n; i++) {
            boolean isSimple = true;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isSimple = false;
                    break;
                }
            }

            if (isSimple) {
                simpleCount++;
            }

            int temp = i;
            int digitSum = 0;
            while (temp > 0) {
                digitSum += temp % 10;
                temp /= 10;
            }

            System.out.println("Число: " + i + ", Сумма его цифр: " + digitSum);
        }

        System.out.println("---");
        System.out.println("Общее количество простых чисел: " + simpleCount);
        scanner.close();
    }
}