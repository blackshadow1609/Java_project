import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк треугольника Паскаля (n): ");
        int n = scanner.nextInt();

        System.out.println("\nТреугольник Паскаля (первые " + n + " строк):");
        System.out.println("=============================================");

        for (int row = 0; row < n; row++) {
            for (int space = 0; space < n - row - 1; space++) {
                System.out.print("   ");
            }

            for (int col = 0; col <= row; col++) {
                long coefficient = calculateBinomial(row, col);
                System.out.printf("%-6d", coefficient);
            }
            System.out.println();
        }

        scanner.close();
    }

    public static long calculateBinomial(int n, int k) {
        if (k > n - k) {
            k = n - k;
        }

        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - k + i) / i;
        }

        return result;
    }
}