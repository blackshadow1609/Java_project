public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Цена не может быть отрицательной");
        } else {
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Product product = new Product("Хлеб", 50.0);
        System.out.println("Товар: " + product.getName());
        System.out.println("Начальная цена: " + product.getPrice());

        // Успешная установка цены
        product.setPrice(75.5);
        System.out.println("Новая цена: " + product.getPrice());

        // Попытка установить отрицательную цену
        product.setPrice(-10);
        System.out.println("Цена после попытки: " + product.getPrice());
    }
}