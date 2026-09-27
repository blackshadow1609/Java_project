record Temperature(double celsius) {
    public Temperature {
        if (celsius < -273.15) {
            throw new IllegalArgumentException("Температура ниже абсолютного нуля");
        }
    }

    public double toFahrenheit() {
        return celsius * 9 / 5 + 32;
    }
}

public class task1 {
    public static void main(String[] args) {
        try {
            Temperature t1 = new Temperature(-300);
            System.out.println(t1);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        Temperature t2 = new Temperature(25);
        System.out.println("25°C = " + t2.toFahrenheit() + "°F");
    }
}