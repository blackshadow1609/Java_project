void main() {
    Scanner scanner = new Scanner(System.in);

    int[] array = {10, 20, 30, 40, 50};

    System.out.print("Введите индекс массива (0-4): ");
    int index = scanner.nextInt();
    System.out.print("Введите делитель: ");
    int divider = scanner.nextInt();

    try {
        int element = array[index];
        int divisionResult = element / divider;
        System.out.println("Элемент по индексу " + index + " = " + element);
        System.out.println("Результат деления: " + element + " / " + divider + " = " + divisionResult);
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Ошибка: индекс вне границ массива (допустимо 0-4)");
    } catch (ArithmeticException e) {
        System.out.println("Ошибка: деление на ноль");
    } finally {
        System.out.println("Попытка обработки завершена");
    }

    scanner.close();
}