public class RaceCondition {

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== 100 000 инкрементов (гонка данных) ===");
        for (int run = 1; run <= 5; run++) {
            counter = 0;
            runExperiment(100_000);
            System.out.println("Прогон " + run + ": counter = " + counter);
        }

        System.out.println();
        System.out.println("=== 100 инкрементов ===");
        for (int run = 1; run <= 5; run++) {
            counter = 0;
            runExperiment(100);
            System.out.println("Прогон " + run + ": counter = " + counter);
        }
    }

    private static void runExperiment(int iterations) throws InterruptedException {
        Runnable incTask = () -> {
            for (int i = 0; i < iterations; i++) {
                counter++;
            }
        };

        Thread t1 = new Thread(incTask, "Инкремент-1");
        Thread t2 = new Thread(incTask, "Инкремент-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}