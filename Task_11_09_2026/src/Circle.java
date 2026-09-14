public class Circle extends Shape {
    private double radius;

    public Circle(char type, double radius) {
        super(type);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}