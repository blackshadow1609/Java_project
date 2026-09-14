public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(char type, double width, double height) {
        super(type);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}