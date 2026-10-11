package task1_warehouse;

public class Product {
    private final String sku;
    private final String name;
    private final double price;

    public Product(String sku, String name, double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSku()   { return sku; }
    public String getName()  { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return sku + ";" + name + ";" + price;
    }
}