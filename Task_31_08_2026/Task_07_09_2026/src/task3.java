class BankAccount {
    String owner;
    double balance;

    BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Успешно пополнено на " + amount);
        } else {
            System.out.println("Сумма должна быть положительной");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Сумма должна быть положительной");
        } else if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Успешно снято " + amount);
        } else {
            System.out.println("Недостаточно средств");
        }
    }

    void printInfo() {
        System.out.println("Владелец: " + owner + ", баланс: " + balance);
    }
}

void main() {
    BankAccount account = new BankAccount("Михаил Иванов", 1500.0);

    System.out.println("Текущий счет:");
    account.printInfo();
    System.out.println();

    account.deposit(300.0);
    account.printInfo();
    System.out.println();

    account.withdraw(200.0);
    account.printInfo();
    System.out.println();

    account.withdraw(2000.0);
    account.printInfo();
    System.out.println();

    account.withdraw(100.0);
    account.printInfo();
}