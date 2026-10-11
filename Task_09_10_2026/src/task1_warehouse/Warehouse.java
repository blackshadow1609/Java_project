package task1_warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class Warehouse {


    private final Map<String, Integer> stock = new HashMap<>();

    private final Map<String, Double> prices = new HashMap<>();

    private final AtomicLong totalRestocked = new AtomicLong(0);
    private final AtomicLong totalSold      = new AtomicLong(0);
    private final AtomicLong successfulBuys = new AtomicLong(0);
    private final AtomicLong failedBuys     = new AtomicLong(0);
    private final AtomicLong revenue        = new AtomicLong(0);

    private final boolean useSync;

    public Warehouse(boolean useSync) {
        this.useSync = useSync;
    }

    public void addProduct(Product p, int quantity) {
        stock.put(p.getSku(), quantity);
        prices.put(p.getSku(), p.getPrice());
    }

    public Map<String, Integer> getStock() {
        return new HashMap<>(stock); // копия для отчёта
    }

    public double getPrice(String sku) {
        return prices.getOrDefault(sku, 0.0);
    }

    public long getTotalRestocked() { return totalRestocked.get(); }
    public long getTotalSold()      { return totalSold.get(); }
    public long getSuccessfulBuys() { return successfulBuys.get(); }
    public long getFailedBuys()     { return failedBuys.get(); }
    public long getRevenue()        { return revenue.get(); }

    public boolean reserve(String sku, int qty) {
        if (useSync) {
            synchronized (this) {
                return reserveInternal(sku, qty);
            }
        } else {
            return reserveInternal(sku, qty);
        }
    }

    private boolean reserveInternal(String sku, int qty) {
        Integer current = stock.get(sku);
        if (current == null) {
            failedBuys.incrementAndGet();
            return false;
        }
        if (current < qty) {
            failedBuys.incrementAndGet();
            return false;
        }

        Thread.yield();
        stock.put(sku, current - qty);
        totalSold.addAndGet(qty);
        successfulBuys.incrementAndGet();
        revenue.addAndGet((long) (prices.get(sku) * qty));
        return true;
    }

    public void restock(String sku, int qty) {
        if (useSync) {
            synchronized (this) {
                restockInternal(sku, qty);
            }
        } else {
            restockInternal(sku, qty);
        }
    }

    private void restockInternal(String sku, int qty) {
        Integer current = stock.get(sku);
        if (current == null) return;
        Thread.yield();
        stock.put(sku, current + qty);
        totalRestocked.addAndGet(qty);
    }
}