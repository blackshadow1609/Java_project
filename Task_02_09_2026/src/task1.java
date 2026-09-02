void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите ваш возраст: ");
    int age = scanner.nextInt();

    boolean result = checkAge(age);

    if (result == true) {
        System.out.println("Человек подходит под условие выдачи кредита)))");
    } else {
        System.out.println("Человек НЕ подходит под условие выдачи кредита)))");
    }
}

boolean checkAge(int age) {
    if (age >= 18 && age <= 60) {
        return true;
    } else {
        return false;
    }
}