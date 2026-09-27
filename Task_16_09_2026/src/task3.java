import java.util.Scanner;

interface Payable {
    double calculatePay();
}

abstract class Employee implements Payable {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double getBonus();

    @Override
    public double calculatePay() {
        return baseSalary + getBonus();
    }
}

class Manager extends Employee {
    public Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return getBaseSalary() * 0.20;
    }
}

class Developer extends Employee {
    public Developer(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return 15000;
    }
}

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество сотрудников: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Payable[] employees = new Payable[n];
        double totalSum = 0;
        double maxSalary = 0;
        String maxName = "";

        for (int i = 0; i < n; i++) {
            System.out.println("Сотрудник " + (i + 1));
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();

            System.out.print("Введите оклад: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Введите тип (1 - Manager, 2 - Developer): ");
            int type = scanner.nextInt();
            scanner.nextLine();

            Employee emp = null;

            switch (type) {
                case 1:
                    emp = new Manager(name, salary);
                    break;
                case 2:
                    emp = new Developer(name, salary);
                    break;
                default:
                    System.out.println("Неверный тип, создан Developer по умолчанию");
                    emp = new Developer(name, salary);
                    break;
            }

            employees[i] = emp;
        }

        for (Payable p : employees) {
            double pay = p.calculatePay();
            totalSum += pay;

            Employee emp = (Employee) p;
            System.out.println("Сотрудник: " + emp.getName() + ", выплата: " + pay);

            if (pay > maxSalary) {
                maxSalary = pay;
                maxName = emp.getName();
            }
        }

        System.out.println("Общая сумма выплат: " + totalSum);
        System.out.println("Наибольшая зарплата у: " + maxName + " (" + maxSalary + ")");
    }
}