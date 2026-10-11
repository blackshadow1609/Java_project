package task2_words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWorker implements Runnable {

    private final String fileName;
    private final GlobalStats global;
    private final StatsMonitor monitor; // может быть null
    private final LongestWord longest = new LongestWord();
    private final WordCounter counter = new WordCounter();

    public FileWorker(String fileName, GlobalStats global, StatsMonitor monitor) {
        this.fileName = fileName;
        this.global = global;
        this.monitor = monitor;
    }

    public LongestWord getLongest() { return longest; }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                counter.process(line);
                longest.process(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения " + fileName + ": " + e.getMessage());
            return;
        }

        global.merge(counter.getFreq());

        if (monitor != null) {
            monitor.fileProcessed();
        }
    }

    public String getFileName() { return fileName; }
}