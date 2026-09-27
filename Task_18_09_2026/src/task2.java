interface Shape {
    double area();
    double perimeter();
}

record Rectangle(double width, double height) implements Shape {
    public Rectangle {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Стороны должны быть больше нуля");
        }
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    public static Rectangle square(double side) {
        return new Rectangle(side, side);
    }
}

public class task2 {
    public static void main(String[] args) {
        Shape s = new Rectangle(3, 4);
        System.out.println("Площадь: " + s.area());
        System.out.println("Периметр: " + s.perimeter());

        Rectangle sq = Rectangle.square(5);
        System.out.println("Квадрат: " + sq);
        System.out.println("Площадь квадрата: " + sq.area());

        try {
            new Rectangle(-1, 4);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}