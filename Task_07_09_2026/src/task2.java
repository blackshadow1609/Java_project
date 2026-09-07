class Rectangle {
    double width;
    double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double getArea() {
        return width * height;
    }

    double getPerimeter() {
        return 2 * (width + height);
    }
}

void main() {
    Rectangle rect1 = new Rectangle(5.0, 3.0);
    Rectangle rect2 = new Rectangle(4.5, 6.0);

    double area1 = rect1.getArea();
    double area2 = rect2.getArea();
    double perim1 = rect1.getPerimeter();
    double perim2 = rect2.getPerimeter();

    System.out.println("Прямоугольник 1: ширина = " + rect1.width + ", высота = " + rect1.height);
    System.out.println("Площадь = " + area1 + ", Периметр = " + perim1);
    System.out.println();
    System.out.println("Прямоугольник 2: ширина = " + rect2.width + ", высота = " + rect2.height);
    System.out.println("Площадь = " + area2 + ", Периметр = " + perim2);
    System.out.println();

    if (area1 > area2) {
        System.out.println("Площадь первого прямоугольника больше");
    } else if (area2 > area1) {
        System.out.println("Площадь второго прямоугольника больше");
    } else {
        System.out.println("Площади прямоугольников равны");
    }
}