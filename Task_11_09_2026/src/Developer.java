public class Developer extends Employee {

    public Developer(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculatePay() {
        return getBaseSalary() + 15000;
    }
}