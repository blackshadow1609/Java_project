package task1_warehouse;

import java.io.*;
import java.util.*;

public class WarehouseMain {

    public static void main(String[] args) throws Exception {

        List<Product> products = createProducts();
        writeStockCsv(products, "stock.csv");
        Map<String, Integer> initialStock = readStockCsv("stock.csv");

        System.out.println("=== С synchronized ===");
        runExperiment(initialStock, products, true, "report.txt");

        System.out.println();
        System.out.println("=== Без synchronized (10 прогонов) ===");
        for (int i = 1; i <= 10; i++) {
            System.out.print("Прогон " + i + ": ");
            runExperiment(initialStock, products, false, null);
        }
    }

    private static List<Product> createProducts() {
        List<Product> list = new ArrayList<>();
        list.add(new Product("SKU001", "Хлеб",   45.0));
        list.add(new Product("SKU002", "Молоко", 89.5));
        list.add(new Product("SKU003", "Сыр",    320.0));
        list.add(new Product("SKU004", "Колбаса",410.0));
        list.add(new Product("SKU005", "Яблоки", 120.0));
        list.add(new Product("SKU006", "Бананы", 95.0));
        list.add(new Product("SKU007", "Кофе",   650.0));
        list.add(new Product("SKU008", "Чай",    210.0));
        list.add(new Product("SKU009", "Печенье",75.0));
        list.add(new Product("SKU010", "Сок",    130.0));
        return list;
    }

    private static void writeStockCsv(List<Product> products, String file) throws IOException {
        Random rnd = new Random();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Product p : products) {
                int qty = 20 + rnd.nextInt(40); // 20..59
                bw.write(p.getSku() + ";" + p.getName() + ";" + qty);
                bw.newLine();
            }
        }
        System.out.println("Файл " + file + " создан.");
    }

    private static Map<String, Integer> readStockCsv(String file) throws IOException {
        Map<String, Integer> result = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                result.put(parts[0], Integer.parseInt(parts[2]));
            }
        }
        return result;
    }

    private static void runExperiment(Map<String, Integer> initialStock,
                                      List<Product> products,
                                      boolean useSync,
                                      String reportFile) throws Exception {

        Warehouse warehouse = new Warehouse(useSync);
        for (Product p : products) {
            warehouse.addProduct(p, initialStock.get(p.getSku()));
        }

        List<String> skus = new ArrayList<>(initialStock.keySet());

        Supplier supplier = new Supplier(warehouse, skus);
        supplier.start();


        List<Customer> customers = new ArrayList<>();
        List<Thread> customerThreads = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Customer c = new Customer("Покупатель-" + i, warehouse, skus);
            Thread t = new Thread(c, c.getName());
            customers.add(c);
            customerThreads.add(t);
            t.start();
        }

        for (Thread t : customerThreads) {
            t.join();
        }

        supplier.close();
        supplier.join();

        long initialTotal = initialStock.values().stream().mapToLong(Integer::longValue).sum();
        long restocked = warehouse.getTotalRestocked();
        long sold      = warehouse.getTotalSold();

        long expectedTotal = initialTotal + restocked - sold;
        long actualTotal = warehouse.getStock().values().stream()
                .mapToLong(Integer::longValue).sum();

        boolean balanceOk = (expectedTotal == actualTotal);

        System.out.println("initial=" + initialTotal
                + " + restocked=" + restocked
                + " - sold=" + sold
                + " => expected=" + expectedTotal
                + " actual=" + actualTotal
                + " | " + (balanceOk ? "OK" : "БАЛАНС ПОПЛЫЛ"));
        if (!balanceOk) {
            System.out.println("   расхождение: " + (expectedTotal - actualTotal));
        }

        if (reportFile != null) {
            writeReport(reportFile, warehouse, customers, products);
            System.out.println("Отчёт записан в " + reportFile);
        }
    }

    private static void writeReport(String file,
                                    Warehouse warehouse,
                                    List<Customer> customers,
                                    List<Product> products) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("=== ОСТАТКИ ===");
            bw.newLine();
            Map<String, Integer> stock = warehouse.getStock();
            for (Product p : products) {
                bw.write(p.getSku() + " (" + p.getName() + "): " + stock.get(p.getSku()));
                bw.newLine();
            }

            bw.newLine();
            bw.write("=== ПОКУПАТЕЛИ ===");
            bw.newLine();
            for (Customer c : customers) {
                bw.write(c.getName() + ": успешных = " + c.getSuccess()
                        + ", неуспешных = " + c.getFailed());
                bw.newLine();
            }

            bw.newLine();
            bw.write("Успешных покупок всего: " + warehouse.getSuccessfulBuys());
            bw.newLine();
            bw.write("Неуспешных покупок всего: " + warehouse.getFailedBuys());
            bw.newLine();
            bw.write("Выручка: " + warehouse.getRevenue());
            bw.newLine();
        }
    }
}