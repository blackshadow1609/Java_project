public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Некорректная сумма пополнения");
        } else {
            balance = balance + amount;
            System.out.println("Пополнение на " + amount + " прошло успешно");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Некорректная сумма снятия");
        } else if (amount > balance) {
            System.out.println("Недостаточно средств на счёте");
        } else {
            balance = balance - amount;
            System.out.println("Снятие " + amount + " прошло успешно");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Алексей", 1000.0);

        System.out.println("Владелец: " + account.getOwner());
        System.out.println("Начальный баланс: " + account.getBalance());

        System.out.println("\n--- Пробуем некорректное пополнение ---");
        account.deposit(-500);
        System.out.println("Баланс: " + account.getBalance());

        System.out.println("\n--- Пробуем корректное пополнение ---");
        account.deposit(2000);
        System.out.println("Баланс: " + account.getBalance());

        System.out.println("\n--- Пробуем снять отрицательную сумму ---");
        account.withdraw(-100);
        System.out.println("Баланс: " + account.getBalance());

        System.out.println("\n--- Пробуем снять больше, чем есть ---");
        account.withdraw(10000);
        System.out.println("Баланс: " + account.getBalance());

        System.out.println("\n--- Пробуем корректное снятие ---");
        account.withdraw(1500);
        System.out.println("Баланс: " + account.getBalance());
    }
}