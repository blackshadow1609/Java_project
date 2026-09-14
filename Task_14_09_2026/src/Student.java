public class Student extends Person implements Comparable<Student> {
    private double grade; // в задаче 4 соответствует averageGrade

    public Student(String name, int age, double grade) {
        super(name, age);
        setGrade(grade);
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (grade < 0 || grade > 10) {
            System.out.println("Оценка должна быть от 0 до 10");
        } else {
            this.grade = grade;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Имя: " + getName() + ", возраст: " + getAge() + ", оценка: " + grade);
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.grade, other.grade);
    }
}