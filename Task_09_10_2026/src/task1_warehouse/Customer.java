package task1_warehouse;

import java.util.List;
import java.util.Random;

public class Customer implements Runnable {

    private final String name;
    private final Warehouse warehouse;
    private final List<String> skus;
    private final Random random = new Random();

    private int success = 0;
    private int failed  = 0;

    public Customer(String name, Warehouse warehouse, List<String> skus) {
        this.name = name;
        this.warehouse = warehouse;
        this.skus = skus;
    }

    public int getSuccess() { return success; }
    public int getFailed()  { return failed; }
    public String getName() { return name; }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            String sku = skus.get(random.nextInt(skus.size()));
            int qty = 1 + random.nextInt(5); // 1..5

            if (warehouse.reserve(sku, qty)) {
                success++;
            } else {
                failed++;
            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}