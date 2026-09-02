void main() {
    Scanner scanner = new Scanner(System.in);
    int sum = 0;
    int count = 0;
    String input;

    System.out.println("Вводите оценки (2-5). Для завершения введите 'стоп'");

    while (true) {
        System.out.print("Введите оценку: ");
        input = scanner.nextLine();

        if (input.equals("стоп")) {
            break;
        }

        if (input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5")) {
            int grade = Integer.parseInt(input);
            sum = sum + grade;
            count = count + 1;
            System.out.println("Оценка: " + grade);
        } else {
            System.out.println("Ошибка: введите число от 2 до 5 или 'стоп' для выхода");
        }
    }

    if (count > 0) {
        double average = (double) sum / count;
        System.out.println("Количество оценок: " + count);
        System.out.println("Средний балл: " + average);

        if (average >= 4.5) {
            System.out.println("Отлично!");
        } else if (average >= 3.5) {
            System.out.println("Хорошо");
        } else if (average >= 2.5) {
            System.out.println("Удовлетворительно");
        } else {
            System.out.println("Неудовлетворительно");
        }
    } else {
        System.out.println("Нет оценок");
    }
}