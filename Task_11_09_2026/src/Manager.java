public class Manager extends Employee {

    public Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculatePay() {
        return getBaseSalary() * 1.2;
    }
}