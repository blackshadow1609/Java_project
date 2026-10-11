package task2_words;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordsMain {

    private static final String[] DICT = {
            "кот", "собака", "дом", "окно", "машина", "дерево", "солнце", "луна",
            "звезда", "море", "река", "гора", "лес", "поле", "трава", "цветок",
            "птица", "рыба", "медведь", "лиса", "заяц", "волк", "тигр", "лев",
            "слон", "жираф", "зебра", "обезьяна", "дельфин", "кит", "акула",
            "человек", "ребёнок", "школа", "учитель", "ученик", "книга", "ручка",
            "тетрадь", "стол", "стул", "дверь", "стена", "пол", "потолок",
            "лампа", "телефон", "компьютер", "программа", "алгоритм"
    };

    private static final int FILES   = 6;
    private static final int WORDS_PER_FILE = 50_000;
    private static final int WORDS_PER_LINE = 10;
    private static final Random RND = new Random(42);

    public static void main(String[] args) throws Exception {

        generateFiles();

        System.out.println("=== Однопоточный режим ===");
        long t1Start = System.currentTimeMillis();
        Map<String, Integer> singleResult = singleThreadedRun();
        long t1End = System.currentTimeMillis();
        long singleTime = t1End - t1Start;
        System.out.println("Время: " + singleTime + " мс");

        System.out.println();
        System.out.println("=== Многопоточный режим ===");
        long t2Start = System.currentTimeMillis();
        Map<String, Integer> multiResult = multiThreadedRun();
        long t2End = System.currentTimeMillis();
        long multiTime = t2End - t2Start;
        System.out.println("Время: " + multiTime + " мс");

        long sumSingle = singleResult.values().stream().mapToLong(Integer::longValue).sum();
        long sumMulti  = multiResult.values().stream().mapToLong(Integer::longValue).sum();

        System.out.println();
        System.out.println("Сумма частот (1 поток): " + sumSingle);
        System.out.println("Сумма частот (6 потоков): " + sumMulti);
        System.out.println("Ожидалось: " + (FILES * WORDS_PER_FILE));

        boolean equal = singleResult.equals(multiResult);
        System.out.println("Результаты совпадают: " + (equal ? "ДА" : "НЕТ"));

        System.out.println("Ускорение: " + String.format("%.2f", (double) singleTime / multiTime) + "x");

        List<Map.Entry<String, Integer>> top = multiResult.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("Топ-10 слов:");
        for (Map.Entry<String, Integer> e : top) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }

        writeTop(top, "top.txt");
        System.out.println("Записано в top.txt");
    }

    private static void generateFiles() throws IOException {
        for (int f = 1; f <= FILES; f++) {
            String name = "book" + f + ".txt";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))) {
                for (int i = 0; i < WORDS_PER_FILE / WORDS_PER_LINE; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int w = 0; w < WORDS_PER_LINE; w++) {
                        sb.append(DICT[RND.nextInt(DICT.length)]);
                        if (w < WORDS_PER_LINE - 1) sb.append(' ');
                    }
                    bw.write(sb.toString());
                    bw.newLine();
                }
            }
        }
        System.out.println("Сгенерировано " + FILES + " файлов по " + WORDS_PER_FILE + " слов.");
    }

    private static Map<String, Integer> singleThreadedRun() throws IOException {
        Map<String, Integer> total = new HashMap<>();
        for (int f = 1; f <= FILES; f++) {
            String name = "book" + f + ".txt";
            WordCounter counter = new WordCounter();
            try (BufferedReader br = new BufferedReader(new FileReader(name))) {
                String line;
                while ((line = br.readLine()) != null) {
                    counter.process(line);
                }
            }
            counter.getFreq().forEach((k, v) -> total.merge(k, v, Integer::sum));
        }
        return total;
    }

    private static Map<String, Integer> multiThreadedRun() throws Exception {
        GlobalStats global = new GlobalStats();
        StatsMonitor monitor = new StatsMonitor(FILES);
        monitor.start();

        List<FileWorker> workers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int f = 1; f <= FILES; f++) {
            FileWorker worker = new FileWorker("book" + f + ".txt", global, monitor);
            Thread t = new Thread(worker, "Worker-" + f);
            workers.add(worker);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) t.join();

        monitor.finish();
        monitor.join();

        return global.snapshot();
    }

    private static void writeTop(List<Map.Entry<String, Integer>> top, String file) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<String, Integer> e : top) {
                bw.write(e.getKey() + ";" + e.getValue());
                bw.newLine();
            }
        }
    }
}