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
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Некорректная сумма снятия");
        } else if (amount > balance) {
            System.out.println("Недостаточно средств");
        } else {
            balance -= amount;
        }
    }

    public double calculateYearlyReport() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}