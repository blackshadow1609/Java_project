import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задачу (1-4):");
        System.out.println("1 — Person / Student (полиморфизм displayInfo)");
        System.out.println("2 — BankAccount / SavingsAccount / CheckingAccount");
        System.out.println("3 — Shape / Circle / Rectangle (describe вызывает area)");
        System.out.println("4 — Student[] и Arrays.sort по оценке");
        System.out.print("> ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> runTask1(scanner);
            case 2 -> runTask2();
            case 3 -> runTask3(scanner);
            case 4 -> runTask4(scanner);
            default -> System.out.println("Нет такой задачи");
        }
    }

    // Задача 1
    static void runTask1(Scanner scanner) {
        System.out.println("\n=== Задача 1: Person и Student ===");

        Person[] people = new Person[4];

        for (int i = 0; i < people.length; i++) {
            System.out.println("\nЧеловек №" + (i + 1));
            System.out.print("Тип (P — Person, S — Student): ");
            char type = scanner.next().charAt(0);
            scanner.nextLine();

            System.out.print("Имя: ");
            String name = scanner.nextLine();

            System.out.print("Возраст: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            switch (type) {
                case 'S' -> {
                    System.out.print("Оценка (0-10): ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine();
                    people[i] = new Student(name, age, grade);
                }
                case 'P' -> people[i] = new Person(name, age);
                default -> {
                    System.out.println("Неизвестный тип — создаём Person");
                    people[i] = new Person(name, age);
                }
            }
        }

        System.out.println("\n===== ИНФОРМАЦИЯ О ЛЮДЯХ =====");
        for (Person p : people) {
            p.displayInfo(); // полиморфизм
        }
    }

    //  Задача 2
    static void runTask2() {
        System.out.println("\n=== Задача 2: отчёт по счетам ===");

        BankAccount[] accounts = new BankAccount[] {
                new BankAccount("Иван", 10000),
                new SavingsAccount("Мария", 50000, 0.05),
                new CheckingAccount("Пётр", 20000, 500),
                new SavingsAccount("Ольга", 100000, 0.10)
        };

        for (BankAccount acc : accounts) {
            double forecast = acc.calculateYearlyReport();
            System.out.println(acc.getOwner()
                    + " | текущий баланс: " + acc.getBalance()
                    + " | прогноз через год: " + forecast);
        }
    }

    // Задача 3
    static void runTask3(Scanner scanner) {
        System.out.println("\n=== Задача 3: фигуры ===");

        System.out.print("Введите количество фигур: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Shape[] shapes = new Shape[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nФигура №" + (i + 1));
            System.out.print("Тип (C — круг, R — прямоугольник): ");
            char type = scanner.next().charAt(0);
            scanner.nextLine();

            switch (type) {
                case 'C' -> {
                    System.out.print("Радиус: ");
                    double r = scanner.nextDouble();
                    scanner.nextLine();
                    shapes[i] = new Circle(r);
                }
                case 'R' -> {
                    System.out.print("Ширина: ");
                    double w = scanner.nextDouble();
                    System.out.print("Высота: ");
                    double h = scanner.nextDouble();
                    scanner.nextLine();
                    shapes[i] = new Rectangle(w, h);
                }
                default -> {
                    System.out.println("Неизвестный тип, создаём Shape");
                    shapes[i] = new Shape("Абстрактная фигура");
                }
            }
        }

        System.out.println("\n===== ОПИСАНИЕ ФИГУР =====");
        for (Shape s : shapes) {
            s.describe();
        }
    }

    // Задача 4
    static void runTask4(Scanner scanner) {
        System.out.println("\n=== Задача 4: сортировка студентов ===");

        Student[] students = new Student[5];

        for (int i = 0; i < students.length; i++) {
            System.out.println("\nСтудент №" + (i + 1));

            System.out.print("Имя: ");
            String name = scanner.nextLine();

            System.out.print("Возраст: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Средний балл (0-10): ");
            double grade = scanner.nextDouble();
            scanner.nextLine();

            students[i] = new Student(name, age, grade);
        }

        Arrays.sort(students);

        System.out.println("\n===== СТУДЕНТЫ ПО ВОЗРАСТАНИЮ ОЦЕНКИ =====");
        for (Student s : students) {
            s.displayInfo();
        }
    }
}