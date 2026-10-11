package task2_words;

public class StatsMonitor extends Thread {

    private volatile boolean done = false;
    private volatile int processedFiles = 0;
    private final int totalFiles;

    public StatsMonitor(int totalFiles) {
        super("Монитор");
        this.totalFiles = totalFiles;
        setDaemon(true);
    }

    public void fileProcessed() {
        processedFiles++;
    }

    public void finish() {
        done = true;
    }

    @Override
    public void run() {
        while (!done) {
            System.out.println("[Монитор] обработано файлов: "
                    + processedFiles + " / " + totalFiles);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}