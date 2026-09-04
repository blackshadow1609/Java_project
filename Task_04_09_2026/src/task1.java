void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите делимое: ");
    int dividend = scanner.nextInt();

    System.out.print("Введите делитель: ");
    int divisor = scanner.nextInt();

    try {
        double result = (double) dividend / divisor;
        System.out.println("Результат деления: " + result);
    } catch (ArithmeticException e) {
        System.out.println("На ноль делить нельзя");
    } finally {
        System.out.println("Программа завершена");
        scanner.close();
    }
}