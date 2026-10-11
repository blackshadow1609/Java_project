public class ThreadTask {

    static class NamedTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Поток " + Thread.currentThread().getName()
                        + ", приоритет = " + Thread.currentThread().getPriority());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable lambdaTask = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Поток " + Thread.currentThread().getName()
                        + ", приоритет = " + Thread.currentThread().getPriority());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable classTask = new NamedTask();

        Runnable lambdaTask2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Поток " + Thread.currentThread().getName()
                        + ", приоритет = " + Thread.currentThread().getPriority());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread t1 = new Thread(lambdaTask,  "Поток-MIN");
        Thread t2 = new Thread(classTask,   "Поток-NORM");
        Thread t3 = new Thread(lambdaTask2, "Поток-MAX");

        t1.setName("Поток-MIN");
        t2.setName("Поток-NORM");
        t3.setName("Поток-MAX");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Все завершились");
    }
}