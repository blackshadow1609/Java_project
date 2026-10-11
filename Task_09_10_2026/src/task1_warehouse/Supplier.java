package task1_warehouse;

import java.util.List;
import java.util.Random;

public class Supplier extends Thread {

    private volatile boolean open = true;
    private final Warehouse warehouse;
    private final List<String> skus;
    private final Random random = new Random();

    public Supplier(Warehouse warehouse, List<String> skus) {
        super("Поставщик");
        this.warehouse = warehouse;
        this.skus = skus;
    }

    public void close() {
        open = false;
    }

    @Override
    public void run() {
        while (open) {
            String sku = skus.get(random.nextInt(skus.size()));
            int qty = 1 + random.nextInt(5);
            warehouse.restock(sku, qty);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}