interface Drawable {
    void draw();
}

class Circle implements Drawable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Рисуем круг с радиусом: " + radius);
    }
}

class TextLabel implements Drawable {
    private String text;

    public TextLabel(String text) {
        this.text = text;
    }

    @Override
    public void draw() {
        System.out.println("Рисуем текст: " + text);
    }
}

public class task2 {
    public static void main(String[] args) {
        Drawable[] items = new Drawable[3];
        items[0] = new Circle(5.5);
        items[1] = new TextLabel("Привет");
        items[2] = new Circle(10.0);

        for (Drawable d : items) {
            d.draw();
        }
    }
}