import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задачу (1-4):");
        System.out.println("1 — Animal / Dog");
        System.out.println("2 — Vehicle / Car");
        System.out.println("3 — Employee / Manager / Developer");
        System.out.println("4 — Shape / Circle / Rectangle");
        System.out.print("> ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> runTask1();
            case 2 -> runTask2();
            case 3 -> runTask3(scanner);
            case 4 -> runTask4(scanner);
            default -> System.out.println("Нет такой задачи");
        }
    }

    // Задача 1
    static void runTask1() {
        System.out.println("\n=== Задача 1: Animal и Dog ===");

        Dog dog = new Dog("Бобик");
        System.out.println("Имя: " + dog.getName());
        dog.makeSound();
    }

    // Задача 2
    static void runTask2() {
        System.out.println("\n=== Задача 2: Vehicle и Car ===");

        Car car = new Car();
        car.setSpeed(120);
        car.setBrand("Toyota");

        System.out.println("Марка: " + car.getBrand());
        System.out.println("Скорость: " + car.getSpeed());

        car.setSpeed(-50);
        System.out.println("Скорость после попытки: " + car.getSpeed());
    }

    // Задача 3
    static void runTask3(Scanner scanner) {
        System.out.println("\n=== Задача 3: ведомость ===");

        System.out.print("Введите количество сотрудников: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nСотрудник №" + (i + 1));

            System.out.print("Имя: ");
            String name = scanner.nextLine();

            System.out.print("Базовая зарплата: ");
            double salary = scanner.nextDouble();

            System.out.print("Тип (M — менеджер, D — разработчик): ");
            char type = scanner.next().charAt(0);
            scanner.nextLine();

            switch (type) {
                case 'M' -> employees[i] = new Manager(name, salary);
                case 'D' -> employees[i] = new Developer(name, salary);
                default -> {
                    System.out.println("Неизвестный тип, создаём Employee");
                    employees[i] = new Employee(name, salary);
                }
            }
        }

        System.out.println("\n===== ВЕДОМОСТЬ =====");
        double total = 0;

        for (Employee emp : employees) {
            double pay = emp.calculatePay();
            total += pay;
            System.out.println(emp.getName() + " — выплата: " + pay);
        }

        System.out.println("---------------------");
        System.out.println("Общая сумма выплат: " + total);
    }

    //  Задача 4
    static void runTask4(Scanner scanner) {
        System.out.println("\n=== Задача 4: фигуры ===");

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
                    double radius = scanner.nextDouble();
                    scanner.nextLine();
                    shapes[i] = new Circle('C', radius);
                }
                case 'R' -> {
                    System.out.print("Ширина: ");
                    double width = scanner.nextDouble();
                    System.out.print("Высота: ");
                    double height = scanner.nextDouble();
                    scanner.nextLine();
                    shapes[i] = new Rectangle('R', width, height);
                }
                default -> {
                    System.out.println("Неизвестный тип, пропускаем");
                    shapes[i] = new Shape('?');
                }
            }
        }

        System.out.println("\n===== ПЛОЩАДИ ФИГУР =====");

        Shape maxShape = shapes[0];
        double maxArea = shapes[0].area();

        for (Shape s : shapes) {
            double a = s.area();
            System.out.println("Тип: " + s.getType() + ", площадь: " + a);

            if (a > maxArea) {
                maxArea = a;
                maxShape = s;
            }
        }

        System.out.println("\nФигура с максимальной площадью:");
        System.out.println("Тип: " + maxShape.getType() + ", площадь: " + maxArea);
    }
}