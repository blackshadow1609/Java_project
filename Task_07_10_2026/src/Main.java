public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Задача 1: Loader ===");

        Loader loader = new Loader();
        Thread loaderThread = new Thread(loader, "Загрузчик");
        loaderThread.start();

        Thread.sleep(2000);
        loader.stop();

        loaderThread.join();
        System.out.println("Поток загрузчика завершён (isAlive = "
                + loaderThread.isAlive() + ")");

        System.out.println();
        System.out.println("=== Задача 2 (без synchronized) ===");

        Printer printerNoSync = new Printer(false);

        Thread ivan  = new Thread(() -> printerNoSync.printDocument("Иван"));
        Thread maria = new Thread(() -> printerNoSync.printDocument("Мария"));
        Thread oleg  = new Thread(() -> printerNoSync.printDocument("Олег"));

        ivan.start();
        maria.start();
        oleg.start();

        ivan.join();
        maria.join();
        oleg.join();

        System.out.println();
        System.out.println("=== Задача 2 (с synchronized) ===");

        Printer printerSync = new Printer(true);

        Thread ivan2  = new Thread(() -> printerSync.printDocument("Иван"));
        Thread maria2 = new Thread(() -> printerSync.printDocument("Мария"));
        Thread oleg2  = new Thread(() -> printerSync.printDocument("Олег"));

        ivan2.start();
        maria2.start();
        oleg2.start();

        ivan2.join();
        maria2.join();
        oleg2.join();
    }
}