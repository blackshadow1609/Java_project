void main() {
    Scanner scanner = new Scanner(System.in);

    int number = 0;
    boolean isValid = false;

    while (!isValid) {
        System.out.print("Введите число: ");
        String input = scanner.nextLine();

        try {
            number = Integer.parseInt(input);
            isValid = true;
            System.out.println("Вы ввели число: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Введено не число");
        }
    }

    scanner.close();
}