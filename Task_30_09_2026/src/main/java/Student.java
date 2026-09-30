public class Student {
    private String name;
    private int age;
    private double grade;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name + " (возраст " + age + ", балл " + grade + ")";
    }
}